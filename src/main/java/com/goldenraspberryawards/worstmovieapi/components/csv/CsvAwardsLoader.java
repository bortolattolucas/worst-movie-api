package com.goldenraspberryawards.worstmovieapi.components.csv;

import com.goldenraspberryawards.worstmovieapi.components.AwardsLoader;
import com.goldenraspberryawards.worstmovieapi.dto.csv.AwardCsvDto;
import com.goldenraspberryawards.worstmovieapi.entities.Award;
import com.goldenraspberryawards.worstmovieapi.entities.Producer;
import com.goldenraspberryawards.worstmovieapi.entities.Studio;
import com.goldenraspberryawards.worstmovieapi.services.AwardService;
import com.goldenraspberryawards.worstmovieapi.services.ProducerService;
import com.goldenraspberryawards.worstmovieapi.services.StudioService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.goldenraspberryawards.worstmovieapi.components.MessageBundle.getMessage;
import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;

@Component
public class CsvAwardsLoader implements AwardsLoader {

    private static final char VALUES_SEPARATOR = ';';
    private static final String RECORDS_REGEX_SEPARATORS = ",\\sand\\s|,and\\s|\\sand\\s|,";
    private static final String WINNER_VALUE = "yes";

    @Value("${awards.file.path:src/main/resources/movielist.csv}")
    private String csvPath;

    private final AwardService awardService;
    private final ProducerService producerService;
    private final StudioService studioService;

    private final Logger logger;

    @Autowired
    public CsvAwardsLoader(AwardService awardService, ProducerService producerService, StudioService studioService) {
        this.awardService = awardService;
        this.producerService = producerService;
        this.studioService = studioService;
        this.logger = LoggerFactory.getLogger(CsvAwardsLoader.class);
    }

    @Override
    @PostConstruct
    public void loadAwards() {
        try {
            List<AwardCsvDto> awardsFromFile = new CsvToBeanBuilder<AwardCsvDto>(new FileReader(csvPath))
                    .withSeparator(VALUES_SEPARATOR).withType(AwardCsvDto.class).build().parse();

            saveAwardsDto(awardsFromFile);
        } catch (IOException e) {
            logger.error(getMessage("file.error"));
        }
    }

    private void saveAwardsDto(List<AwardCsvDto> awardsDto) {
        awardsDto.forEach(awardFromFile -> {
            Award awardToSave = new Award(awardFromFile.getYear(), awardFromFile.getTitle(), WINNER_VALUE.equalsIgnoreCase(awardFromFile.getWinner()));

            loadAwardProducers(awardFromFile, awardToSave);
            loadAwardStudios(awardFromFile, awardToSave);

            awardService.save(awardToSave);
        });
    }

    private void loadAwardProducers(AwardCsvDto awardCsvDto, Award award) {
        List<String> producersNamesFromAwardDto = asList(awardCsvDto.getProducers().split(RECORDS_REGEX_SEPARATORS));

        producersNamesFromAwardDto.forEach(producerName -> {
            Producer producerFound = producerService.findByName(producerName.trim());
            award.getProducers().add(nonNull(producerFound) ? producerFound : producerService.save(new Producer(producerName.trim())));
        });
    }

    private void loadAwardStudios(AwardCsvDto awardCsvDto, Award award) {
        List<String> studiosNamesFromAwardDto = asList(awardCsvDto.getStudios().split(RECORDS_REGEX_SEPARATORS));

        studiosNamesFromAwardDto.forEach(studioName -> {
            Studio studioFound = studioService.findByName(studioName.trim());
            award.getStudios().add(nonNull(studioFound) ? studioFound : studioService.save(new Studio(studioName.trim())));
        });
    }
}

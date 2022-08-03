package com.goldenraspberryawards.worstmovieapi.components.csv;

import com.goldenraspberryawards.worstmovieapi.components.AwardsLoader;
import com.goldenraspberryawards.worstmovieapi.dto.csv.AwardCsvDto;
import com.goldenraspberryawards.worstmovieapi.services.AwardService;
import com.goldenraspberryawards.worstmovieapi.services.ProducerService;
import com.goldenraspberryawards.worstmovieapi.services.StudioService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class CsvAwardsLoader implements AwardsLoader {

    @Value("${awards.file.path:src/main/resources/movielist.csv}")
    private String csvPath;

    private final AwardService awardService;
    private final ProducerService producerService;
    private final StudioService studioService;

    @Autowired
    public CsvAwardsLoader(AwardService awardService, ProducerService producerService, StudioService studioService) {
        this.awardService = awardService;
        this.producerService = producerService;
        this.studioService = studioService;
    }

    @Override
    @PostConstruct
    public void loadAwards() {
        try {
            List<AwardCsvDto> awardsFromFile = new CsvToBeanBuilder<AwardCsvDto>(new FileReader(csvPath)).withSeparator(';').withType(AwardCsvDto.class).build().parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

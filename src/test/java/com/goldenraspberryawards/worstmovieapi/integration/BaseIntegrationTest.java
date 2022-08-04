package com.goldenraspberryawards.worstmovieapi.integration;

import com.goldenraspberryawards.worstmovieapi.dto.ProducerIntervalDto;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"awards.file.path=src/test/resources/movielist.csv"})
public abstract class BaseIntegrationTest {

    protected static ProducerIntervalDto producerWithMinimumWinningInterval;
    protected static ProducerIntervalDto producerWithMaximumWinningInterval;

    protected static String existentProducerName;
    protected static String nonExistentProducerName;

    @BeforeAll
    static void setUp() {
        producerWithMinimumWinningInterval = new ProducerIntervalDto(
                "Joel Silver",
                "1",
                "1990",
                "1991");

        producerWithMaximumWinningInterval = new ProducerIntervalDto(
                "Matthew Vaughn",
                "13",
                "2002",
                "2015");

        existentProducerName = producerWithMinimumWinningInterval.getProducer();
        nonExistentProducerName = "Non Existent Producer Name";
    }
}

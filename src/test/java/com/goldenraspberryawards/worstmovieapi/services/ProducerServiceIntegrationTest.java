package com.goldenraspberryawards.worstmovieapi.services;

import com.goldenraspberryawards.worstmovieapi.dto.ProducerIntervalDto;
import com.goldenraspberryawards.worstmovieapi.integration.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProducerServiceIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private ProducerService producerService;

    @Test
    public void findByNameShouldReturnProducerWhenNameExists() {
        assertNotNull(producerService.findByName(existentProducerName));
    }

    @Test
    public void findByNameShouldReturnNullWhenNameDoesNotExist() {
        assertNull(producerService.findByName(nonExistentProducerName));
    }

    @Test
    public void findIntervalsShouldReturnProducersWithMaximumWinningIntervalsWhenMaximumIsTrue() {
        List<ProducerIntervalDto> intervalsFound = producerService.findIntervals(true);

        assertEquals(1, intervalsFound.size());
        assertEquals(producerWithMaximumWinningInterval, intervalsFound.get(0));
    }

    @Test
    public void findIntervalsShouldReturnProducersWithMinimumWinningIntervalsWhenMaximumIsFalse() {
        List<ProducerIntervalDto> intervalsFound = producerService.findIntervals(false);

        assertEquals(1, intervalsFound.size());
        assertEquals(producerWithMinimumWinningInterval, intervalsFound.get(0));
    }

}

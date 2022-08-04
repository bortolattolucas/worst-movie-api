package com.goldenraspberryawards.worstmovieapi.resources;

import com.goldenraspberryawards.worstmovieapi.dto.ProducerIntervalDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {"awards.file.path=src/test/resources/movielist.csv"})
@AutoConfigureMockMvc
@Transactional
public class ProducerResourceIntegrationTest {

    private static final String PRODUCERS_RESOURCE_PATH = "/producers";
    private static final String FIND_WITH_MAXIMUM_MINIMUM_WINNING_INTERVAL_ENDPOINT = "/max-min-intervals";

    @Autowired
    private MockMvc mockMvc;

    private static ProducerIntervalDto producerWithMinimumWinningInterval;
    private static ProducerIntervalDto producerWithMaximumWinningInterval;

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
    }

    @Test
    public void findProducersWithMaximumAndMinimumWinningIntervalsShouldReturnCorrespondingData() throws Exception {
        ResultActions requestResult = mockMvc.perform(
                get(PRODUCERS_RESOURCE_PATH + FIND_WITH_MAXIMUM_MINIMUM_WINNING_INTERVAL_ENDPOINT)
                        .accept(APPLICATION_JSON));

        requestResult.andExpect(status().isOk());

        requestResult.andExpect(jsonPath("$.min").exists());
        requestResult.andExpect(jsonPath("$.min", hasSize(1)));
        requestResult.andExpect(jsonPath("$.min[0].producer", is(producerWithMinimumWinningInterval.getProducer())));
        requestResult.andExpect(jsonPath("$.min[0].interval", is(producerWithMinimumWinningInterval.getInterval())));
        requestResult.andExpect(jsonPath("$.min[0].previousWin", is(producerWithMinimumWinningInterval.getPreviousWin())));
        requestResult.andExpect(jsonPath("$.min[0].followingWin", is(producerWithMinimumWinningInterval.getFollowingWin())));

        requestResult.andExpect(jsonPath("$.max").exists());
        requestResult.andExpect(jsonPath("$.max", hasSize(1)));
        requestResult.andExpect(jsonPath("$.max[0].producer", is(producerWithMaximumWinningInterval.getProducer())));
        requestResult.andExpect(jsonPath("$.max[0].interval", is(producerWithMaximumWinningInterval.getInterval())));
        requestResult.andExpect(jsonPath("$.max[0].previousWin", is(producerWithMaximumWinningInterval.getPreviousWin())));
        requestResult.andExpect(jsonPath("$.max[0].followingWin", is(producerWithMaximumWinningInterval.getFollowingWin())));
    }
}

package com.goldenraspberryawards.worstmovieapi.dto.csv;

import com.opencsv.bean.CsvBindByName;

public class AwardCsvDto {

    @CsvBindByName(column = "year")
    private Long year;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "studios")
    private String studios;

    @CsvBindByName(column = "producers")
    private String producers;

    @CsvBindByName(column = "winner")
    private String winner;

    public Long getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getStudios() {
        return studios;
    }

    public String getProducers() {
        return producers;
    }

    public String getWinner() {
        return winner;
    }
}

package com.goldenraspberryawards.worstmovieapi.dto;

import java.util.Objects;

public class ProducerIntervalDto {

    private String producer;
    private String interval;
    private String previousWin;
    private String followingWin;

    public ProducerIntervalDto() {
    }

    public ProducerIntervalDto(String producer, String interval, String previousWin, String followingWin) {
        this.producer = producer;
        this.interval = interval;
        this.previousWin = previousWin;
        this.followingWin = followingWin;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getPreviousWin() {
        return previousWin;
    }

    public void setPreviousWin(String previousWin) {
        this.previousWin = previousWin;
    }

    public String getFollowingWin() {
        return followingWin;
    }

    public void setFollowingWin(String followingWin) {
        this.followingWin = followingWin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProducerIntervalDto)) return false;
        ProducerIntervalDto that = (ProducerIntervalDto) o;
        return Objects.equals(getProducer(), that.getProducer()) && Objects.equals(getInterval(), that.getInterval())
                && Objects.equals(getPreviousWin(), that.getPreviousWin()) && Objects.equals(getFollowingWin(), that.getFollowingWin());
    }
}

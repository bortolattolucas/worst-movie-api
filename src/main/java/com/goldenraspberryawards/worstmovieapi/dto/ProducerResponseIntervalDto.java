package com.goldenraspberryawards.worstmovieapi.dto;

import java.io.Serializable;
import java.util.List;

public class ProducerResponseIntervalDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ProducerIntervalDto> min;
    private List<ProducerIntervalDto> max;

    public ProducerResponseIntervalDto() {
    }

    public ProducerResponseIntervalDto(List<ProducerIntervalDto> min, List<ProducerIntervalDto> max) {
        this.min = min;
        this.max = max;
    }

    public List<ProducerIntervalDto> getMin() {
        return min;
    }

    public void setMin(List<ProducerIntervalDto> min) {
        this.min = min;
    }

    public List<ProducerIntervalDto> getMax() {
        return max;
    }

    public void setMax(List<ProducerIntervalDto> max) {
        this.max = max;
    }
}

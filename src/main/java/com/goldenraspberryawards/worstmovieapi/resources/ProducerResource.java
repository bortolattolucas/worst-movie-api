package com.goldenraspberryawards.worstmovieapi.resources;

import com.goldenraspberryawards.worstmovieapi.dto.ProducerResponseIntervalDto;
import com.goldenraspberryawards.worstmovieapi.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producers")
public class ProducerResource {

    private final ProducerService producerService;

    @Autowired
    public ProducerResource(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping(value = "/intervals")
    public ResponseEntity<ProducerResponseIntervalDto> findMaxIntervals() {
        return ResponseEntity.ok(new ProducerResponseIntervalDto(
                producerService.findIntervals(false),
                producerService.findIntervals(true)
        ));
    }
}

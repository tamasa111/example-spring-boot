package com.koyeb.rayshan.controllers;

import com.koyeb.rayshan.services.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    private TestService service;

    public TestController(TestService testService) {
        this.service = testService;
    }

    @GetMapping("/")
    public Mono<String> hello() {
        log.info("Request received >>>>>>");
        return service.getTestResult();
    }

    @GetMapping("/test2")
    public Mono<String> test2() {
        log.info("Request test2 received >>>>>>");
        return service.getTestResult();
    }
}

package com.zair.infrastructure.adapters.in.rest.controllers;

import com.zair.application.ports.in.ApplicationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApplicationController.BASE_PATH)
@RequiredArgsConstructor
public class ApplicationController {
    static final String BASE_PATH = "/application";

    private final ApplicationUseCase useCase;

    @PostMapping("/execute")
    public ResponseEntity<?> execute() {
        log.info("Received request to execute application");

        useCase.execute();

        return ResponseEntity.ok().build();
    }
}

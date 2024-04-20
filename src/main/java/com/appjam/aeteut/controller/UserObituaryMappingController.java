package com.appjam.aeteut.controller;

import com.appjam.aeteut.dto.userobituarymapping.UserObituaryMappingRequestDto;
import com.appjam.aeteut.service.UserObituaryMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-obituary-mappings")
@RequiredArgsConstructor
public class UserObituaryMappingController {

    private final UserObituaryMappingService userObituaryMappingService;

    @PostMapping
    public ResponseEntity<Void> createMapping(@RequestBody UserObituaryMappingRequestDto userObituaryMappingRequestDto) {
        userObituaryMappingService.createMapping(userObituaryMappingRequestDto);

        return ResponseEntity.noContent().build();
    }
}

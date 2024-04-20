package com.appjam.aeteut.controller;

import com.appjam.aeteut.dto.obituary.ObituaryRequestDto;
import com.appjam.aeteut.dto.obituary.ObituaryResponseDto;
import com.appjam.aeteut.service.ObituaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obituaries")
@RequiredArgsConstructor
public class ObituaryController {

    private final ObituaryService obituaryService;

    @GetMapping
    public ResponseEntity<List<ObituaryResponseDto>> getAllObituaries() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(obituaryService.getAllObituaries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObituaryResponseDto> getObituaryById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(obituaryService.getObituaryById(id));
    }

    @PostMapping
    public ResponseEntity<ObituaryResponseDto> createObituary(@RequestBody ObituaryRequestDto obituaryRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(obituaryService.createObituary(obituaryRequestDto));
    }
}

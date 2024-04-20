package com.appjam.aeteut.controller;

import com.appjam.aeteut.dto.letter.LetterRequestDto;
import com.appjam.aeteut.dto.letter.LetterResponseDto;
import com.appjam.aeteut.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letters")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LetterController {

    private final LetterService letterService;

    @GetMapping
    public ResponseEntity<List<LetterResponseDto>> getAllLetters() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(letterService.getAllLetters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetterResponseDto> getLetterById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(letterService.getLetterById(id));
    }

    @PostMapping
    public ResponseEntity<LetterResponseDto> createLetter(@RequestBody LetterRequestDto letterRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(letterService.createLetter(letterRequestDto));
    }
}

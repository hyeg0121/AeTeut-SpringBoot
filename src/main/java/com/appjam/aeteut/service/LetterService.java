package com.appjam.aeteut.service;

import com.appjam.aeteut.domain.Letter;
import com.appjam.aeteut.domain.User;
import com.appjam.aeteut.dto.letter.LetterRequestDto;
import com.appjam.aeteut.dto.letter.LetterResponseDto;
import com.appjam.aeteut.exception.UserNotFoundException;
import com.appjam.aeteut.repository.LetterRepository;
import com.appjam.aeteut.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository letterRepository;
    private final UserRepository userRepository;

    public List<LetterResponseDto> getAllLetters() {
        return letterRepository.findAll()
                .stream()
                .map(LetterResponseDto::from)
                .collect(Collectors.toList());
    }

    public LetterResponseDto getLetterById(Long id) {
        Letter letter = letterRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return LetterResponseDto.from(letter);
    }

    public LetterResponseDto createLetter(LetterRequestDto letterRequestDto) {
        User user = userRepository.findById(letterRequestDto.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Letter savedLetter = letterRepository.save(
                Letter.builder()
                        .user(user)
                        .toName(letterRequestDto.getToName())
                        .content(letterRequestDto.getContent())
                        .build()
        );

        return LetterResponseDto.from(savedLetter);
    }
}

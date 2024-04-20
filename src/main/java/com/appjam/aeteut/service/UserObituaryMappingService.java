package com.appjam.aeteut.service;

import com.appjam.aeteut.domain.Obituary;
import com.appjam.aeteut.domain.User;
import com.appjam.aeteut.domain.UserObituaryMapping;
import com.appjam.aeteut.dto.userobituarymapping.UserObituaryMappingRequestDto;
import com.appjam.aeteut.exception.ObituaryNotFoundException;
import com.appjam.aeteut.exception.UserNotFoundException;
import com.appjam.aeteut.exception.UserObituaryMappingAlreadyExistException;
import com.appjam.aeteut.repository.ObituaryRepository;
import com.appjam.aeteut.repository.UserObituararyMappingRepository;
import com.appjam.aeteut.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserObituaryMappingService {

    private final UserObituararyMappingRepository userObituararyMappingRepository;
    private final UserRepository userRepository;
    private final ObituaryRepository obituaryRepository;

    public void createMapping(UserObituaryMappingRequestDto userObituaryMappingRequestDto) {
        Long userId = userObituaryMappingRequestDto.getUserId();
        Long obituaryId = userObituaryMappingRequestDto.getObituaryId();

        if (userObituararyMappingRepository.existsByUserIdAndObituaryId(userId, obituaryId)) {
            throw UserObituaryMappingAlreadyExistException.EXCEPTION;
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Obituary obituary = obituaryRepository.findById(obituaryId)
                .orElseThrow(() -> ObituaryNotFoundException.EXCEPTION);

        userObituararyMappingRepository.save(
                UserObituaryMapping.builder()
                        .user(user)
                        .obituary(obituary)
                        .build()
        );
    }
}

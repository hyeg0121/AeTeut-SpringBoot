package com.appjam.aeteut.service;

import com.appjam.aeteut.domain.Obituary;
import com.appjam.aeteut.domain.User;
import com.appjam.aeteut.domain.UserObituaryMapping;
import com.appjam.aeteut.dto.userobituarymapping.UserObituaryMappingRequestDto;
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
            throw new IllegalArgumentException("이미 존재하는 매핑");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        Obituary obituary = obituaryRepository.findById(obituaryId)
                .orElseThrow(() -> new IllegalArgumentException("부고장이 아직 존재하지 않습니다."));

        UserObituaryMapping userObituaryMapping = userObituararyMappingRepository.save(
                UserObituaryMapping.builder()
                        .user(user)
                        .obituary(obituary)
                        .build()
        );
    }
}

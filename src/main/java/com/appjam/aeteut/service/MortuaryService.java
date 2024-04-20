package com.appjam.aeteut.service;

import com.appjam.aeteut.domain.Mortuary;
import com.appjam.aeteut.dto.mortuary.MortuaryRequestDto;
import com.appjam.aeteut.dto.mortuary.MortuaryResponseDto;
import com.appjam.aeteut.repository.MortuaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MortuaryService {
    private final MortuaryRepository mortuaryRepository;

    public MortuaryResponseDto createMortuary(MortuaryRequestDto mortuaryRequestDto) {
        Mortuary mortuary = mortuaryRepository.save(
                Mortuary.builder()
                        .name(mortuaryRequestDto.getName())
                        .lat(mortuaryRequestDto.getLat())
                        .lng(mortuaryRequestDto.getLng())
                        .build()
        );

        return MortuaryResponseDto.from(mortuary);
    }
}

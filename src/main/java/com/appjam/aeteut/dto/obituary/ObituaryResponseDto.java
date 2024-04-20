package com.appjam.aeteut.dto.obituary;



import com.appjam.aeteut.domain.Obituary;
import com.appjam.aeteut.dto.mortuary.MortuaryResponseDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

public record ObituaryResponseDto (Long id,
                                   MortuaryResponseDto mortuaryResponseDto,
                                   String name,
                                   String PhoneNumber,
                                   @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime date,
                                   @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime createdAt
                                   ) {

    @Builder
    public ObituaryResponseDto(Long id, MortuaryResponseDto mortuaryResponseDto, String name, String PhoneNumber, @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime date, @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime createdAt) {
        this.id = id;
        this.mortuaryResponseDto = mortuaryResponseDto;
        this.name = name;
        this.PhoneNumber = PhoneNumber;
        this.date = date;
        this.createdAt = createdAt;
    }

    public static ObituaryResponseDto from(Obituary obituary) {
        return ObituaryResponseDto.builder()
                .mortuaryResponseDto(MortuaryResponseDto.from(obituary.getMortuary()))
                .id(obituary.getId())
                .name(obituary.getName())
                .PhoneNumber(obituary.getPhoneNumber())
                .date(obituary.getDate())
                .createdAt(obituary.getCreatedAt())
                .build();
    }

}

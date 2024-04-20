package com.appjam.aeteut.dto.mortuary;

import com.appjam.aeteut.domain.Mortuary;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;


public record MortuaryResponseDto(Long id,
                                  String name,
                                  Double lat,
                                  Double lng,
                                  @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime createdAt) {

    @Builder
    public MortuaryResponseDto(Long id, String name, Double lat, Double lng, @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.createdAt = createdAt;
    }

    public static MortuaryResponseDto from(Mortuary mortuary) {
        return MortuaryResponseDto.builder()
                .id(mortuary.getId())
                .name(mortuary.getName())
                .lat(mortuary.getLat())
                .lng(mortuary.getLng())
                .createdAt(mortuary.getCreatedAt())
                .build();
    }
}

package com.appjam.aeteut.dto.mortuary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MortuaryRequestDto {
    private String name;
    private Double lat;
    private Double lng;
}

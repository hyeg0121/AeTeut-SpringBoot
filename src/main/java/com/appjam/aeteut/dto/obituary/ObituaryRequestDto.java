package com.appjam.aeteut.dto.obituary;

import com.appjam.aeteut.dto.mortuary.MortuaryRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ObituaryRequestDto {
    private MortuaryRequestDto mortuary;
    private Long userId;
    private String name;
    private String phoneNumber;
    private String date;
}

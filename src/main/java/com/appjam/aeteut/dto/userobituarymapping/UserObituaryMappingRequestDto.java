package com.appjam.aeteut.dto.userobituarymapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserObituaryMappingRequestDto {
    private Long userId;
    private Long obituaryId;
}

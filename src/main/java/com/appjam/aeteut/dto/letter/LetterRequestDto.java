package com.appjam.aeteut.dto.letter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LetterRequestDto {
    private Long userId;
    private String toName;
    private String content;
}

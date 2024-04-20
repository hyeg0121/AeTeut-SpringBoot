package com.appjam.aeteut.dto.letter;

import com.appjam.aeteut.domain.Letter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

public record LetterResponseDto(Long id,
                                String toName,
                                String content,
                                @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime createdAt) {

    @Builder
    public LetterResponseDto(Long id, String toName, String content, @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime createdAt) {
        this.id = id;
        this.toName = toName;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static LetterResponseDto from(Letter letter) {
        return LetterResponseDto.builder()
                .id(letter.getId())
                .toName(letter.getToName())
                .content(letter.getContent())
                .createdAt(letter.getCreatedAt())
                .build();
    }


}

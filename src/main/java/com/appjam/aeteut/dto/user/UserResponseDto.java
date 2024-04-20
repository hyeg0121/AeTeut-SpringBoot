package com.appjam.aeteut.dto.user;

import com.appjam.aeteut.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

public record UserResponseDto(Long id, String name, String email,
                              @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime createdAt) {
    @Builder
    public UserResponseDto(Long id, String name, String email, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}

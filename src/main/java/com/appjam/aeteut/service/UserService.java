package com.appjam.aeteut.service;

import com.appjam.aeteut.domain.User;
import com.appjam.aeteut.domain.UserObituaryMapping;
import com.appjam.aeteut.dto.letter.LetterResponseDto;
import com.appjam.aeteut.dto.obituary.ObituaryResponseDto;
import com.appjam.aeteut.dto.user.UserRequestDto;
import com.appjam.aeteut.dto.user.UserResponseDto;
import com.appjam.aeteut.repository.UserObituararyMappingRepository;
import com.appjam.aeteut.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserObituararyMappingRepository userObituararyMappingRepository;

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        return UserResponseDto.from(user);
    }

    public UserResponseDto loginUser(UserRequestDto userRequestDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userRequestDto.getEmail());
        User user = optionalUser.orElseGet(() -> saveUser(userRequestDto));
        return UserResponseDto.from(user);
    }

    public User saveUser(UserRequestDto userRequestDto) {
        User savedUser = User.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .build();
        return userRepository.save(savedUser);
    }

    public List<ObituaryResponseDto> getUsersAllObituaries(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        List<UserObituaryMapping> userObituaryMappings = userObituararyMappingRepository.findByUserId(id);

        return userObituaryMappings
                .stream()
                .map((item) -> ObituaryResponseDto.from(item.getObituary()))
                .collect(Collectors.toList());
    }

    public List<LetterResponseDto> getUsersAllLetters(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        return user.getLetters()
                .stream()
                .map(LetterResponseDto::from)
                .collect(Collectors.toList());
    }

}

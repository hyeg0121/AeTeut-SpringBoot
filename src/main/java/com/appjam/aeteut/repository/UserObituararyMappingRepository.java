package com.appjam.aeteut.repository;

import com.appjam.aeteut.domain.UserObituaryMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserObituararyMappingRepository extends JpaRepository<UserObituaryMapping, Long> {
    List<UserObituaryMapping> findByUserId(Long userId);
    boolean existsByUserIdAndObituaryId(Long userId, Long obituaryId);
}

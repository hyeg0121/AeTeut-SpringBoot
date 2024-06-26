package com.appjam.aeteut.repository;

import com.appjam.aeteut.domain.Obituary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObituaryRepository extends JpaRepository<Obituary, Long> {
}

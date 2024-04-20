package com.appjam.aeteut.repository;

import com.appjam.aeteut.domain.Mortuary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortuaryRepository extends JpaRepository<Mortuary, Long> {
}

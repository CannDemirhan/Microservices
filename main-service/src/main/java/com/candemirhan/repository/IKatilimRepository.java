package com.candemirhan.repository;

import com.candemirhan.repository.entity.Katilim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKatilimRepository extends JpaRepository<Katilim, Long> {
}

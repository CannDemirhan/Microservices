package com.candemirhan.repository;

import com.candemirhan.repository.entity.DereceYapanlar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDereceYapanlarRepository extends JpaRepository<DereceYapanlar, Long> {
}

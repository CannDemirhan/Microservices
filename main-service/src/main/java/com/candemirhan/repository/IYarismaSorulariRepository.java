package com.candemirhan.repository;

import com.candemirhan.repository.entity.YarismaSorulari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IYarismaSorulariRepository extends JpaRepository<YarismaSorulari, Long> {
}

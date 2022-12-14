package com.candemirhan.repository;

import com.candemirhan.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth, Long> {
    /**
     * - Kullanıcı adı case-sens olmamalıdır.
     * - Şifre case-sens olmalıdır.
     */
    Optional<Auth> findOptionalAuthByUsernameIgnoreCaseAndPassword(String username, String password);

    @Query("SELECT COUNT(a)>0 FROM Auth a WHERE UPPER(a.username) = UPPER(?1) AND a.password = ?2")
    Boolean isExist(String username, String password);
}

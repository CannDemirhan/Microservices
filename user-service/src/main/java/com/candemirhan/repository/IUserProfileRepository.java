package com.candemirhan.repository;

import com.candemirhan.repository.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfile,Long> {

    @Query("select COUNT(a)>0 from UserProfile a where  a.authOid = ?1")
    Boolean isExists(Long authOid);

    Optional<UserProfile> findUserProfileByAuthOid(Long authOid);
}

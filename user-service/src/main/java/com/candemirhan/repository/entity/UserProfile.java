package com.candemirhan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tbluserprofile")
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private Long authOid;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String photo;
    @Column(length = 200)
    private String address;
    @Column(length = 1000)
    private String about;

    private Long createdAt;
    private Long updatedAt;
}

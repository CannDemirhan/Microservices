package com.candemirhan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.candemirhan.repository.enums.Roles;

import javax.persistence.*;

@Table(name = "tblauth")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String username;
    private String password;
    private Roles role;
}

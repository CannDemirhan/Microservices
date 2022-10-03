package com.candemirhan.dto.request.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EditProfileRequestDto {

    private String username;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String photo;
    private String address;
    private String about;
    @NotNull
    private String token;
}
package com.candemirhan.dto.request.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.candemirhan.repository.enums.Roles;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Kullanıcı adı enaz 3 karater ve en fazla 20 karakter olabilir.")
    private String username;
    @NotNull
    private String password;
    @NotNull
    @Email(message = "Email formatı uygun değil.")
    private String email;
    Roles role;
    private String RoleAdminPassword;
}

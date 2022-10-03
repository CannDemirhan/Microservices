package com.candemirhan.dto.request.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewUserCreateDto {

    private Long authOid;
    private String username;
    private String email;
}

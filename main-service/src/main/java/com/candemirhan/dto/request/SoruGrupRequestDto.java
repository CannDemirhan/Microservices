package com.candemirhan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoruGrupRequestDto {

    @NotNull
    @Size(min = 16)
    private String token;
    @NotBlank
    @NotEmpty
    @NotNull
    private String grupAdi;
}

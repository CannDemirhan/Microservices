package com.candemirhan.controller;

import com.candemirhan.dto.request.SoruGrupRequestDto;
import com.candemirhan.exception.ErrorType;
import com.candemirhan.exception.MainManagerException;
import com.candemirhan.repository.entity.SoruGrubu;
import com.candemirhan.service.SoruGrubuService;
import com.candemirhan.util.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.candemirhan.constants.ApiUrls.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(BASE_URL+MAIN+SORU_GRUP)
@RequiredArgsConstructor
public class SoruGrupController {

    private final JwtTokenManager jwtTokenManager;
    private final SoruGrubuService soruGrubuService;

    @PostMapping(CREATE_SORU_GRUP)
    public ResponseEntity<SoruGrubu> createSoruGrup(@RequestBody @Valid SoruGrupRequestDto dto){
        try {
            Optional<Long> userid = jwtTokenManager.getUserOid(dto.getToken());
            if(userid.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(soruGrubuService.save(SoruGrubu.builder()
                            .grupadi(dto.getGrupAdi())
                    .build()));
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}

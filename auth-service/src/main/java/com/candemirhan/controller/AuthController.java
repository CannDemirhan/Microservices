package com.candemirhan.controller;

import static com.candemirhan.constants.ApiUrls.*;
import com.candemirhan.dto.request.request.DoLoginRequestDto;
import com.candemirhan.dto.request.request.RegisterRequestDto;
import com.candemirhan.repository.entity.Auth;
import com.candemirhan.util.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import com.candemirhan.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(BASE_URL + AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto registerRequestDto){
        authService.register(registerRequestDto);
        return ResponseEntity.ok().build();
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto doLoginRequestDto){
        Optional<Auth> authOptional = authService.doLogin(doLoginRequestDto);
        if(authOptional.isPresent()){
            String token = jwtTokenManager.createToken(authOptional.get().getOid()).get();
            return ResponseEntity.ok(token);
        }else{
            return  ResponseEntity.badRequest().body("Giriş Başarısız");
        }
    }
    @GetMapping("/test")
    public String getTestString(){
        return "Auth Test";
    }
}

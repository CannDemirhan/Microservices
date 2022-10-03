package com.candemirhan.service;

import com.candemirhan.dto.request.request.DoLoginRequestDto;
import com.candemirhan.dto.request.request.NewUserCreateDto;
import com.candemirhan.dto.request.request.RegisterRequestDto;
import com.candemirhan.manager.IUserManager;
import com.candemirhan.repository.IAuthRepository;
import com.candemirhan.repository.entity.Auth;
import com.candemirhan.repository.enums.Roles;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long>{ //etends ServiceManager

    private final IAuthRepository authRepository;
    private final IUserManager userManager;

    public AuthService(IAuthRepository authRepository,IUserManager userManager){
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
    }

    public Auth register(RegisterRequestDto dto){
        Auth auth;
        auth = Auth.builder()
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build();
        if(dto.getRoleAdminPassword()!=null)
            if(dto.getRoleAdminPassword().equals("123456"))
                auth.setRole(dto.getRole()==null ? Roles.ADMIN : dto.getRole());
            else
                auth.setRole(Roles.USER);

        save(auth);
        userManager.NewUserCreate(
                NewUserCreateDto.builder()
                        .authOid(auth.getOid())
                        .email(dto.getEmail())
                        .username(auth.getUsername())
                        .build()
        );
        return auth;
    }
    public Optional<Auth> doLogin(DoLoginRequestDto doLoginRequestDto){
        //return !authRepository.findAuthByUsernameIgnoreCaseAndPassword(doLoginRequestDto.getUsername(),doLoginRequestDto.getPassword()).isEmpty();
        return authRepository.findOptionalAuthByUsernameIgnoreCaseAndPassword(doLoginRequestDto.getUsername(),doLoginRequestDto.getPassword());
    }
}

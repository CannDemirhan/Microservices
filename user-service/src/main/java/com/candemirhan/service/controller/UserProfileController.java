package com.candemirhan.service.controller;

import com.candemirhan.dto.request.request.EditProfileRequestDto;
import com.candemirhan.dto.request.request.NewUserCreateDto;
import com.candemirhan.exception.ErrorType;
import com.candemirhan.exception.UserManagerException;
import com.candemirhan.service.UserProfileService;
import com.candemirhan.util.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Optional;

import static com.candemirhan.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(NEW_USER_CREATE)
    public ResponseEntity<Boolean> NewCreateUser(@RequestBody @Valid NewUserCreateDto newUserCreateDto){
        try{
            userProfileService.newCreateUser(newUserCreateDto);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            throw new UserManagerException(ErrorType.USER_DONT_CREATE);
        }
    }
    @PostMapping(UPDATE_USERPROFILE)
    public ResponseEntity<Boolean> updateUserProfile(@RequestBody @Valid EditProfileRequestDto editProfileRequestDto){
        if(editProfileRequestDto.getToken() == null)
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        try{
            Optional<Long> authOid = jwtTokenManager.getUserOid(editProfileRequestDto.getToken());
            if(authOid.isEmpty()) throw new UserManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(userProfileService.updateUserProfile(editProfileRequestDto,authOid.get()));
        }catch (Exception ex){
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}

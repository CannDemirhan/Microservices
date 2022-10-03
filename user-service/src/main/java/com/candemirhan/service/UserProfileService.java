package com.candemirhan.service;

import com.candemirhan.dto.request.request.EditProfileRequestDto;
import com.candemirhan.dto.request.request.NewUserCreateDto;
import com.candemirhan.mapper.IUserProfileMapper;
import com.candemirhan.repository.IUserProfileRepository;
import com.candemirhan.repository.entity.UserProfile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {

    private final IUserProfileRepository userProfileRepository;

    public UserProfileService(IUserProfileRepository userProfileRepository){
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile newCreateUser(NewUserCreateDto newUserCreateDto){
        return save(UserProfile.builder()
                .username(newUserCreateDto.getUsername())
                .email(newUserCreateDto.getEmail())
                .authOid(newUserCreateDto.getAuthOid())
                .build());
    }

    public Boolean updateUserProfile(EditProfileRequestDto editProfileRequestDto, Long authOid)
    {
        UserProfile userProfile = IUserProfileMapper.INSTANCE.toUserProfile(editProfileRequestDto);
        Optional<UserProfile> userProfileOptional = userProfileRepository.findUserProfileByAuthOid(authOid);
        if(userProfileOptional.isEmpty()) return false;
        try{
            userProfile.setOid(userProfileOptional.get().getOid());
            update(userProfile);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}

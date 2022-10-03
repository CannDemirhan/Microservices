package com.candemirhan.mapper;

import com.candemirhan.dto.request.request.EditProfileRequestDto;
import com.candemirhan.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    UserProfile toUserProfile(final EditProfileRequestDto editProfileRequestDto);
    EditProfileRequestDto fromUserProfile(final UserProfile userProfile);
}

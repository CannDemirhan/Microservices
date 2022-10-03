package com.candemirhan.service;

import com.candemirhan.dto.request.DoLoginRequestDto;
import com.candemirhan.dto.request.RegisterRequestDto;
import com.candemirhan.mapper.IUserMapper;
import com.candemirhan.repository.IUserRepository;
import com.candemirhan.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> {
    private final IUserRepository userRepository;



    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public Optional<User> doLogin(DoLoginRequestDto doLoginRequestDto) {
        return userRepository.findByUsernameAndPassword(doLoginRequestDto.getUsername(), doLoginRequestDto.getPassword());
    }

    /**
     *
     * @param dto
     * @return Eğer kullanıcı kayıtlı ise kayıt yapılamayıp false döner.
     */
    public boolean register(RegisterRequestDto dto){
        Optional<User> user = userRepository.findByUsername(dto.getUsername());
        if(user.isPresent()) return false;
        /*
        userRepository.save(User.builder()
                        .adsoyad(dto.getAdsoyad())
                        .username(dto.getUsername())
                        .password(dto.getPassword())
                .build());
                */
        save(IUserMapper.INSTANCE.toUser(dto));
        return true;
    }
}

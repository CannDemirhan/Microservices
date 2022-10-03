package com.candemirhan.service;

import com.candemirhan.repository.IYarismaSorulariRepository;
import com.candemirhan.repository.entity.YarismaSorulari;
import org.springframework.stereotype.Service;

@Service
public class YarismaSorulariService extends ServiceManager<YarismaSorulari,Long> {
    private final IYarismaSorulariRepository yarismaSorulariRepository;

    public YarismaSorulariService(IYarismaSorulariRepository yarismaSorulariRepository) {
        super(yarismaSorulariRepository);
        this.yarismaSorulariRepository = yarismaSorulariRepository;
    }
}

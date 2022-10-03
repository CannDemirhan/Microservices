package com.candemirhan.service;

import com.candemirhan.repository.IKatilimRepository;
import com.candemirhan.repository.entity.Katilim;
import org.springframework.stereotype.Service;

@Service
public class KatilimService extends ServiceManager<Katilim,Long> {
    private final IKatilimRepository katilimRepository;

    public KatilimService(IKatilimRepository katilimRepository) {
        super(katilimRepository);
        this.katilimRepository = katilimRepository;
    }
}

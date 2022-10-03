package com.candemirhan.service;

import com.candemirhan.repository.IGoruntulenmeRepository;
import com.candemirhan.repository.entity.Goruntulenme;
import org.springframework.stereotype.Service;

@Service
public class GoruntulenmeService extends ServiceManager<Goruntulenme,Long> {
    private final IGoruntulenmeRepository goruntulenmeRepository;

    public GoruntulenmeService(IGoruntulenmeRepository goruntulenmeRepository) {
        super(goruntulenmeRepository);
        this.goruntulenmeRepository = goruntulenmeRepository;
    }

}

package com.candemirhan.service;

import com.candemirhan.repository.IDereceYapanlarRepository;
import com.candemirhan.repository.entity.DereceYapanlar;
import org.springframework.stereotype.Service;

@Service
public class DereceYapanlarService extends ServiceManager<DereceYapanlar,Long> {
    private final IDereceYapanlarRepository dereceYapanlarRepository;

    public DereceYapanlarService(IDereceYapanlarRepository dereceYapanlarRepository) {
        super(dereceYapanlarRepository);
        this.dereceYapanlarRepository = dereceYapanlarRepository;
    }
}

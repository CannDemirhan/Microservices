package com.candemirhan.service;

import com.candemirhan.repository.ISoruGrubuRepository;
import com.candemirhan.repository.entity.SoruGrubu;
import org.springframework.stereotype.Service;

@Service
public class SoruGrubuService extends ServiceManager<SoruGrubu,Long> {
    private final ISoruGrubuRepository soruGrubuRepository;

    public SoruGrubuService(ISoruGrubuRepository soruGrubuRepository) {
        super(soruGrubuRepository);
        this.soruGrubuRepository = soruGrubuRepository;
    }
}

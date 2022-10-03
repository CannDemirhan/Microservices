package com.candemirhan.service;

import com.candemirhan.repository.IYarismaRepository;
import com.candemirhan.repository.entity.Yarisma;
import org.springframework.stereotype.Service;

@Service
public class YarismaService extends ServiceManager<Yarisma,Long> {
    private final IYarismaRepository yarismaRepository;

    public YarismaService(IYarismaRepository yarismaRepository) {
        super(yarismaRepository);
        this.yarismaRepository = yarismaRepository;
    }
}

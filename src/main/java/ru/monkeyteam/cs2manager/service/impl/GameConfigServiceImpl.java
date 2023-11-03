package ru.monkeyteam.cs2manager.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.monkeyteam.cs2manager.domain.GameConfig;
import ru.monkeyteam.cs2manager.repository.GameConfigRepository;
import ru.monkeyteam.cs2manager.service.GameConfigService;

@Log4j2
@Service
@RequiredArgsConstructor
public class GameConfigServiceImpl implements GameConfigService {

    private final GameConfigRepository gameConfigRepository;

    @Override
    public Iterable<GameConfig> findGameConfig() {
        return gameConfigRepository.findAll();
    }

    @Override
    public GameConfig findGameConfigByName(String name) {
        return gameConfigRepository.findByName(name).orElseThrow();
    }

}

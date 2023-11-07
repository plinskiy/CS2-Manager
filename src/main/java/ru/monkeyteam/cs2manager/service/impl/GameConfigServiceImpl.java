package ru.monkeyteam.cs2manager.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.monkeyteam.cs2manager.domain.GameConfig;
import ru.monkeyteam.cs2manager.model.GameConfigRequest;
import ru.monkeyteam.cs2manager.repository.GameConfigRepository;
import ru.monkeyteam.cs2manager.service.GameConfigService;

import java.util.Optional;

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
    public Optional<GameConfig> findGameConfigByName(String name) {
        return gameConfigRepository.findByName(name);
    }

    @Override
    public GameConfig create(GameConfigRequest request) {
        return gameConfigRepository.save(GameConfig.builder()
                                        .name(request.getName())
                                        .command(request.getCommand())
                                        .build());
    }

    @Override
    public GameConfig update(GameConfigRequest request) {
        return gameConfigRepository.save(GameConfig.builder()
                        .id(request.getId())
                        .name(request.getName())
                        .command(request.getCommand())
                        .build());
    }

    @Override
    public void delete(GameConfig gameConfig) {
        gameConfigRepository.delete(gameConfig);
    }
}

package ru.monkeyteam.cs2manager.service;

import ru.monkeyteam.cs2manager.domain.GameConfig;
import ru.monkeyteam.cs2manager.model.GameConfigRequest;

import java.util.Optional;

public interface GameConfigService {

    Iterable<GameConfig> findGameConfig();

    Optional<GameConfig> findGameConfigByName(String name);

    GameConfig create(GameConfigRequest request);

    GameConfig update(GameConfigRequest request);

    void delete(GameConfig gameConfig);

    void exec(GameConfigRequest request);

}

package ru.monkeyteam.cs2manager.service;

import ru.monkeyteam.cs2manager.domain.GameConfig;

public interface GameConfigService {

    Iterable<GameConfig> findGameConfig();

    GameConfig findGameConfigByName(String name);

}

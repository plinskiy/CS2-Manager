package ru.monkeyteam.cs2manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.monkeyteam.cs2manager.domain.GameConfig;
import ru.monkeyteam.cs2manager.service.GameConfigService;

@Log4j2
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GameConfigController {

    private final GameConfigService gameConfigService;

    @GetMapping("/game-config")
    public ResponseEntity<Iterable<GameConfig>> getGameConfig() {
        Iterable<GameConfig> gameConfigs = gameConfigService.findGameConfig();
        return ResponseEntity.ok(gameConfigs);
    }

    @GetMapping("/game-config/{name}")
    public ResponseEntity<GameConfig> getGameConfigByName(@PathVariable String name) {
        GameConfig gameConfig = gameConfigService.findGameConfigByName(name);
        return ResponseEntity.ok(gameConfig);
    }

}

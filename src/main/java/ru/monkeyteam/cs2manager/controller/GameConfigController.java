package ru.monkeyteam.cs2manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.monkeyteam.cs2manager.domain.GameConfig;
import ru.monkeyteam.cs2manager.model.GameConfigRequest;
import ru.monkeyteam.cs2manager.service.GameConfigService;

import java.util.Optional;

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
        GameConfig gameConfig = gameConfigService.findGameConfigByName(name).orElseThrow();
        return ResponseEntity.ok(gameConfig);
    }

    @PostMapping("/game-config")
    public ResponseEntity<GameConfig> createGameConfig(@RequestBody GameConfigRequest request) {
        GameConfig gameConfig = gameConfigService.create(request);
        return ResponseEntity.ok(gameConfig);
    }

    @PutMapping("/game-config")
    public ResponseEntity<GameConfig> updateGameConfig(@RequestBody GameConfigRequest request) {
        GameConfig gameConfig = gameConfigService.update(request);
        return ResponseEntity.ok(gameConfig);
    }

    @DeleteMapping("/game-config/{name}")
    public ResponseEntity<GameConfig> deleteGameConfigByName(@PathVariable String name) {
        Optional<GameConfig> gameConfigs = gameConfigService.findGameConfigByName(name);
        if (gameConfigs.isPresent()) {
            gameConfigService.delete(gameConfigs.get());
            return ResponseEntity.ok(gameConfigs.get());
        }
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/game-config/exec")
    public ResponseEntity<Void> execGameConfig(@RequestBody GameConfigRequest request) {
        gameConfigService.exec(request);
        return ResponseEntity.ok().build();
    }

}

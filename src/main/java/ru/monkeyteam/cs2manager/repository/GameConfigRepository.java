package ru.monkeyteam.cs2manager.repository;

import org.springframework.data.repository.CrudRepository;
import ru.monkeyteam.cs2manager.domain.GameConfig;

import java.util.Optional;

public interface GameConfigRepository extends CrudRepository<GameConfig, Long> {
    Optional<GameConfig> findByName(String name);

}

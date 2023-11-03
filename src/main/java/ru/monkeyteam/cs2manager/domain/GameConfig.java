package ru.monkeyteam.cs2manager.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "game-config")
public class GameConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "command")
    private String command;

}

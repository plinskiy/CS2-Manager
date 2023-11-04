package ru.monkeyteam.cs2manager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String login;

    private String password;

    private Long steamId;

    private boolean isCapitan;

}

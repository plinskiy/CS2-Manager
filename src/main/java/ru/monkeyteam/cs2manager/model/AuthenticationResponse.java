package ru.monkeyteam.cs2manager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.monkeyteam.cs2manager.domain.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private Long id;

    private String login;

    private Long steamId;

    private Role role;

    private Boolean isCapitan;

    private String token;

}

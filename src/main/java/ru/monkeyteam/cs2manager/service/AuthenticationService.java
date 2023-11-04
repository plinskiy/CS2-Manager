package ru.monkeyteam.cs2manager.service;

import ru.monkeyteam.cs2manager.model.AuthenticationRequest;
import ru.monkeyteam.cs2manager.model.AuthenticationResponse;
import ru.monkeyteam.cs2manager.model.RegisterRequest;
import ru.monkeyteam.cs2manager.model.RegisterResponse;

public interface AuthenticationService {

    RegisterResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}

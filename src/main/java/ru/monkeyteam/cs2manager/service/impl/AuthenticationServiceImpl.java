package ru.monkeyteam.cs2manager.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.monkeyteam.cs2manager.domain.Role;
import ru.monkeyteam.cs2manager.domain.User;
import ru.monkeyteam.cs2manager.model.AuthenticationRequest;
import ru.monkeyteam.cs2manager.model.AuthenticationResponse;
import ru.monkeyteam.cs2manager.model.RegisterRequest;
import ru.monkeyteam.cs2manager.model.RegisterResponse;
import ru.monkeyteam.cs2manager.repository.UserRepository;
import ru.monkeyteam.cs2manager.service.AuthenticationService;
import ru.monkeyteam.cs2manager.service.JwtService;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public RegisterResponse register(RegisterRequest request) {
	var user = User.builder()
			.login(request.getLogin())
			.password(passwordEncoder.encode(request.getPassword()))
			.steamId(request.getSteamId())
			.role(Role.USER)
			.isCapitan(request.isCapitan())
			.build();
	userRepository.save(user);

	var jwtToken = jwtService.generateToken(user);
	return RegisterResponse.builder()
			.token(jwtToken)
			.build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
	authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					request.getLogin(),
					request.getPassword()
			)
	);
	var user = userRepository.findByLogin(request.getLogin()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

	var jwtToken = jwtService.generateToken(user);
	return AuthenticationResponse.builder()
			.login(user.getLogin())
			.steamId(user.getSteamId())
			.role(user.getRole())
			.isCapitan(user.getIsCapitan())
			.token(jwtToken)
			.build();
    }

}

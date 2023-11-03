package ru.monkeyteam.cs2manager.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.monkeyteam.cs2manager.repository.UserRepository;
import ru.monkeyteam.cs2manager.service.UserService;
@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

}

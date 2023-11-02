package ru.monkeyteam.cs2manager.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.monkeyteam.cs2manager.service.Cs2Service;

import java.util.Arrays;

@Log4j2
@Service
@RequiredArgsConstructor
public class Cs2ServiceImpl implements Cs2Service {

    private static final String[] COMMANDS = new String[]{"!ready", ".ready", ".r", "!r", "!switch", ".switch", "!stay", ".stay"};

    @Override
    public String chatCommand(String logg) {
        return Arrays.stream(COMMANDS).anyMatch(logg::contains) ? "contains" : "not contains";
    }

}

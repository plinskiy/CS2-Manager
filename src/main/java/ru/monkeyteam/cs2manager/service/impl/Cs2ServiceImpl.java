package ru.monkeyteam.cs2manager.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.vv32.rcon.Rcon;
import org.springframework.stereotype.Service;
import ru.monkeyteam.cs2manager.config.ApplicationProperties;
import ru.monkeyteam.cs2manager.service.Cs2Service;

import java.io.IOException;
import java.util.Arrays;

@Log4j2
@Service
@RequiredArgsConstructor
public class Cs2ServiceImpl implements Cs2Service {

    private static final String[] COMMANDS = new String[]{"!ready", ".ready", "!switch", ".switch", "!stay", ".stay"};

    private final ApplicationProperties applicationProperties;

    @Override
    public String chatCommand(String text) throws IOException {
        Rcon rcon = Rcon.open(applicationProperties.getHostname(), applicationProperties.getPort());
        if (Arrays.stream(COMMANDS).anyMatch(text::contains)) {
            log.info(rcon.authenticate(applicationProperties.getPassword()) ? rcon.sendCommand(applicationProperties.getCommandToExecute()) : "Failed to authenticate");
        } else {
            log.info("Skipped");
        }
        return "OK";
    }

}

package ru.monkeyteam.cs2manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.monkeyteam.cs2manager.service.Cs2Service;

import java.io.IOException;

@Log4j2
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CS2Controller {

    private final Cs2Service cs2Service;

    @PostMapping(value = "/log", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> logger(@RequestBody String text) throws IOException {
        log.info("Incoming text : " + text);
        return ResponseEntity.ok(cs2Service.chatCommand(text));
    }

}

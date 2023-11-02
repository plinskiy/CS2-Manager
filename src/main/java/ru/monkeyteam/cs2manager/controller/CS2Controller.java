package ru.monkeyteam.cs2manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CS2Controller {
    @PostMapping(value = "/log")
    public ResponseEntity logger() {

        return ResponseEntity.ok("OK");
    }
}

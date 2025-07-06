package com.cutfreak.video_editor_backend.controllers;

import com.cutfreak.video_editor_backend.dtos.EmailDto;
import com.cutfreak.video_editor_backend.services.WaitlistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WaitlistController {

    private final WaitlistService waitlistService;

    // constructor‑based injection (preferred)
    public WaitlistController(WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }

    @PostMapping("/waitlist")
    public ResponseEntity<Map<String, String>> addToWaitlist(@RequestBody EmailDto dto) {

        try {
            EmailDto saved = waitlistService.save(dto);

            return ResponseEntity.ok(Map.of(
                    "email",   saved.getEmail(),
                    "message", "Thank you for joining the waitlist!"
            ));
        } catch (Exception ex) {
            // in real code: log.error("Wait‑list insert failed", ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "message", "Sorry, we couldn't add you to the waitlist. Please try again later."
                    ));
        }
    }

}

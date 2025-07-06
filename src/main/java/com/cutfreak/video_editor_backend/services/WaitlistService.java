package com.cutfreak.video_editor_backend.services;

import com.cutfreak.video_editor_backend.dtos.EmailDto;

public interface WaitlistService {
    /**
     * Saves the email to the wait‑list and returns the saved DTO
     * (throw an exception or return Optional if you want more control).
     */
    EmailDto save(EmailDto dto);
}

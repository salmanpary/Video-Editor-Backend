package com.cutfreak.video_editor_backend.services;

import com.cutfreak.video_editor_backend.dtos.EmailDto;
import org.springframework.stereotype.Service;

@Service
public class WaitlistServiceImpl implements WaitlistService {

    private final RawSqlExecuter rawSql;

    public WaitlistServiceImpl(RawSqlExecuter rawSql) {   // <-- injected automatically
        this.rawSql = rawSql;
    }

    @Override
    public EmailDto save(EmailDto dto) {
        String insert =
                "INSERT INTO waitlist (email) VALUES (?) " +
                        "ON CONFLICT (email) DO NOTHING";
        rawSql.updateOrInsert(insert, dto.getEmail());     // <-- actual DB write
        return dto;                                        // echo back, or map generated id, etc.
    }
}

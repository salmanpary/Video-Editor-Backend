package com.cutfreak.video_editor_backend.services;

public interface RawSqlExecuter {
    int updateOrInsert(String sql, Object... args);  // Only for INSERT/UPDATE/DELETE
}

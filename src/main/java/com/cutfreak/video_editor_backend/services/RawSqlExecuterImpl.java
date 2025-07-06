package com.cutfreak.video_editor_backend.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class RawSqlExecuterImpl implements RawSqlExecuter {

    private final JdbcTemplate jdbc;

    public RawSqlExecuterImpl(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public int updateOrInsert(String sql, Object... args) {
        return jdbc.update(sql, args); // Used for INSERT/UPDATE/DELETE
    }
}

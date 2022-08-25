package com.antonqwerty.sql.executor.dao.impl;

import com.antonqwerty.sql.executor.dao.SqlExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BaseSqlExecutor implements SqlExecutor {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public String query(String queryString) {

        if (queryString != null) {
            String preparedQuery = queryString.toUpperCase();
            if (preparedQuery.startsWith("CREATE TABLE") ||
                    preparedQuery.startsWith("INSERT INTO") ||
                    preparedQuery.startsWith("DELETE FROM")) {
                jdbcTemplate.execute(preparedQuery);
            } else if (preparedQuery.startsWith("SELECT")) {
                List<Map<String, Object>> rows = jdbcTemplate.queryForList(preparedQuery);
                List<String> resultCollector = new ArrayList<>();

                if (!rows.isEmpty()) {
                    for (Map<String, Object> row : rows) {
                        List<String> rowCollector = new ArrayList<>();
                        for (Object value : row.values()) {
                            rowCollector.add(String.valueOf(value));
                        }
                        resultCollector.add(String.join(", ", rowCollector));
                    }
                    return String.join("; ", resultCollector);
                }
            }
        }
        return "";
    }
}

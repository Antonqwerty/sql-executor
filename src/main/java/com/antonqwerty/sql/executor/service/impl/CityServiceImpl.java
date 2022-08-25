package com.antonqwerty.sql.executor.service.impl;

import com.antonqwerty.sql.executor.dao.SqlExecutor;
import com.antonqwerty.sql.executor.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final SqlExecutor sqlExecutor;

    @Override
    public void create(String string) {
        sqlExecutor.query("INSERT INTO city (id, name, countryCode, district, population) VALUES (" + string + ")");
    }

    @Override
    public String get(Long id) {
        return sqlExecutor.query("SELECT * FROM city WHERE id = " + id);
    }

    @Override
    public void delete(Long id) {
        sqlExecutor.query("DELETE FROM city WHERE id = " + id);
    }
}

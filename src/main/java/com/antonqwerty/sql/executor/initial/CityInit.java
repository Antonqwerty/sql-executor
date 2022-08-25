package com.antonqwerty.sql.executor.initial;

import com.antonqwerty.sql.executor.dao.SqlExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityInit implements ApplicationRunner {

    private final SqlExecutor sqlExecutor;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sqlExecutor.query("CREATE TABLE city (id bigint, name varchar, countryCode varchar, district varchar, population bigint)");
    }
}

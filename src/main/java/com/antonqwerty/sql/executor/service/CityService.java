package com.antonqwerty.sql.executor.service;

public interface CityService {

    void create(String string);

    String get(Long id);

    void delete(Long id);
}

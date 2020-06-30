package com.vztot.service;

import java.util.List;

public interface GenericService<T> {
    T save(T t);

    List<T> findAll();

    T getOne(Long id);
}

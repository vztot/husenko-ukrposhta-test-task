package com.vztot.service;

import java.util.List;

public interface GenericService<T> {
    T save(T t);

    List<T> getAll();

    T getOne(Long id);
}

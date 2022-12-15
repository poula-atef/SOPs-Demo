package com.mycode.sopsdemo.service;

import java.util.UUID;

public interface SOPServices<T> {

    T findById(UUID id);

    void deleteById(UUID id);

    T save(T param);

}

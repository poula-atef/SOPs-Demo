package com.mycode.sopsdemo.repository;

import com.mycode.sopsdemo.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParameterRepository extends JpaRepository<Parameter, UUID> {
}

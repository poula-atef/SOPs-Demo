package com.mycode.sopsdemo.repository;

import com.mycode.sopsdemo.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConditionRepository extends JpaRepository<Condition, UUID> {
}

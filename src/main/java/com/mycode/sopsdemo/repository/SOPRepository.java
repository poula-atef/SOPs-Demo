package com.mycode.sopsdemo.repository;

import com.mycode.sopsdemo.entity.SOP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SOPRepository extends JpaRepository<SOP, UUID> {
}

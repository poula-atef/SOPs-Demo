package com.mycode.sopsdemo.repository;

import com.mycode.sopsdemo.entity.SOPData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SOPDataRepository extends JpaRepository<SOPData,UUID> {

}

package com.mycode.sopsdemo.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "condition")
@Data
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "id")
    private UUID id;

    @Column(name = "process_type")
    private String processType;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "task_name")
    private String taskName;

}

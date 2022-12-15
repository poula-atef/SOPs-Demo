package com.mycode.sopsdemo.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "parameter")
@Data
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "id")
    private UUID id;

    @Column(name = "data")
    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonBinaryType")
    private JsonNode data;
}

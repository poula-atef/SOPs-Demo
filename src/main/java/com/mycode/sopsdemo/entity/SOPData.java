package com.mycode.sopsdemo.entity;

import com.mycode.sopsdemo.entity.enums.SOPTypes;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "sop_data")
@Data
public class SOPData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private SOPTypes type;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "parameter_id", referencedColumnName = "id")
    private Parameter parameter;

}

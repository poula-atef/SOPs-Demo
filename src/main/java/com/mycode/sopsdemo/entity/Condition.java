package com.mycode.sopsdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
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


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "sop_condition",
            inverseJoinColumns = {@JoinColumn(name = "sop_id")},
            joinColumns = {@JoinColumn(name = "condition_id")}
    )
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<SOP> sops;



    public void addSOP(SOP sop) {
        sops.add(sop);
    }
}

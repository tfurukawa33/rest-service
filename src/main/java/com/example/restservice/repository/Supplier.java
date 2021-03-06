package com.example.restservice.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="suppliers")
@Data
@ToString(exclude = "group")
public class Supplier {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "supplier_id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "supplier_name", nullable = true, updatable = true)
    @NotNull
    private String name;

    @Column(name = "group_id", nullable = true, updatable = true)
    private String groupId;

    @ManyToOne // 多対1
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", insertable = false, updatable = false)
    @JsonIgnoreProperties("suppliers")
    private SupplierGroup group;
}

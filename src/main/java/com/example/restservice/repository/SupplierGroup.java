package com.example.restservice.repository;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="supplier_groups")
@Data
@ToString(exclude = "suppliers")
public class SupplierGroup {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "group_id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "group_name", nullable = true, updatable = true)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "group") // 1対多
    @JsonIgnoreProperties("group")
    private List<Supplier> suppliers;
}

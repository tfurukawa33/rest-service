package com.example.restservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
// import javax.persistence.ForeignKey;
import lombok.Data;

@Entity
@Table(name="suppliers")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "supplier_id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "supplier_name", nullable = true, updatable = true)
    private String name;

    // @Column(name = "group_id", nullable = true, updatable = true)
    // private Integer groupId;

    @ManyToOne // 多対1
    @JoinColumn(name = "group_id")
    // @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name="group_id"))
    SupplierGroup supplierGroups;
}

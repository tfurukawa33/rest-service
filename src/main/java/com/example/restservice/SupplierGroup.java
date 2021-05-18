package com.example.restservice;

// import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
// import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Table(name="supplier_groups")
@Data
public class SupplierGroup {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "group_id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "group_name", nullable = true, updatable = true)
    private String name;

    // @OneToMany // 1対多
    // @OneToMany(mappedBy = "supplierGroups") // 1対多
    // List<Supplier> suppliers;
}

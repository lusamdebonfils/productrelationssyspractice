package edu.mum.cs.cs425.productrelationssyspractice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    private Integer supplierNumber;


    private String name;


    private String  contactPhoneNumber;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

    public Supplier() {
    }

    public Supplier(Integer supplierId, Integer supplierNumber, String name, String contactPhoneNumber) {
        this.supplierId = supplierId;
        this.supplierNumber = supplierNumber;
        this.name = name;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public List<Product> getProductList() {
        return productList;
    }
}

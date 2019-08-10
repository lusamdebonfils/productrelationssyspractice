package edu.mum.cs.cs425.productrelationssyspractice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "Product Number cannot be blank")
    private Integer productNumber;
    @NotBlank(message = "Product Name cannot be blank")

    private String name;
    @NotBlank(message = "UnitPrice cannot be blank")
    private Double unitPrice;

    @NotBlank(message = "Product Qty cannot be blank")
    private Integer quantityInStock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSupplied;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    public Product() {
    }

    public Product(Long productId, Integer productNumber, String name, Double unitPrice, Integer quantityInStock, LocalDate dateSupplied, Supplier supplier) {
        this.productId = productId;
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = dateSupplied;
        this.supplier = supplier;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}

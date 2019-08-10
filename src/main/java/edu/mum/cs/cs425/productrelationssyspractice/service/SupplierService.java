package edu.mum.cs.cs425.productrelationssyspractice.service;


import edu.mum.cs.cs425.productrelationssyspractice.model.Supplier;
import org.springframework.data.domain.Page;

public interface SupplierService {
    public Page<Supplier> getAllSuppliers(int pageNo);
    public Supplier getSupplierById(Integer id);
    public Supplier saveSupplier(Supplier s);
    public void deleteSupplier(Supplier s);
}

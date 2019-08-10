package edu.mum.cs.cs425.productrelationssyspractice.service.implementation;

import edu.mum.cs.cs425.productrelationssyspractice.model.Supplier;
import edu.mum.cs.cs425.productrelationssyspractice.repository.SupplierRepository;
import edu.mum.cs.cs425.productrelationssyspractice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SupplerServiceImplementation implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public Page<Supplier> getAllSuppliers(int pageNo) {
        return supplierRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("name")));
    }

    @Override
    public Supplier getSupplierById(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Supplier saveSupplier(Supplier s) {
        return supplierRepository.save(s);
    }

    @Override
    public void deleteSupplier(Supplier s) {
        supplierRepository.delete(s);
    }
}

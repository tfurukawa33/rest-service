package com.example.restservice.service;

import java.util.Optional;

import com.example.restservice.repository.Supplier;
import com.example.restservice.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;

    public Iterable<Supplier> findAll() {
        return repository.findAll();
    }

    public Optional<Supplier> findById(int id) {
        return repository.findById(id);
    }

    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}

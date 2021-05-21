package com.example.restservice.service;

import java.util.Optional;

import com.example.restservice.repository.SupplierGroup;
import com.example.restservice.repository.SupplierGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierGroupService {

    @Autowired
    private SupplierGroupRepository repository;

    public Iterable<SupplierGroup> findAll() {
        return repository.findAll();
    }

    public Optional<SupplierGroup> findById(int id) {
        return repository.findById(id);
    }

    public SupplierGroup save(SupplierGroup group) {
        return repository.save(group);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}

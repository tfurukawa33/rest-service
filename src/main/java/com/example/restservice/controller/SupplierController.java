package com.example.restservice.controller;

import java.util.Optional;

import com.example.restservice.repository.Supplier;
import com.example.restservice.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api")
public class SupplierController {
  @Autowired
  private SupplierService supplierService;

  @GetMapping(path="/suppliers")
  public @ResponseBody Iterable<Supplier> getAllSuppliers() {
    return supplierService.findAll();
  }

  @GetMapping(path="/supplier")
  public @ResponseBody Optional<Supplier> getSupplier(@RequestParam(value = "id") int id) {
      return supplierService.findById(id);
  }

  @PostMapping(path="/delete")
  public @ResponseBody String deleteUser (@RequestParam(value = "id") int id) {
      supplierService.delete(id);
      return id + " is deleted";
  }

  @PostMapping(path="/add")
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam int group) {
    Supplier n = new Supplier();
    n.setName(name);
    supplierService.save(n);
    return "Saved";
  }
}
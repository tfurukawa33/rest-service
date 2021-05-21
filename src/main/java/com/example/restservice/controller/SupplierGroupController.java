package com.example.restservice.controller;

import java.util.Optional;

import com.example.restservice.repository.SupplierGroup;
import com.example.restservice.service.SupplierGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class SupplierGroupController {
  @Autowired
  private SupplierGroupService supplierGroupService;

  @GetMapping(path="/groups")
  public @ResponseBody Iterable<SupplierGroup> getAllSupplierGroups() {
      return supplierGroupService.findAll();
  }

  @GetMapping(path="/group")
  public @ResponseBody Optional<SupplierGroup> getSupplierGroup(@RequestParam(value = "id") int id) {
      return supplierGroupService.findById(id);
  }

  @PostMapping(path="/add_group")
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam int group) {

    SupplierGroup n = new SupplierGroup();
    n.setName(name);
    supplierGroupService.save(n);
    return "Saved";
  }
}
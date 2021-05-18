package com.example.restservice;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class SupplierController {
  @Autowired
  private SupplierRepository supplierRepository;

//   @Autowired
//   private SupplierGroupRepository supplierGroupRepository;

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Supplier> getAllSuppliers() {
    // This returns a JSON or XML with the users
    return supplierRepository.findAll();
  }

  @GetMapping(path="/supplier")
  public @ResponseBody Optional<Supplier> getSupplier(@RequestParam(value = "id") int id) {
      return supplierRepository.findById(id);
  }

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam int group) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Supplier n = new Supplier();
    n.setName(name);
    supplierRepository.save(n);
    return "Saved";
  }
}
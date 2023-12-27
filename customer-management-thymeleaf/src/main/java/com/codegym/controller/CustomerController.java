package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();


    @GetMapping("")
    public String index(Model model) {
        List<Customer> customers = customerService.findALl();
        model.addAttribute("customers", customers);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        customerService.remove(id);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        System.out.println("edit: " + customer);
        model.addAttribute("customer", customer);
        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        System.out.println(customer);
        customerService.update(customer.getId(), customer);
        return "redirect:/customers";
    }
}

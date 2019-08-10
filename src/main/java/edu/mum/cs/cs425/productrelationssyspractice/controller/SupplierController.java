package edu.mum.cs.cs425.productrelationssyspractice.controller;

import edu.mum.cs.cs425.productrelationssyspractice.model.Supplier;
import edu.mum.cs.cs425.productrelationssyspractice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping(value = {"/prodsys/supplier/list"})
    public ModelAndView displaySupplierList(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers", supplierService.getAllSuppliers(pageno));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("supplier/list");
        return modelAndView;
    }

    @GetMapping(value={"/prodsys/supplier/newform"})
    public String addNewProductPost(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier/add";
    }

    @PostMapping(value = {"/prodsys/supplier/new"})
    public String registerSupplier(
            @Valid
            @ModelAttribute("supplier")
                    Supplier supplier,
            BindingResult bindingResult,
            Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "supplier/add";
        }
        supplier = supplierService.saveSupplier(supplier);
        return "redirect:/prodsys/supplier/list";
    }

//    @PostMapping(value = {"/new"})
//    public String registerNewCustomer(
//            @Valid
//            @ModelAttribute("customer")
//                    Customer customer,
//            BindingResult bindingResult,
//            Model model
//    ) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "secure/customer/new";
//        }
//        customerService.registerNewCustomer(customer);
//        return "redirect:/midwestenbank/secure/customers/list";
//    }



}

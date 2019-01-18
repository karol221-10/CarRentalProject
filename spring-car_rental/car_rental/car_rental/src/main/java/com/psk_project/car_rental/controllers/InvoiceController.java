package com.psk_project.car_rental.controllers;
import com.psk_project.car_rental.db.Invoice;
import com.psk_project.car_rental.services.CarService;
import com.psk_project.car_rental.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    List<Invoice> getInvoiceList() {
        return invoiceService.getList();
    }

    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putInvoice(@RequestBody Invoice input ) {
        invoiceService.add(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updateInsurance(@PathVariable(value="ID") int id, @RequestBody Invoice input) {
        input.setInvoiceID(id);
        invoiceService.update(input);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deleteInsurance(@PathVariable(value="ID") int id) {
        invoiceService.delete(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public Invoice getSingleCustomer(@PathVariable(value="ID") int id) {
        return invoiceService.get(id);
    }
}

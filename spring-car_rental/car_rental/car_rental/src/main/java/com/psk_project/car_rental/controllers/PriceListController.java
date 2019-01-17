package com.psk_project.car_rental.controllers;



import com.psk_project.car_rental.db.PriceList;
import com.psk_project.car_rental.services.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricelist")
public class PriceListController {

    @Autowired
    PriceListService priceListService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<PriceList> getPriceList() {
        return priceListService.getPriceListList();
    }

    @RequestMapping(value="/", method= RequestMethod.PUT)
    public String putPriceList(@RequestBody PriceList input ) {
        priceListService.addPriceList(input);
        return "OK";
    }

    @RequestMapping(value="/{ID}" ,method=RequestMethod.PATCH)
    public String updatePriceList(@PathVariable(value="ID") int id, @RequestBody PriceList input) {
        input.setPriceListID(id);
        priceListService.updatePriceList(input);
        return "OK";
    }

    @RequestMapping(value="/{ID}",method=RequestMethod.DELETE)
    public String deletePriceList(@PathVariable(value="ID") int id) {
        priceListService.deletePriceList(id);
        return "OK";
    }
    @RequestMapping(value="/{ID}",method=RequestMethod.GET)
    public PriceList getSinglePriceList(@PathVariable(value="ID") int id) {
        return priceListService.getPriceList(id);
    }


}

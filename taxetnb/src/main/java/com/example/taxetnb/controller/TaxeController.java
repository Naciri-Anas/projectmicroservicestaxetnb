package com.example.taxetnb.controller;


import com.example.taxetnb.bean.TaxeTNB;
import com.example.taxetnb.controller.abs.AbstractController;
import com.example.taxetnb.service.TaxeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/taxe")
public class TaxeController extends AbstractController<TaxeTNB, TaxeService> {

    public TaxeController(TaxeService service) {
        super(service);
    }
}

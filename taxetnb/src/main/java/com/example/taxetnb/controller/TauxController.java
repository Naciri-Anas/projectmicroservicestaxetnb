package com.example.taxetnb.controller;


import com.example.taxetnb.bean.Taux;
import com.example.taxetnb.controller.abs.AbstractController;
import com.example.taxetnb.service.TauxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/taux")
public class TauxController extends AbstractController<Taux, TauxService> {

    public TauxController(TauxService service) {
        super(service);
    }
}

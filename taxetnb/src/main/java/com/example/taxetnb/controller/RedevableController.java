package com.example.taxetnb.controller;

import com.example.taxetnb.bean.Redevable;
import com.example.taxetnb.controller.abs.AbstractController;
import com.example.taxetnb.service.RedevableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/redevable")
public class RedevableController extends AbstractController<Redevable, RedevableService> {


    public RedevableController(RedevableService service) {
        super(service);
    }
}
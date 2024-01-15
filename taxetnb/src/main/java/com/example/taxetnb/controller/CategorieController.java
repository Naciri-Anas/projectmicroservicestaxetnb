package com.example.taxetnb.controller;

import com.example.taxetnb.bean.Categorie;
import com.example.taxetnb.controller.abs.AbstractController;
import com.example.taxetnb.service.CategorieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categorie")
public class CategorieController extends AbstractController<Categorie, CategorieService> {

    public CategorieController(CategorieService service) {
        super(service);
    }



}
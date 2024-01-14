package com.example.taxetnb.controller;

import com.example.taxetnb.bean.Terrain;
import com.example.taxetnb.controller.abs.AbstractController;
import com.example.taxetnb.service.TerrainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/terrain")
public class TerrainController extends AbstractController<Terrain, TerrainService> {

    public TerrainController(TerrainService service) {
        super(service);
    }
}

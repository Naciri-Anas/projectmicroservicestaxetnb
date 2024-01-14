package com.example.taxetnb.controller.abs;

import com.example.taxetnb.service.abs.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class AbstractController<T, SERV extends IService<T>> {
    protected SERV service;

    public AbstractController(SERV service) {
        this.service = service;
    }

    @GetMapping("all")
    public Page<T> findAll(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam(defaultValue = "10", required = false) int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @PostMapping("save")
    public T save(@RequestBody T t) {
        return service.save(t);
    }

    @PutMapping("update")
    public T update(@RequestBody T t) {
        return service.update(t);
    }

    @GetMapping("id/{id}")
    public Optional<T> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

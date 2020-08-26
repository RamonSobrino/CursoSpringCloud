package com.formacionbdi.springboot.app.item.service;

import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductoClienteRest productoFeign;

    @Override
    public List<Item> findAll() {
        return productoFeign.listar().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(productoFeign.detalle(id), cantidad);
    }
}

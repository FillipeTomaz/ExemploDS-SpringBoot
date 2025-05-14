package com.exemploDS.exemploDS.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemploDS.exemploDS.dto.TipoDTO;
import com.exemploDS.exemploDS.services.TipoService;



@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;



    @GetMapping("/{id}")
    public ResponseEntity<TipoDTO> findById(@PathVariable Long id) {
    TipoDTO tipoDTO = tipoService.findById(id);
    return ResponseEntity.ok(tipoDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoDTO>> findAll() {
    List<TipoDTO> tipoDTOs = tipoService.findAll();
    return ResponseEntity.ok(tipoDTOs);
    }

    @PostMapping
    public ResponseEntity<TipoDTO> create(@RequestBody TipoDTO tipoDTO) {
    TipoDTO novoTipo = tipoService.insert(tipoDTO);
    return ResponseEntity.status(201).body(novoTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDTO> update(@PathVariable Long id, @RequestBody TipoDTO tipoDTO) {
    TipoDTO tipoAtualizado = tipoService.update(id, tipoDTO);
    return ResponseEntity.ok(tipoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    tipoService.delete(id);
    return ResponseEntity.noContent().build();
    }





}

package com.project.SNTDRbootcamp.controller;

import com.project.SNTDRbootcamp.model.dto.StockDTO;
import com.project.SNTDRbootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {


    @Autowired
    private StockService service;

//EndPoints comunication DataBase
    //GET: obter um recurso
    //POST: criar um recurso
    //PUT: atualizar um recurso
    //DELETE: remover um recurso

//criando um recurso (consumes>consumindo um JSON; produces>retornando um JSON):
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

//atualizando um recurso (consumes>consumindo um JSON; produces>retornando um JSON):
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }


//return FullApplication (allDATA) with List<StockDTO> (consumes>comsumindo um JSON) APENAS RETORNANDO ALGO JÁ CRIADO/ SEM ALTERA
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

//return ONLY ONE DATA with findById **campo que certamente não se repete**
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
//lambda?:
        return ResponseEntity.ok(service.findById(id));
//stream: recurso usado para percorrer a lista
// compareTO: METHOD of compare; return(-1 if "<" 0 if "="; 1 if ">")

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(service.findByToday());
    }

}

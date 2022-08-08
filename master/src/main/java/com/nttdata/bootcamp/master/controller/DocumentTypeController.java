package com.nttdata.bootcamp.master.controller;

import com.nttdata.bootcamp.master.model.document.DocumentType;
import com.nttdata.bootcamp.master.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/documenttypes")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @PostMapping
    public Mono<DocumentType> create(@RequestBody DocumentType documentType){
        return this.documentTypeService.insert(documentType);
    }

    @PutMapping
    public Mono<DocumentType> update(@RequestBody DocumentType documentType){
        return this.documentTypeService.update(documentType);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return this.documentTypeService.delete(id);
    }

    @GetMapping("/{id}")
    public Mono<DocumentType> find(@PathVariable String id){
        return this.documentTypeService.find(id);
    }

    @GetMapping("/findByCode/{code}")
    public Mono<DocumentType> findByCode(@PathVariable String code){
        return this.documentTypeService.findByCode(code);
    }

    @GetMapping
    public Flux<DocumentType> findAll() {
        return this.documentTypeService.findAll();
    }

}

/**
 * Resumen.
 * Objeto                   : DocumentTypeController.java
 * Descripción              : Clase de controladora para invocar a métodos CRUD con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.master.controller;

import com.nttdata.bootcamp.master.model.document.DocumentType;
import com.nttdata.bootcamp.master.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/documenttypes")
public class DocumentTypeController {

    /** Declaración de la clase service */
    @Autowired
    private DocumentTypeService documentTypeService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el DocumentType, tipo Mono
     */
    @PostMapping
    public Mono<DocumentType> create(@RequestBody DocumentType documentType){
        return this.documentTypeService.insert(documentType);
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el DocumentType, tipo Mono
     */
    @PutMapping
    public Mono<DocumentType> update(@RequestBody DocumentType documentType){
        return this.documentTypeService.update(documentType);
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return this.documentTypeService.delete(id);
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el DocumentType, tipo String
     */
    @GetMapping("/{id}")
    public Mono<DocumentType> find(@PathVariable String id){
        return this.documentTypeService.find(id);
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el DocumentType, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<DocumentType> findByCode(@PathVariable String code){
        return this.documentTypeService.findByCode(code);
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el DocumentType, tipo Flux
     */
    @GetMapping
    public Flux<DocumentType> findAll() {
        return this.documentTypeService.findAll();
    }

}

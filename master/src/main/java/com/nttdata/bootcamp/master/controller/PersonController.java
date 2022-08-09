/**
 * Resumen.
 * Objeto                   : ProductController.java
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

import com.nttdata.bootcamp.master.model.document.Person;
import com.nttdata.bootcamp.master.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    /** Declaración de la clase service */
    @Autowired
    private PersonService personService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Person, tipo Mono
     */
    @PostMapping
    public Mono<Person> create(@RequestBody Person person){
        return this.personService.insert(person);
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Person, tipo Mono
     */
    @PutMapping
    public Mono<Person> update(@RequestBody Person person){
        return this.personService.update(person);
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return this.personService.delete(id);
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Person, tipo String
     */
    @GetMapping("/{id}")
    public Mono<Person> find(@PathVariable String id){
        return this.personService.find(id);
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Person, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<Person> findByCode(@PathVariable String code){
        return this.personService.findByCode(code);
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Person, tipo Flux
     */
    @GetMapping
    public Flux<Person> findAll(){
        return this.personService.findAll();
    }

}

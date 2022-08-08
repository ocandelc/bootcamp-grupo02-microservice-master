package com.nttdata.bootcamp.master.service.impl;

import com.nttdata.bootcamp.master.model.dao.DocumentTypeDao;
import com.nttdata.bootcamp.master.model.document.DocumentType;
import com.nttdata.bootcamp.master.service.DocumentTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private static final Logger log = LoggerFactory.getLogger(DocumentTypeServiceImpl.class);

    @Autowired
    private DocumentTypeDao documentTypeDao;

    @Override
    public Mono<DocumentType> insert(DocumentType documentType) {
        return documentTypeDao.save(documentType)
                .doFirst(() -> log.info("Begin Insert DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert DocumentType"));
    }

    @Override
    public Mono<DocumentType> update(DocumentType documentType) {
        return documentTypeDao.findById(documentType.getId())
                .doFirst(() -> log.info("Begin Update DocumentType"))
                .map(t -> documentType)
                .flatMap(this.documentTypeDao::save)
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish Update DocumentType"));
    }

    @Override
    public Mono<Void> delete(String id) {
        return documentTypeDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete DocumentType"));
    }

    @Override
    public Mono<DocumentType> find(String id) {
        return documentTypeDao.findById(id)
                .doFirst(() -> log.info("Begin Find DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish Find DocumentType"));
    }

    @Override
    public Mono<DocumentType> findByCode(String code) {
        return documentTypeDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode DocumentType"));
    }

    @Override
    public Flux<DocumentType> findAll() {
        return documentTypeDao.findAll()
                .doFirst(() -> log.info("Begin FindAll DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll DocumentType"));
    }

}

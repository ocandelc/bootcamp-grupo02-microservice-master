package com.nttdata.bootcamp.master.model.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection="person")
public class Person {

    @Id
    private String id;
    private String code;
    private String name;
    private String lastName;
    private String codeDocumentType;
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private boolean state;

}

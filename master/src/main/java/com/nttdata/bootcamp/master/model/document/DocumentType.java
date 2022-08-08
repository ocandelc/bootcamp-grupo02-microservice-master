package com.nttdata.bootcamp.master.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection="document_type")
public class DocumentType {

    @Id
    private String id;
    private String code;
    private String name;
    private String description;
    private boolean state;

}

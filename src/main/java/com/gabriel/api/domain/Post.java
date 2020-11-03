package com.gabriel.api.domain;

import com.gabriel.api.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Post implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    private String id;
    private AuthorDTO author;
    private Date date;
    private String title;
    private String body;
}

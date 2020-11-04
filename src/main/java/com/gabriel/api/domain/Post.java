package com.gabriel.api.domain;

import com.gabriel.api.dto.AuthorDTO;
import com.gabriel.api.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
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

    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, AuthorDTO author, Date date, String title, String body) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.title = title;
        this.body = body;
    }
}

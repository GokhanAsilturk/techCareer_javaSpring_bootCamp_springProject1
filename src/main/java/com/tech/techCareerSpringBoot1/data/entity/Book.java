package com.tech.techCareerSpringBoot1.data.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("books")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Book  extends BaseEntity{
    @Id
    private int id;
    private String name;
    private String releaseYear;
    private String authorID;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
}
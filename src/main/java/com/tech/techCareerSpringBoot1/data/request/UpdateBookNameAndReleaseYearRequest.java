package com.tech.techCareerSpringBoot1.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBookNameAndReleaseYearRequest {

    private int id;
    private String name;
    private String releaseYear;
}

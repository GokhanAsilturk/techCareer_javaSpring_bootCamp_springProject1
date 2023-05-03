package com.tech.techCareerSpringBoot1.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TCResponse<T> {

    private T response;
    private boolean isSuccess;
    private String errorMessage;

}

package com.samuelng.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MessageResponse<T> {
    private String message;
    private Boolean status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;


}

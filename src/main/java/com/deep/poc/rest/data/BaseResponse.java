package com.deep.poc.rest.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    @JsonProperty("status")
    private String status;
}

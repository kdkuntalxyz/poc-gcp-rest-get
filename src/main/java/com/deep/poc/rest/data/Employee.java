package com.deep.poc.rest.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee extends BaseResponse {
    @JsonProperty("data")
    private Data data;
}

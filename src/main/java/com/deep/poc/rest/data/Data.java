package com.deep.poc.rest.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    @JsonProperty("id")
    private String id;
    @JsonProperty("employee_name")
    private String employee_name;
    @JsonProperty("employee_salary")
    private String employee_salary;
    @JsonProperty("employee_age")
    private String employee_age;
    @JsonProperty("profile_image")
    private String profile_image;
}

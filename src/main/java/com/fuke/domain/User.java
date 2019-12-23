package com.fuke.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String username;
    @JsonIgnore
    private Integer password;
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GTM+8")
    private Date birthday;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;
}

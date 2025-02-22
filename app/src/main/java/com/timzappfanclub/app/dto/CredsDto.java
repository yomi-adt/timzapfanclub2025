package com.timzappfanclub.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredsDto {
    private Integer id;
    private String url;
    private String username;
    private String hashed_pass;
    private String salt;
}

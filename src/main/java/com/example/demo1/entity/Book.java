package com.example.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    @NotNull(message = "name 不能为空")
    private String name;
    @Size(max = 20)
    private String description;
    @Pattern(regexp = "((^A$|^B$|^C$))", message = "type 值不在可选范围")
    @NotNull(message = "type 不能为空")
    private String type;
    @Email(message = "email 格式不正确")
    @NotNull(message = "email 不能为空")
    private String email;

    public Boolean ceshi(int num) {
        return false;
    }

}

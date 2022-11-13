package com.luo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Student {
    private long id;
    private String number;
    private String name;
    private int age;
    private int chinese;
    private int math;
    private int english;

}

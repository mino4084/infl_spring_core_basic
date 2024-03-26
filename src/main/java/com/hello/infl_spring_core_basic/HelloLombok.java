package com.hello.infl_spring_core_basic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName    : com.hello.infl_spring_core_basic
 * fileName       : HelloLombok
 * author         : user
 * date           : 2024-03-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-27        user       최초 생성
 */

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hello");
    }
}

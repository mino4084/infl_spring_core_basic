package com.hello.infl_spring_core_basic.scan.filter;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * packageName    : com.hello.infl_spring_core_basic.scan.filter
 * fileName       : MyIncludeComponent
 * author         : user
 * date           : 2024-03-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-22        user       최초 생성
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}

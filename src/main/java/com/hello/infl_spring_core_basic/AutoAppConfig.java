package com.hello.infl_spring_core_basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * packageName    : com.hello.infl_spring_core_basic
 * fileName       : AutoAppConfig
 * author         : user
 * date           : 2024-03-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-20        user       최초 생성
 */

@Configuration
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
})
// @Component 붙은 모든 클래스를 스프링 빈으로 등록
// 스프링 빈의 기본 이름은 클래스명을 사용하지만, 맨 앞글자만 소문자로 사용한다
// MemberServiceImpl -> memberServiceImpl
// @Autowired는 스프링 빈을 사용할 수 있도록 의존관계를 주입하는 역할이다
// @Autowired에 명시된 인터페이스 타입으로 조회하여 같은 타입의 구현체를 주입해준다
public class AutoAppConfig {
}

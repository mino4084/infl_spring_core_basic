package com.hello.infl_spring_core_basic;

import com.hello.infl_spring_core_basic.member.MemberRepository;
import com.hello.infl_spring_core_basic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
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
@ComponentScan(
        // 탐색 위치를 지정하지 않으면 모든 패키지를 다 탐색한다. 심지어 라이브러리까지
        basePackages = {"com.hello.infl_spring_core_basic.member"},
        // 지정한 클래스 위치의 하위 패키지부터 탐색
        basePackageClasses = {AutoAppConfig.class},
        // basePackages, basePackageClasses 모두 지정하지 않으면
        // package com.hello.infl_spring_core_basic; 탐색
        // 그래서 별도 지정하지않고 설정정보 클래스 위치를 프로젝트 최상단에 위치한다.
        // 애플리케이션 클래스를 보면 @SpringBootApplication 해당 어노테이션이 명시
        // @SpringBootApplication 안에 @ComponentScan이 들어가있음.
        excludeFilters = {
                // 기존 코드 AppConfig.class 사용하지 않기 위한 역할
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        }
)
// @Component 붙은 모든 클래스를 스프링 빈으로 등록
// 스프링 빈의 기본 이름은 클래스명을 사용하지만, 맨 앞글자만 소문자로 사용한다
// MemberServiceImpl -> memberServiceImpl
// @Autowired는 스프링 빈을 사용할 수 있도록 의존관계를 주입하는 역할이다
// @Autowired에 명시된 인터페이스 타입으로 조회하여 같은 타입의 구현체를 주입해준다
public class AutoAppConfig {
        
        // @Component 어노테이션으로 등록한 자동 등록 빈과 @Bean 어노테이션으로 수등 등록 빈이 충돌이 나면 수동이 우선권을 가짐
        /*
        @Bean(name = "memoryMemberRepository")
        public MemberRepository memberRepository() {
                return new MemoryMemberRepository();
        }

         */
}

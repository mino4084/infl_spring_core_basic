package com.hello.infl_spring_core_basic.singleton;

import com.hello.infl_spring_core_basic.AppConfig;
import com.hello.infl_spring_core_basic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.hello.infl_spring_core_basic.singleton
 * fileName       : SingletonTest
 * author         : user
 * date           : 2024-03-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-13        user       최초 생성
 */
public class SingletonTest {

    @Test
    @DisplayName("스프링이 없는 순수 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 호출할 때마다 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 호출할 때마다 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 서로 다른 객체 인스턴스
        // memberService1 = com.hello.infl_spring_core_basic.member.MemberServiceImpl@2aa5fe93
        // memberService2 = com.hello.infl_spring_core_basic.member.MemberServiceImpl@5c1a8622

        assertThat(memberService1).isNotSameAs(memberService2);
        
        // 일반적인 웹 애플리케이션에서는 무수히 많은 요청이 생성되므로, 요청이 올때마다 객체가 생성되고 소멸되니 메모리 낭비 발생
    }
    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        //same -> 객체 인스턴스를 비교
        //eqaul -> 단순 값 비교
    }
}

package com.hello.infl_spring_core_basic.singleton;

import com.hello.infl_spring_core_basic.AppConfig;
import com.hello.infl_spring_core_basic.member.MemberRepository;
import com.hello.infl_spring_core_basic.member.MemberServiceImpl;
import com.hello.infl_spring_core_basic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.hello.infl_spring_core_basic.singleton
 * fileName       : ConfigurationSingletonTest
 * author         : user
 * date           : 2024-03-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-19        user       최초 생성
 */
public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberservice -> memberRepository1 = " + memberRepository1);
        System.out.println("orderservice -> memberRepository2 = " + memberRepository2);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository).isSameAs(memberRepository1);
        assertThat(memberRepository).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("Appconfig Bean = " + bean.getClass());
        // @Configuration을 붙이면 CGLIB 기술 사용
        // 내가 만든 클래스가 들어가있지않고 스프링이 CGLIB이라는 바이트코드 조작 라이브러리를 사용하여 AppConfig 클래스를 상속받은 
        // 임의의 클래스를 만들고, 그 클래스를 스프링 빈으로 등록
        // 상속하여 만든 임의 클래스로 싱글톤이 되도록 보장해준다. 있으면 반환 없으면 생성
        // Appconfig Bean = class com.hello.infl_spring_core_basic.AppConfig$$SpringCGLIB$$0

        // @Configuration 붙이지 않고 @Bean 만 붙이면?
        // 스프링 빈 등록은 되지만 싱글톤을 보장해주지 않는다.
        // CGLIB 기술을 사용하지 않고 내가 등록한 클래스가 나온다
    }
}

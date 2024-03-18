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
}

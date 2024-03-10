package com.hello.infl_spring_core_basic;

import com.hello.infl_spring_core_basic.discount.DiscountPolicy;
import com.hello.infl_spring_core_basic.discount.FixDiscountPolicy;
import com.hello.infl_spring_core_basic.discount.RateDiscoutPolicy;
import com.hello.infl_spring_core_basic.member.MemberRepository;
import com.hello.infl_spring_core_basic.member.MemberService;
import com.hello.infl_spring_core_basic.member.MemberServiceImpl;
import com.hello.infl_spring_core_basic.member.MemoryMemberRepository;
import com.hello.infl_spring_core_basic.order.OrderService;
import com.hello.infl_spring_core_basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.hello.infl_spring_core_basic
 * fileName       : AppConfig
 * author         : user
 * date           : 2024-03-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-07        user       최초 생성
 */

// 스프링에서 사용할 수 있도록 @Configuration 어노테이션 붙임
@Configuration
public class AppConfig {
    // AppConfig = 공연 기획자
    // 배역과 배우를 결정

    // 메소드 분리 -> 역할과 구현에 대한 정보가 한눈에 보이게 된다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 개발영역이 아닌 구성영역만 수정하여 가능
        //return new FixDiscountPolicy();
        return new RateDiscoutPolicy();
    }

    //생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


}

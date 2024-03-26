package com.hello.infl_spring_core_basic.scan;

import com.hello.infl_spring_core_basic.AutoAppConfig;
import com.hello.infl_spring_core_basic.member.MemberService;
import com.hello.infl_spring_core_basic.order.OrderService;
import com.hello.infl_spring_core_basic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.hello.infl_spring_core_basic.scan
 * fileName       : AutoAppConfigTest
 * author         : user
 * date           : 2024-03-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-20        user       최초 생성
 */
public class AutoAppConfigTest {

    @Test
    void basicScan() {
        // 기존에 AppConfig를 사용하는 것에서 AutoAppConfig를 사용하는 내용만 다르다
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService bean = ac.getBean(MemberService.class);
        assertThat(bean).isInstanceOf(MemberService.class);

        //OrderServiceImpl bean1 = ac.getBean(OrderServiceImpl.class);
        OrderService bean2 = ac.getBean(OrderService.class);
        // RateDiscountPolicy, FixDiscountPolicy 모두 @Component로 스프링 빈 등록하고
        // OrderServiceImpl에서 DiscountPolicy 를 사용하면 타입으로 조회하기 때문에 
        // No qualifying bean of type 'com.hello.infl_spring_core_basic.discount.DiscountPolicy' available: expected single matching bean but found 2: fixDiscountPolicy,rateDiscoutPolicy 오류가 발생한다


    }
}

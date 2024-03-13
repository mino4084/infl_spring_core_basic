package com.hello.infl_spring_core_basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.hello.infl_spring_core_basic.singleton
 * fileName       : StatefulServiceTest
 * author         : user
 * date           : 2024-03-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-14        user       최초 생성
 */
class StatefulServiceTest {

    @Test
    void statefulServiceSingleTon() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        /*
        //ThreadA : A 사용자, 10000원 주문
        statefulService1.order("userA", 10000);

        //ThreadB : B 사용자, 20000원 주문
        statefulService2.order("userB", 20000);
        
        //ThreadA : A 사용자, 주문금액 조회 -> 예상 10000원이 나와야함
        int price1 = statefulService1.getPrice();
        System.out.println("price1 = " + price1);

        Assertions.assertThat(price1).isEqualTo(20000);

         */

        // 무상태로 해결
        int userPriceA = statefulService1.order("userA", 10000);
        int userPriceB = statefulService1.order("userB", 20000);

        System.out.println("userPriceA = " + userPriceA);
        System.out.println("userPriceB = " + userPriceB);

        Assertions.assertThat(userPriceA).isEqualTo(10000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}
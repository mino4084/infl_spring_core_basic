package com.hello.infl_spring_core_basic.beanfind;

import com.hello.infl_spring_core_basic.AppConfig;
import com.hello.infl_spring_core_basic.discount.DiscountPolicy;
import com.hello.infl_spring_core_basic.discount.FixDiscountPolicy;
import com.hello.infl_spring_core_basic.discount.RateDiscoutPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.hello.infl_spring_core_basic.beanfind
 * fileName       : ApplicationContextExtendsFindTest
 * author         : user
 * date           : 2024-03-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-12        user       최초 생성
 */
public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    
    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 나오면, 중복 오류 발생")
    void findBeanByParentTypeDuplicate() {
        //DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 나오면, 빈 이름 지정하여 조회")
    void findBeanByParentTypeBeanName() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscoutPolicy.class);
    }


    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        RateDiscoutPolicy rateDiscountPolicy = ac.getBean(RateDiscoutPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscoutPolicy.class);
    }
    
    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        ac.getBeansOfType(DiscountPolicy.class).forEach((k, v) -> System.out.println("key = " + k + " value = " + v));
        System.out.println("beansOfType = " + ac.getBeansOfType(DiscountPolicy.class));

        assertThat(ac.getBeansOfType(DiscountPolicy.class)).hasSize(2);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
    
    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy discountPolicy() {
            return new FixDiscountPolicy();
        }

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscoutPolicy();
        }
    }
}

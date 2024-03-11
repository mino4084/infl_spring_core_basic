package com.hello.infl_spring_core_basic.beanfind;

import com.hello.infl_spring_core_basic.AppConfig;
import com.hello.infl_spring_core_basic.member.MemberRepository;
import com.hello.infl_spring_core_basic.member.MemberService;
import com.hello.infl_spring_core_basic.member.MemberServiceImpl;
import com.hello.infl_spring_core_basic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * packageName    : com.hello.infl_spring_core_basic.beanfind
 * fileName       : ApplicationContextSameBeanFindTest
 * author         : user
 * date           : 2024-03-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-12        user       최초 생성
 */
public class ApplicationContextSameBeanFindTest {
    //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    
    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있을 때, 중복 오류 발생")
    void findBeanByTypeDuplicate() {
        // NoUniqueBeanDefinitionException
        //MemberRepository bean = ac.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 이름 조회")
    void findBeanByName() {
        MemberRepository memberRepository1 = ac.getBean("memberRepository1", MemberRepository.class);
        Assertions.assertThat(memberRepository1).isInstanceOf(MemberRepository.class);
    }
    
    @Test
    @DisplayName("특정 타입을 모두 조회")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }
    

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}

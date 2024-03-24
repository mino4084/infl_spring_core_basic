package com.hello.infl_spring_core_basic.autowired;

import com.hello.infl_spring_core_basic.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

/**
 * packageName    : com.hello.infl_spring_core_basic.autowired
 * fileName       : AutowiredTest
 * author         : user
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 *
 * -----------------------------------------------------------
 * 2024-03-25        user       최초 생성
 */
public class AutowiredTest {
    @Test
    void AutowiredOptionTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        
        // Member는 스프링 빈이 아니다
        // 테스트코드 호출히 아래와 같이 setNobean1은 호출되지 않는다
        // required = false 를 넣으면 주입할 의존관계가 없는 경우 아예 메소드 자체가 호출되지 않는다.
        // noBean2 = null
        // noBean3 = Optional.empty

    }

    static class TestBean {
        
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}

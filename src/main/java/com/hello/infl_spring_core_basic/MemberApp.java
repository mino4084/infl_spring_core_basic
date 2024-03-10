package com.hello.infl_spring_core_basic;

import com.hello.infl_spring_core_basic.member.Grade;
import com.hello.infl_spring_core_basic.member.Member;
import com.hello.infl_spring_core_basic.member.MemberService;
import com.hello.infl_spring_core_basic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : com.hello.infl_spring_core_basic
 * fileName       : MemberApp
 * author         : user
 * date           : 2024-03-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-06        user       최초 생성
 */
public class MemberApp {
    public static void main(String[] args) {

        
        // 기존 코드는 인터페이스와 구현체까지 의존했지만
        //MemberService memberService = new MemberServiceImpl();

        // AppConfig를 활용하여 인터페이스에만 의존하게 바꿈
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //memberService <- MemoryMemberRepository를 사용하는 MemberServiceImpl() 객체가 들어가있음

        // 스프링 전환
        // ApplicationContext가 스프링 컨테이너.
        // 스프링 컨테이너는 @Configuration 어노테이션으로 붙은 AppConfig를 구성정보로 사용.
        // @Bean 어노테이션이 붙은 메소드를 호출하여 반환된 객체를 스프링 컨테이너에 등록한다. -> 스프링 빈
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig에서 메소드명으로 찾을 수 있음
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}

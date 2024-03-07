package com.hello.infl_spring_core_basic;

import com.hello.infl_spring_core_basic.member.Grade;
import com.hello.infl_spring_core_basic.member.Member;
import com.hello.infl_spring_core_basic.member.MemberService;
import com.hello.infl_spring_core_basic.member.MemberServiceImpl;

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
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //memberService <- MemoryMemberRepository를 사용하는 MemberServiceImpl() 객체가 들어가있음

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}

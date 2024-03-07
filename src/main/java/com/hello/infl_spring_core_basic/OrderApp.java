package com.hello.infl_spring_core_basic;

import com.hello.infl_spring_core_basic.member.Grade;
import com.hello.infl_spring_core_basic.member.Member;
import com.hello.infl_spring_core_basic.member.MemberService;
import com.hello.infl_spring_core_basic.member.MemberServiceImpl;
import com.hello.infl_spring_core_basic.order.OrderService;
import com.hello.infl_spring_core_basic.order.OrderServiceImpl;

/**
 * packageName    : com.hello.infl_spring_core_basic
 * fileName       : OrderApp
 * author         : user
 * date           : 2024-03-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-07        user       최초 생성
 */
public class OrderApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();


        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();


        Long memberId = 1L;
        Member member = new Member(memberId, "userA", Grade.VIP);
        memberService.join(member);

        //orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + orderService.createOrder(memberId, "itemA", 10000));
        System.out.println("calculatePrice = " + orderService.createOrder(memberId, "itemA", 10000).calculatePrice());
    }
}

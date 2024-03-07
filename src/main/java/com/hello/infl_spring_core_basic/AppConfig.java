package com.hello.infl_spring_core_basic;

import com.hello.infl_spring_core_basic.discount.FixDiscountPolicy;
import com.hello.infl_spring_core_basic.member.MemberService;
import com.hello.infl_spring_core_basic.member.MemberServiceImpl;
import com.hello.infl_spring_core_basic.member.MemoryMemberRepository;
import com.hello.infl_spring_core_basic.order.OrderService;
import com.hello.infl_spring_core_basic.order.OrderServiceImpl;

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
public class AppConfig {

    public MemberService memberService() {
        // 생성자를 통해 MemoryMemberRepository가 주입시키도록 설정한다.
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

package com.hello.infl_spring_core_basic.discount;

import com.hello.infl_spring_core_basic.member.Member;

/**
 * packageName    : com.hello.infl_spring_core_basic.discount
 * fileName       : discountPolicy
 * author         : user
 * date           : 2024-03-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-06        user       최초 생성
 */
public interface DiscountPolicy {
    int discount(Member member, int price);
}

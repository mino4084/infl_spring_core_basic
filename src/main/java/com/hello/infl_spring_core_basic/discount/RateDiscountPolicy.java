package com.hello.infl_spring_core_basic.discount;

import com.hello.infl_spring_core_basic.anntation.MainDiscountPolicy;
import com.hello.infl_spring_core_basic.member.Grade;
import com.hello.infl_spring_core_basic.member.Member;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.hello.infl_spring_core_basic.discount
 * fileName       : RateDiscountPolicy
 * author         : user
 * date           : 2024-03-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-07        user       최초 생성
 */
@Component
//@Primary
//@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }

    }
}

package com.hello.infl_spring_core_basic.discount;

import com.hello.infl_spring_core_basic.member.Grade;
import com.hello.infl_spring_core_basic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName    : com.hello.infl_spring_core_basic.discount
 * fileName       : RateDiscountPolicyTest
 * author         : user
 * date           : 2024-03-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-07        user       최초 생성
 */
class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용되어야 한다")
    void discount() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        int discountPrice = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC는 0% 할인 적용되어야 한다")
    void discount2() {
        // given
        Member member = new Member(2L, "memberB", Grade.BASIC);

        // when
        int discountPrice = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discountPrice).isEqualTo(0);
    }

}
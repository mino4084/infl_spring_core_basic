package com.hello.infl_spring_core_basic.order;

import com.hello.infl_spring_core_basic.discount.DiscountPolicy;
import com.hello.infl_spring_core_basic.member.Member;
import com.hello.infl_spring_core_basic.member.MemberRepository;
import com.hello.infl_spring_core_basic.member.MemoryMemberRepository;

/**
 * packageName    : com.hello.infl_spring_core_basic.order
 * fileName       : OrderServiceImpl
 * author         : user
 * date           : 2024-03-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-06        user       최초 생성
 */
public class OrderServiceImpl implements OrderService {

    // 정액 할인 정책에서 정률 할인 정책으로 변경하는 경우, 코드를 아래와 같이 고쳐야한다.
    // 역할과 구현 분리 구현 -> Y
    // 다형성 구현 -> Y
    // DIP -> X : OrderServiceImpl(주문서비스 클라이언트) 는 DiscountPolicy(추상)에 의존하지만, RateDiscoutPolicy or FixDiscountPolicy(구현)에도 의존한다
    // OCP -> X : 기능 확장에 따라 코드 수정이 불가피하다
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscoutPolicy();
    private DiscountPolicy discountPolicy;
    // 이를 해결하기 위해서는 인터페이스(추상)에만 의존하도록 해야한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

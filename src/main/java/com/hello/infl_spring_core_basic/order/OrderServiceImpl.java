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
    /*
    private DiscountPolicy discountPolicy;
    private MemberRepository memberRepository;
     */
    // 이를 해결하기 위해서는 인터페이스(추상)에만 의존하도록 해야한다.

    // ---------------------------------------------------------------------------
    // 관심사 분리 : 각 자신의 해야할 일, 책임을 확실하게 분리하여 할당하도록 해야한다.
    // 누군가는 의존성을 주입해줘야 한다. -> AppConfig가 하도록 함

    // final 사용하는 이유 : 생성자 주입이라는 고정된 방법으로 의존성을 주입받기 위함. final로 하지 않으면 건드릴수 있기 때문에 변경될 수 있음 
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // AppConfig에 의해 생성자 주입을 사용함
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

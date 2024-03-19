package com.hello.infl_spring_core_basic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.hello.infl_spring_core_basic.member
 * fileName       : MemberServiceImpl
 * author         : user
 * date           : 2024-03-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-06        user       최초 생성
 */
@Component
public class MemberServiceImpl implements MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;

    // 생성자를 통해 AppConfig에 의해서 MemberRepository의 의존성을 주입받는다.
    // : 생성자 주입
    /*
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

     */
    // 이를 통해 MemberServiceImpl 코드 안에는 MemoryMemberRepository 코드가 사라진다
    // -> 인터페이스에만 의존하게 됌


    // @Component 어노테이션으로 스프링 빈으로 등록은 됐지만, AppConfig에서 등록된 빈들 간의 의존관계를 명시한 거처럼
    // MemberRepository 타입을 찾아서 @Autowired 어노테이션을 사용하여 의존관계를 주입한다
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

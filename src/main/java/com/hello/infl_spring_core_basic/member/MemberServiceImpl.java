package com.hello.infl_spring_core_basic.member;

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
public class MemberServiceImpl implements MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;

    // 생성자를 통해 AppConfig에 의해서 MemberRepository의 의존성을 주입받는다.
    // : 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 이를 통해 MemberServiceImpl 코드 안에는 MemoryMemberRepository 코드가 사라진다
    // -> 인터페이스에만 의존하게 됌

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

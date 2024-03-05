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

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {

    }

    @Override
    public Member findMember(Long memberId) {
        return null;
    }
}

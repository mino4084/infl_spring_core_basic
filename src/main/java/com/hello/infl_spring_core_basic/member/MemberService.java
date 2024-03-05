package com.hello.infl_spring_core_basic.member;

/**
 * packageName    : com.hello.infl_spring_core_basic.member
 * fileName       : MemberService
 * author         : user
 * date           : 2024-03-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-06        user       최초 생성
 */
public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}

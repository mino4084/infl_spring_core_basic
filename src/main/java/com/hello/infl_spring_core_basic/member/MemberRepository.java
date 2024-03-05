package com.hello.infl_spring_core_basic.member;

/**
 * packageName    : com.hello.infl_spring_core_basic.member
 * fileName       : MemberRepository
 * author         : user
 * date           : 2024-03-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-06        user       최초 생성
 */
public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);
}

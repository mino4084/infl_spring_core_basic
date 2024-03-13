package com.hello.infl_spring_core_basic.singleton;

/**
 * packageName    : com.hello.infl_spring_core_basic.singleton
 * fileName       : SingletonService
 * author         : user
 * date           : 2024-03-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-14        user       최초 생성
 */
public class SingletonService {

    // 자기 자신을 객체 인스턴스 생성 -> 스태틱 영역에 생성
    // 이 방법은 객체 인스턴스를 미리 생성해두고 사용하는 안전한 방법
    private static final SingletonService instance = new SingletonService();

    // 인스턴스를 반환
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 외부에서 호출하지 못하도록 함
    // new 키워드로 임의로 객체 인스턴스 생성을 막음
    // 좋은 설계는 컴파일 오류를 활용하는 것
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}

package com.hello.infl_spring_core_basic.singleton;

/**
 * packageName    : com.hello.infl_spring_core_basic.singleton
 * fileName       : StatefulService
 * author         : user
 * date           : 2024-03-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-14        user       최초 생성
 */
public class StatefulService {
    /*
    // 상태를 유지하는 필드
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        
        // 해당 부분이 문제
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

     */

    // 무상태로 설계로 변경
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }
}

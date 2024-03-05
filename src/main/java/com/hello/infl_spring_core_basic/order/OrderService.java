package com.hello.infl_spring_core_basic.order;

/**
 * packageName    : com.hello.infl_spring_core_basic.order
 * fileName       : OrderService
 * author         : user
 * date           : 2024-03-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-06        user       최초 생성
 */
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}

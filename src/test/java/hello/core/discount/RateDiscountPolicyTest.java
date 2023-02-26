package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {


    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o ()
    {
        //given 어떤 환경이 주었을때
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when 이렇게 하면
        int discount =  discountPolicy.discount(member, 10000);
        //then 이렇게 된다.
        assertThat(discount).isEqualTo(1000);

    }


    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_X ()
    {
        //given 어떤 환경이 주었을때
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when 이렇게 하면
        int discount =  discountPolicy.discount(member, 10000);
        //then 이렇게 된다.
        assertThat(discount).isEqualTo(0);

    }

}
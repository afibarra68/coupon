package com.meli.coupon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.coupon.bussiness.CouponDTO;
import com.meli.coupon.bussiness.ItemDTO;
import com.meli.coupon.service.CouponService;

@SpringBootTest
public class CouponServiceTest {

   private static final int ONE = 1;

   private static final CouponService service = new CouponService();


   @Test
   void getSaver() throws Exception{
      ItemDTO item1 =  ItemDTO.builder().itemId("MLA1").price(BigDecimal.valueOf(100)).build();
      ItemDTO item2 =  ItemDTO.builder().itemId("MLA2").price(BigDecimal.valueOf(210)).build();
      ItemDTO item3 =  ItemDTO.builder().itemId("MLA3").price(BigDecimal.valueOf(260)).build();
      ItemDTO item4 =  ItemDTO.builder().itemId("MLA4").price(BigDecimal.valueOf(80)).build();
      ItemDTO item5 =  ItemDTO.builder().itemId("MLA5").price(BigDecimal.valueOf(90)).build();

      List<ItemDTO> items = new ArrayList<>();

      items.add(item1);
      items.add(item2);
      items.add(item3);
      items.add(item4);
      items.add(item5);

      CouponDTO actual = CouponDTO.builder().totalCoupon(BigDecimal.valueOf(500)).itemIds(items).priceSaved(BigDecimal.ZERO).build();

      CouponDTO result = service.processCoupon(actual);
      Assertions.assertTrue(items.toArray().length > result.getItemIds().toArray().length , "Asercion de longitud");
      Assertions.assertNotEquals(result.getAmount(), actual.getTotalCoupon(), "Asercion de longitud");
   }


}

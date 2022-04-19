package com.meli.coupon.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.meli.coupon.bussiness.CouponDTO;
import com.meli.coupon.bussiness.ItemDTO;

import org.springframework.stereotype.Service;

@Service
public class CouponService {

   public static final Integer ONE = 1;
   public static final Integer MINUSONE = -1;

    public CouponDTO processCoupon(CouponDTO couponF)  {

       BigDecimal priceAmount = couponF.getTotalCoupon();
       List<ItemDTO> itemsProcesed =  addItemsOrdered(orderItemsToMajor(couponF.getItemIds()), couponF.getTotalCoupon(), couponF);
          BigDecimal totalPrice = getTotalAmount(itemsProcesed);
          couponF.setAmount(totalPrice);
          couponF.setItemIds(itemsProcesed);
          couponF.setPriceSaved(priceAmount);
          couponF.setTotalCoupon(priceAmount);
          return couponF;
    }

    List<ItemDTO> addItemsOrdered(List<ItemDTO> itemsLA, BigDecimal totalCoupon, CouponDTO coupon) {
       int itemsTotal = itemsLA.toArray().length;
       List<ItemDTO> itemsProcessed = new ArrayList<>();
       coupon.setTotalCoupon(BigDecimal.ZERO);
       for (int i = 0; i < itemsTotal; i++) {
          if ((totalCoupon.compareTo(coupon.getPriceSaved()) == ONE )){
             BigDecimal lastPrice = coupon.getPriceSaved();
             coupon.setPriceSaved(lastPrice.add(itemsLA.get(i).getPrice()));
             itemsProcessed.add(itemsLA.get(i));
             if ((totalCoupon.compareTo(coupon.getPriceSaved()) == MINUSONE )) {
                itemsProcessed.remove(itemsLA.get(i));
                coupon.setPriceSaved(coupon.getPriceSaved().min(itemsLA.get(i).getPrice()));
             }
          }
       }
       return itemsProcessed;
    }

    private List<ItemDTO> orderItemsToMajor(List<ItemDTO> items) {
       return items.stream().sorted((o1, o2)->o1.getPrice().compareTo(o2.getPrice())).collect(Collectors.toList());
    }

   private BigDecimal getTotalAmount(List<ItemDTO> items) {
       List<BigDecimal> totalSaved = items.stream().map(ItemDTO::getPrice).collect(Collectors.toList());
       BigDecimal totalPrice = BigDecimal.ZERO;
      for (BigDecimal bigDecimal : totalSaved) {
         totalPrice = totalPrice.add(bigDecimal);
      }
      return totalPrice;
   }
}

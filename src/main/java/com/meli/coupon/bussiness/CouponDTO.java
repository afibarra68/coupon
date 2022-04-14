package com.meli.coupon.bussiness;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponDTO implements Serializable {

    private List<ItemDTO> itemIds;

    @Digits(integer=6, fraction=2)
    private Double amount;

    @NotNull
    @Digits(integer=6, fraction=2)
    private Double totalCoupon;

}

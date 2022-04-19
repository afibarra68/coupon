package com.meli.coupon.bussiness;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class CouponDTO implements Serializable {

    private List<ItemDTO> itemIds;

    @Digits(integer=6, fraction=2)
    private BigDecimal amount;

    @Digits(integer=6, fraction=2)
    private BigDecimal priceSaved = BigDecimal.ZERO;

    @NotNull
    @Digits(integer=6, fraction=2)
    private BigDecimal totalCoupon;

}

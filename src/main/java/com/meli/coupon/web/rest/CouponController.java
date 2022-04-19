package com.meli.coupon.web.rest;

import com.meli.coupon.bussiness.CouponDTO;
import com.meli.coupon.service.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/coupon")
public class CouponController {

    private CouponService service;

    @PostMapping
    public CouponDTO processEngine(@Valid @RequestBody CouponDTO coupon) throws Exception {
        return service.processCoupon(coupon);
    }
}

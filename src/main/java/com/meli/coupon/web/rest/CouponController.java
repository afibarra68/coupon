package com.meli.coupon.web.rest;

import com.meli.coupon.bussiness.CouponDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/coupon")
public class CouponController {

    @PostMapping
    public CouponDTO processEngine(@Valid @RequestBody CouponDTO coupon) throws Exception {
        return coupon;
    }
}

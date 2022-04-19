package com.meli.coupon.bussiness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.Digits;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude( NON_NULL )
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDTO implements Serializable {

    private String itemId;

    @Digits(integer=6, fraction=2)
    private BigDecimal price;

}

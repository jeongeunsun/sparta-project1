package com.twopro.deliveryapp.store.dto;

import com.twopro.deliveryapp.common.dto.AddressDto;
import com.twopro.deliveryapp.common.enumType.StoreType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class StoreResponseDto {
    private UUID id;
    private String name;
    private String pictureUrl;
    private String phone;
    private AddressDto address;
    private String operatingHours;
    private String closedDays;
    private String status;
    private StoreType deliveryType;
    private Integer minimumOrderPrice;
    private Integer deliveryTip;
    private double averageRating;
    private int reviewCount;
}
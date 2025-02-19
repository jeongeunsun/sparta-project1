package com.twopro.deliveryapp.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class StoreDeliveryArea {
    @Id
    @GeneratedValue
    @Column(name = "store_delivery_area_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "delivery_area_id")
    private DeliveryArea deliveryArea;

    public StoreDeliveryArea(Store store, DeliveryArea deliveryArea) {
        this.store = store;
        this.deliveryArea = deliveryArea;
    }
}
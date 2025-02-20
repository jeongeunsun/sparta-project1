package com.twopro.deliveryapp.payment.entity;

import com.twopro.deliveryapp.common.entity.Address;
import com.twopro.deliveryapp.common.entity.BaseEntity;
import com.twopro.deliveryapp.common.enumType.OrderStatus;
import com.twopro.deliveryapp.common.enumType.OrderType;
import com.twopro.deliveryapp.order.entity.Order;
import com.twopro.deliveryapp.orderItem.Entity.OrderItem;
import com.twopro.deliveryapp.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "p_payment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private UUID id;

    private int totalPrice;
    private String paymentStatus;
    private String paymentProvider;

    public static Payment createPayment(int totalPrice, String paymentStatus, String paymentProvider) {
        Payment payment = new Payment();
        payment.totalPrice = totalPrice;
        payment.paymentStatus = paymentStatus;
        payment.paymentProvider = paymentProvider;
        return payment;
    }
}

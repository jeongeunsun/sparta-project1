package com.twopro.deliveryapp.cart.repository;

import com.twopro.deliveryapp.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
    Optional<Cart> findByUser_UserId(Long userId);

    Optional<Cart> findByCartId(UUID cartId);
}

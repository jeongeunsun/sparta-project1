package com.twopro.deliveryapp.menu.repository;

import com.twopro.deliveryapp.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaMenuRepository extends JpaRepository<Menu, UUID> {

    @Query(
            "SELECT m " +
            "FROM Menu m " +
            "WHERE m.store.id = :storeId"
    )
    Optional<List<Menu>> findAllMenuByStoreId(@Param("storeId") UUID storeId);

    // 조회시 풀스캔될 위험 있음
    @Query(
            "SELECT m " +
            "FROM Menu m " +
            "WHERE m.name " +
            "LIKE %:name%"
    )
    Optional<List<Menu>> findMenuEntitiesByName(@Param("name") String name);
}

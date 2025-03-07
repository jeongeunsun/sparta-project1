package com.twopro.deliveryapp.store.service;

import com.twopro.deliveryapp.store.dto.DeliveryAreaDto;
import com.twopro.deliveryapp.store.entity.DeliveryArea;
import com.twopro.deliveryapp.store.exception.DeliveryAreaNotFoundException;
import com.twopro.deliveryapp.store.exception.DuplicateDeliveryAreaNameException;
import com.twopro.deliveryapp.store.repository.DeliveryAreaRepository;
import com.twopro.deliveryapp.store.repository.StoreDeliveryAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryAreaServiceImpl implements DeliveryAreaService {

    private final DeliveryAreaRepository deliveryAreaRepository;
    private final StoreDeliveryAreaRepository storeDeliveryAreaRepository;

    @Override
    public Optional<DeliveryArea> findByID(UUID id) {
        return deliveryAreaRepository.findById(id);
    }

    @Override
    @Transactional
    public List<DeliveryArea> createDeliveryAreas(List<String> names) {
        List<DeliveryArea> deliveryAreas = names.stream()
                .filter(name -> !deliveryAreaRepository.existsByName(name))
                .map(DeliveryArea::new)
                .toList();

        return deliveryAreaRepository.saveAll(deliveryAreas);
    }

    @Override
    public List<DeliveryArea> getAllDeliveryAreas() {
        return deliveryAreaRepository.findAllByDeletedAtIsNull();
    }

    @Transactional
    public void updateMultipleDeliveryAreas(List<DeliveryAreaDto> deliveryAreaDtos) {
        for (DeliveryAreaDto dto : deliveryAreaDtos) {
            DeliveryArea deliveryArea = deliveryAreaRepository.findById(dto.getId())
                    .orElseThrow(() -> new DeliveryAreaNotFoundException("해당 ID의 배달 가능 지역을 찾을 수 없습니다.", dto.getId()));

            if (deliveryAreaRepository.existsByName(dto.getName()) && !dto.getName().equals(deliveryArea.getName())) {
                throw new DuplicateDeliveryAreaNameException("이미 존재하는 배달 가능 지역 이름입니다.", dto.getName());
            }

            deliveryArea.updateName(dto.getName());
            deliveryAreaRepository.save(deliveryArea);
        }
    }

    @Override
    @Transactional
    public void deleteDeliveryArea(UUID deliveryAreaId) {
        DeliveryArea deliveryArea = deliveryAreaRepository.findById(deliveryAreaId)
                .orElseThrow(() -> new DeliveryAreaNotFoundException("해당 ID의 배달 가능 지역을 찾을 수 없습니다.", deliveryAreaId));

        deliveryArea.delete();
        deliveryAreaRepository.save(deliveryArea);
    }
}
package com.twopro.deliveryapp.ai.service;

import com.twopro.deliveryapp.ai.dto.AiResponseDto;
import com.twopro.deliveryapp.ai.dto.CreateAiServiceRequestDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AiService {

    AiResponseDto createAiService(CreateAiServiceRequestDto createAiServiceRequestDto);

    AiResponseDto findAiServiceById(UUID aiId);

    List<AiResponseDto> findAllAiServices();

    List<AiResponseDto> findAllAiServiceByFilter(LocalDate startDate, LocalDate endDate, String menuName);;
}

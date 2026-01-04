package com.project.fitness.service;

import org.springframework.stereotype.Service;

import com.project.fitness.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
}

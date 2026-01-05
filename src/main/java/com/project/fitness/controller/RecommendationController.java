package com.project.fitness.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody RecommendationRequest request) {
        // Implementation for generating a recommendation
        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getRecommendationByUserId(
            @PathVariable String userId) {
        // Implementation for retrieving a recommendation by user ID
        List<Recommendation> recommendations = recommendationService.getRecommendationByUserId(userId);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getRecommendationByActivityId(
            @PathVariable String activityId) {
        // Implementation for retrieving a recommendation by activity ID
        List<Recommendation> recommendations;
        recommendations = recommendationService.getRecommendationByActivityId(activityId);
        return ResponseEntity.ok(recommendations);
    }
}

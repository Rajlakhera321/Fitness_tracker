package com.project.fitness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

        private final RecommendationRepository recommendationRepository;
        private final UserRepository userRepository;
        private final ActivityRepository activityRepository;

        public Recommendation generateRecommendation(
                        RecommendationRequest request) {
                // Implementation for generating recommendations
                User user = userRepository.findById(request.getUserId())
                                .orElseThrow(() -> new RuntimeException("User not found"));

                Activity activity = activityRepository.findById(request.getActivityId())
                                .orElseThrow(() -> new RuntimeException("Activity not found"));

                Recommendation recommendation = Recommendation.builder()
                                .user(user)
                                .activity(activity)
                                .improvements(request.getImprovements())
                                .suggestions(request.getSuggestions())
                                .safety(request.getSafety())
                                .build();

                Recommendation savedRecommendation = recommendationRepository.save(recommendation);

                return savedRecommendation;
        }

        public List<Recommendation> getRecommendationByUserId(String userId) {
                List<Recommendation> recommendations = recommendationRepository.findByUserId(userId);

                if (recommendations.isEmpty()) {
                        throw new RuntimeException("No recommendations found for user ID: " + userId);
                }

                return recommendations;
        }

        public List<Recommendation> getRecommendationByActivityId(String activityId) {
                List<Recommendation> recommendations = recommendationRepository.findByActivityId(activityId);

                if (recommendations.isEmpty()) {
                        throw new RuntimeException("No recommendations found for activity ID: " + activityId);
                }

                return recommendations;
        }
}

package com.project.fitness.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationRequest {
    private String userId;

    private String type;

    private String recommendation;

    private List<String> improvements;

    private List<String> suggestions;

    private List<String> safety;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

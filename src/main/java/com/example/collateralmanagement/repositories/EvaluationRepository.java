package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.valuation.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    List<Evaluation> findAllByAssetId (Long id);

    Optional<Evaluation> findTopByAssetIdOrderByDateDesc(Long assetId);
}

package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CollateralRepository extends JpaRepository<Collateral, Long> {
    List<Collateral> findAllByAssetId(Long assetId);

    @Query("SELECT c from Collateral As c JOIN c.loans As l where l.id = :loanId")
    Set<Collateral> findAllByLoanId(Long loanId);
}


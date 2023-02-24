package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    List<Asset> findAllByCurrentAccountableDepartmentName (DepartmentEnum departmentEnum);

    @Query("SELECT a FROM Asset AS a JOIN Collateral AS c JOIN BankClient AS b WHERE b.identificationNumber = :bulstatOrEGN")
    List<Asset> findAllByClient(@Param("bulstatOrEGN") String bulstatOrEGN );

    List<Asset> findAllByOwnerIgnoreCase(String owner);

}

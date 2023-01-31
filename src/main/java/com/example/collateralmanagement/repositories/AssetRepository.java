package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    List<Asset> findAllByCurrentAccountableDepartmentName (DepartmentEnum departmentEnum);

}

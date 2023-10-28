package com.company.expressbank.repository;

import com.company.expressbank.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends  JpaRepository<Supplier,Long> {
}

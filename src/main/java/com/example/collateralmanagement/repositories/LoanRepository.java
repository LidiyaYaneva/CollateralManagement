package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.business.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByLoanNumber(String loanNumber);

    Set<Loan> findAllByClientId (Long clientId);

    Page<Loan> findAllByActiveIsTrue (PageRequest pageRequest);


}

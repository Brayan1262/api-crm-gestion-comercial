package com.brayan.salesflow.repository;

import com.brayan.salesflow.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByCustomerId(Long customerId);

    List<Activity> findByOpportunityId(Long opportunityId);

    List<Activity> findByCompletedFalse();

}

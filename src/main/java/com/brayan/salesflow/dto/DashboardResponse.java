package com.brayan.salesflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardResponse {

    private Long totalCustomers;
    private Long activeCustomers;
    private Long prospectCustomers;
    private Long inactiveCustomers;

    private Long totalContacts;

    private Long totalOpportunities;
    private Long openOpportunities;
    private Long wonOpportunities;
    private Long lostOpportunities;

    private BigDecimal totalEstimatedAmount;
    private BigDecimal wonAmount;

    private Long totalActivities;
    private Long pendingActivities;
    private Long completedActivities;
}
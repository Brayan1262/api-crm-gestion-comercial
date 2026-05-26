package com.brayan.salesflow.service;

import com.brayan.salesflow.dto.DashboardResponse;
import com.brayan.salesflow.entity.CustomerStatus;
import com.brayan.salesflow.entity.Opportunity;
import com.brayan.salesflow.entity.OpportunityStatus;
import com.brayan.salesflow.repository.ActivityRepository;
import com.brayan.salesflow.repository.ContactRepository;
import com.brayan.salesflow.repository.CustomerRepository;
import com.brayan.salesflow.repository.OpportunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;
    private final OpportunityRepository opportunityRepository;
    private final ActivityRepository activityRepository;

    public DashboardResponse getDashboard() {
        Long totalCustomers = customerRepository.count();

        Long activeCustomers = (long) customerRepository.findByStatus(CustomerStatus.ACTIVE).size();
        Long prospectCustomers = (long) customerRepository.findByStatus(CustomerStatus.PROSPECT).size();
        Long inactiveCustomers = (long) customerRepository.findByStatus(CustomerStatus.INACTIVE).size();

        Long totalContacts = contactRepository.count();

        List<Opportunity> opportunities = opportunityRepository.findAll();

        Long totalOpportunities = (long) opportunities.size();

        Long wonOpportunities = opportunities.stream()
                .filter(opportunity -> opportunity.getStatus() == OpportunityStatus.WON)
                .count();

        Long lostOpportunities = opportunities.stream()
                .filter(opportunity -> opportunity.getStatus() == OpportunityStatus.LOST)
                .count();

        Long openOpportunities = opportunities.stream()
                .filter(opportunity ->
                        opportunity.getStatus() != OpportunityStatus.WON &&
                        opportunity.getStatus() != OpportunityStatus.LOST
                )
                .count();

        BigDecimal totalEstimatedAmount = opportunities.stream()
                .map(Opportunity::getEstimatedAmount)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal wonAmount = opportunities.stream()
                .filter(opportunity -> opportunity.getStatus() == OpportunityStatus.WON)
                .map(Opportunity::getEstimatedAmount)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Long totalActivities = activityRepository.count();
        Long pendingActivities = (long) activityRepository.findByCompletedFalse().size();
        Long completedActivities = totalActivities - pendingActivities;

        return DashboardResponse.builder()
                .totalCustomers(totalCustomers)
                .activeCustomers(activeCustomers)
                .prospectCustomers(prospectCustomers)
                .inactiveCustomers(inactiveCustomers)
                .totalContacts(totalContacts)
                .totalOpportunities(totalOpportunities)
                .openOpportunities(openOpportunities)
                .wonOpportunities(wonOpportunities)
                .lostOpportunities(lostOpportunities)
                .totalEstimatedAmount(totalEstimatedAmount)
                .wonAmount(wonAmount)
                .totalActivities(totalActivities)
                .pendingActivities(pendingActivities)
                .completedActivities(completedActivities)
                .build();
    }
}
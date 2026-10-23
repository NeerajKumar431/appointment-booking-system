package com.neeraj.slotwise.repository;

import com.neeraj.slotwise.entity.ServiceOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering,Long> {
    List<ServiceOffering> findByProviderId(Long providerId);
}

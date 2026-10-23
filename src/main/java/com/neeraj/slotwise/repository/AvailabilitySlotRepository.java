package com.neeraj.slotwise.repository;

import com.neeraj.slotwise.entity.AvailabilitySlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot,Long> {
    List<AvailabilitySlot> findByProviderId(Long providerId);
}

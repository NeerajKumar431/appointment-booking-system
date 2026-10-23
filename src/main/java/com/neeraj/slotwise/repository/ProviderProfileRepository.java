package com.neeraj.slotwise.repository;

import com.neeraj.slotwise.entity.ProviderProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderProfileRepository extends JpaRepository<ProviderProfile,Long> {
    Optional<ProviderProfile> findByUserId(Long userId);
}

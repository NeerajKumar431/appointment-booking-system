package com.neeraj.slotwise.repository;

import com.neeraj.slotwise.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByCustomerId(Long customerId);
}

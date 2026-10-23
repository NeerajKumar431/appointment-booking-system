package com.neeraj.slotwise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "provider_profiles")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProviderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false, length = 150)
    private String businessName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 100)
    private String category;

    @Column(length = 20)
    private String phone;
}
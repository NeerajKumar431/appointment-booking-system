# Appointment Booking System: Requirements

## 1. Problem Statement

A platform where customers can book appointments with service providers (clinics, salons, tutors, etc.), and providers can manage their services and availability. The system must prevent two customers from booking the same time slot.

## 2. User Roles

| Role | Description |
|------|-------------|
| `CUSTOMER` | Browses providers and services, books, cancels, and views booking history |
| `PROVIDER` | Manages own profile, services, and weekly availability; approves or rejects bookings |
| `ADMIN` | Manages users and oversees the platform (later phase) |

## 3. Functional Requirements (MVP)

### Authentication and Authorization
- FR-1: A user can register with full name, email, password, and role (`CUSTOMER` or `PROVIDER`).
- FR-2: A user can log in with email and password and receive a JWT.
- FR-3: Endpoints are protected by role.

### Provider Features
- FR-4: A provider can create and update a profile (business name, description, category, phone).
- FR-5: A provider can create, update, deactivate, and list their services (name, description, duration in minutes, price).
- FR-6: A provider can set weekly availability (day of week, start time, end time).
- FR-7: A provider can view bookings made with them, and approve or reject pending ones.

### Customer Features
- FR-8: A customer can browse and search providers and their services.
- FR-9: A customer can view available time slots for a service on a chosen date.
- FR-10: A customer can book an available slot.
- FR-11: A customer can cancel their own booking.
- FR-12: A customer can view their booking history.

### Booking Rules
- FR-13: Two bookings cannot overlap for the same provider (double-booking prevention).
- FR-14: Bookings cannot be made in the past.
- FR-15: Booking status flow: `PENDING` -> `CONFIRMED` / `REJECTED` / `CANCELLED`.
- FR-16: Booking history supports pagination, filtering (by status and date), and sorting.

## 4. Non-Functional Requirements
- NFR-1: Passwords are stored hashed (BCrypt).
- NFR-2: All request bodies are validated, and errors return a consistent JSON format.
- NFR-3: Booking creation is transactional and safe under concurrent requests.
- NFR-4: The API is documented with Swagger/OpenAPI.
- NFR-5: Core service logic is covered by unit tests.
- NFR-6: The application runs with Docker Compose.

## 5. Out of Scope for v1
- Online payments
- Email or SMS notifications
- Reviews and ratings
- Calendar sync (Google Calendar, etc.)
- Recurring appointments

## 6. Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Spring Boot 3, Spring Security + JWT, Spring Data JPA (Hibernate) |
| Database | PostgreSQL |
| Frontend | React (Vite), React Router, Axios, Tailwind CSS |
| Testing | JUnit, Mockito |
| DevOps | Docker, Docker Compose |

## 7. Core Entities (Preview)

| Table | Key fields |
|-------|-----------|
| `users` | id, full_name, email (unique), password, role, created_at |
| `provider_profiles` | id, user_id (unique FK), business_name, description, category, phone |
| `service_offerings` | id, provider_id (FK), name, description, duration_minutes, price, active |
| `availability_slots` | id, provider_id (FK), day_of_week, start_time, end_time |
| `bookings` | id, customer_id (FK), service_id (FK), start_time, end_time, status, created_at, version |

## 8. Success Criteria
- A user can register, log in, and complete a booking end to end.
- Concurrent attempts to book the same slot result in exactly one success.
- The project is deployed with a live link, a README, and a demo video.

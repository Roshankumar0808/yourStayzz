![alt text](https://github.com/Roshankumar0808/yourStayzz/blob/master/swagger1.png)
![alt text](https://github.com/Roshankumar0808/yourStayzz/blob/master/swagger2.png)
![alt text](https://github.com/Roshankumar0808/yourStayzz/blob/master/swagger3.png)
![alt text](https://github.com/Roshankumar0808/yourStayzz/blob/master/swagger4.png)
# 🏨 Hotel Management System - Spring Boot Project

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue.svg)](https://www.postgresql.org/)
[![JWT](https://img.shields.io/badge/JWT-Authentication-red.svg)](https://jwt.io/)
[![Stripe](https://img.shields.io/badge/Stripe-Payment-purple.svg)](https://stripe.com/)

## 📋 Project Overview
A comprehensive **Hotel Booking system** built with **Spring Boot** that handles the complete hotel operations lifecycle with robust backend architecture and real-world business features.

## ✨ Key Features

### 🏨 **Hotel Administration**
- **Admin Panel**: Hotel managers can add, update, and remove hotels
- **Room Management**: Complete CRUD operations for room inventory
- **Hotel Details**: Manage hotel information, amenities, and availability

### 🛏️ **Room Booking System**
- **Real-time Availability**: Check room availability by date ranges
- **Booking Management**: Create, modify, and cancel reservations
- **Booking Status Tracking**: Track booking lifecycle from reservation to checkout

### 👥 **Guest Management**
- **Guest Registration**: Add and manage guest information
- **Guest History**: Track previous bookings and preferences
- **User Roles**: Separate access levels for guests and hotel managers

### 💳 **Payment Processing**
- **Stripe Integration**: Secure payment gateway for transactions
- **Payment Tracking**: Monitor payment status and history
- **Webhook Handling**: Real-time payment status updates

### 🔒 **Concurrency & Data Integrity**
- **@Transactional**: Database transaction management to prevent data inconsistency
- **Thread Safety**: Handles multiple concurrent bookings without conflicts
- **Race Condition Prevention**: Ensures inventory accuracy during simultaneous booking attempts
- **Optimistic Locking**: Prevents double-booking scenarios

## 🛠️ Technical Stack

| Technology | Purpose |
|------------|---------|
| **Spring Boot 3.3.3** | Main Framework |
| **Java 21** | Programming Language |
| **Spring Security** | Authentication & Authorization |
| **Spring Data JPA** | Data Access Layer |
| **PostgreSQL** | Primary Database |
| **JWT** | Stateless Authentication |
| **Stripe API** | Payment Processing |
| **Swagger/OpenAPI** | API Documentation |
| **Maven** | Dependency Management |
| **Lombok** | Code Generation |

## 🚀 Technical Highlights

- **JWT Authentication**: Secure user authentication and authorization
- **PostgreSQL Database**: Reliable data persistence with proper relationships
- **RESTful APIs**: Clean API design with proper HTTP methods
- **Exception Handling**: Robust error management and user feedback
- **Spring Security**: Role-based access control for different user types

## 🏗️ Architecture

```
├── Controller Layer    → REST API endpoints
├── Service Layer      → Business logic implementation
├── Repository Layer   → Data access operations
└── Entity Layer       → Database entities & relationships
```

## 📊 Database Schema

### Core Entities
- **User**: Authentication and role management
- **Hotel**: Hotel information and management
- **Room**: Room details and inventory
- **Booking**: Reservation and booking lifecycle
- **Payment**: Transaction and payment tracking

## 🔧 Setup & Installation

### Prerequisites
- Java 21 or higher
- Maven 3.6+
- PostgreSQL 12+
- Stripe Account (for payment processing)

---

⭐ **Star this repository if you found it helpful!**

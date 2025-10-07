package com.azizyilmaz.fee.entity;

import com.azizyilmaz.fee.enums.CustomerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String mbbNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerType type;

    @Column(nullable = false)
    private OffsetDateTime openedDate;

    @Column(nullable = false, unique = true)
    private String identityNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, length = 255)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state; // Active, Inactive

}
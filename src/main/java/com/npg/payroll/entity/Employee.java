package com.npg.payroll.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="tb_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 5)
    private Long employeeId;

    @NotBlank(message = "First name is required")
    @Column(nullable = false,length = 255)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(nullable = false,length = 255)
    private String lastName;

}

package com.paycore.CreditSystem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application")
@Builder
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Integer credit_limit;

    @NotNull
    private String credit_result;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Customer customer;
}

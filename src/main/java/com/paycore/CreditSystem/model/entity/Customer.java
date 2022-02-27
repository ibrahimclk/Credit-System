package com.paycore.CreditSystem.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "identity number can not be null")
    private String identityno;

    @NotNull(message = "firstname can not be null")
    private String firstname;

    @NotNull(message = "lastname can not be null")
    private String lastname;

    @NotNull(message = "salary can not be null")
    private Integer salary;

    @NotNull(message = "phone can not be null")
    private String phone;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Application application;

}


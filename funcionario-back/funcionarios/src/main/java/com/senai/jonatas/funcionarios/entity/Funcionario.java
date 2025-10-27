/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.jonatas.funcionarios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "funcionarios", uniqueConstraints = {
        @UniqueConstraint(name = "uk_funcionario_email", columnNames = "email")
})
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String nome;

    private String email;

    private String cargo;

    private BigDecimal salario;

    private LocalDate dataAdmissao;

    @Builder.Default
    private Boolean ativo = Boolean.TRUE;

    @PrePersist @PreUpdate
    private void normalize() {
        if (nome != null) nome = nome.trim();
        if (email != null) email = email.trim().toLowerCase();
        if (cargo != null) cargo = cargo.trim();
    }
}


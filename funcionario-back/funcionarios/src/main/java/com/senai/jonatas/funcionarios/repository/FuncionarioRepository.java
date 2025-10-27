/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.jonatas.funcionarios.repository;

import com.senai.jonatas.funcionarios.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCase(String email);

    List<Funcionario> findByCargoIgnoreCaseContainingOrderByNomeAsc(String cargo);

    List<Funcionario> findByAtivoOrderByNomeAsc(Boolean ativo);

    List<Funcionario> findByCargoIgnoreCaseContainingAndAtivoOrderByNomeAsc(String cargo, Boolean ativo);

    List<Funcionario> findAllByOrderByNomeAsc();
}

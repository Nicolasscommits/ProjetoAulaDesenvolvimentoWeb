package com.curso.boot.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    private String cpf;

    @Column(name = "salario", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private Double salario;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_entrada", nullable = true, columnDefinition = "DATE")
    private LocalDate dataEntrada;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_saida", nullable = true, columnDefinition = "DATE")
    private LocalDate dataSaida;

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "cargo_id_fk")
    private Cargo cargo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataEntrada() {
        return this.dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return this.dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

}

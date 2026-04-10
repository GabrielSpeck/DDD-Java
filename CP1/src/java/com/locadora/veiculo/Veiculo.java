package com.locadora.veiculo;

// ------------------------------
// Classes com Atributos Privados
// ------------------------------
public class Veiculo{
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private Categoria categoria.;
    private Status status;

    // ------------------------------
    // Construtores com Validações
    // ------------------------------
    public Veiculo(String placa, String maraca, String modelo, int ano, String categoria, String status){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.categoria = categoria;
        this.status = status;
    }

    // ------------------------------
    // Regras de Negócio
    // ------------------------------

    public enum Categoria {
        ECONOMICO,
        INTERMEDIARIO,
        EXECUTIVO,
        MOTO,
        VAN
    }

    public enum Status{
        DISPONIVEL,
        ALUGADO
    }

    public void nuncaNull() {
        if (this.status == null)
            this.status = Status.DISPONIVEL;
    }

    public boolean isDisponivel() {
        return this.status == Status.DISPONIVEL;
    }

    public void alugar(){
        if (!isDisponivel()) {
            throw new RuntimeException("Veículo já está alugado.");
        }
        this.status = StatusVeiculo.ALUGADO;
    }

    public void devolver() {
        this.status = StatusVeiculo.DISPONIVEL;
    }

    public getPrecoDiaria(){
        switch (categoria){
            case ECONOMICO: return 80;
            case INTERMEDIARIO: return 120;
            case EXECUTIVO: return 200;
            case MOTO: return 50;
            case VAN; return 180;
        }
    }

    // ------------------------------
    // GETTERS
    // ------------------------------
    public String getPlaca(){return placa;}
    public String getMarca(){return marca;}
    public String getModelo(){return modelo;}
    public int getAno(){return ano;}

}
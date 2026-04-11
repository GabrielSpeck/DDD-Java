package com.locadora.veiculo;

// ------------------------------
// Classes com Atributos Privados
// ------------------------------
public class Veiculo{
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private Categoria categoria;
    private Status status;

    // ------------------------------
    // Construtores com Validações
    // ------------------------------
    public Veiculo(String placa, String marca, String modelo, int ano, Categoria categoria){ //tirei o String categoria, pois permitiria q colocassem qualquer valor/erro de digitação
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.categoria = categoria;
        this.status = Status.DISPONIVEL; //mudei o status tbm, para já começar com disponível
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
        this.status = Status.ALUGADO;
    }

    public void devolver() {
        this.status = Status.DISPONIVEL;
    }

    public double   getPrecoDiaria(){ //coloquei double pq pode ter centavos, e msm se n tiver, fica melhor, por ex: 80.00 não só 80
        switch (categoria){
            case ECONOMICO: return 80;
            case INTERMEDIARIO: return 120;
            case EXECUTIVO: return 200;
            case MOTO: return 50;
            case VAN: return 180;
            default: throw new RuntimeException("Categoria inválida"); // Não deveria cair aqui nunca (porque usamos enum), mas se acontecer é bug e a gente força o erro pra não passar despercebido
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
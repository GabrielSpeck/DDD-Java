package com.locadora.cliente;
import java.util.UUID;

// ------------------------------
// Classes com Atributos Privados
// ------------------------------
public class Cliente {
    private String nome;
    private String id;
    private String cpf;
    private String telefone;
    private CNH cnh;
    // ------------------------------
    // Construtores com Validações
    // ------------------------------

    public Cliente(String nome, String cpf, String telefone, CNH cnh) {
        this.nome = nome;
        this.id = UUID.randomUUID().toString();//não precisa do java.util pq a gente ja deu import (linha 2)
        this.cpf = cpf;
        this.telefone = telefone;
        this.cnh = cnh;

        System.out.println("Parabéns, o Cliente: " + nome + " foi cadastrado com sucesso!");
    }

    // ------------------------------
    // GETTERS
    // ------------------------------
    public String getNome() {return nome;}
    public String getId() {return id;}
    public String getTelefone() {return telefone;}
    public String getCpf() {return cpf;}
    public boolean temCnhValida() {return cnh.estaValida();}
}
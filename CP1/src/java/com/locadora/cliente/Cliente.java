package com.locadora.cliente;
import java.util.UUID;

// ------------------------------
// Classes com Atributos Privados
// ------------------------------
public class Cliente {
    private String nome;
    private String id;
    private String telefone;
    private String cnh;

    // ------------------------------
    // Construtores com Validações
    // ------------------------------

    public Cliente(String nome, String id, String telefone, String cnh) {
        this.nome = nome;
        this.id = java.util.UUID.randomUUID().toString();
        this.telefone = telefone;
        this.cnh = cnh;

        System.out.println("Parabéns, o Cliente: " + cliente + " foi cadastrado com sucesso!")
    }

    // ------------------------------
    // GETTERS
    // ------------------------------
    public String getNome(){return nome;}
    public String getId(){return id;}
    public String getTelefone(){return telefone;}
    public String getCnh(){return cnh;}
}
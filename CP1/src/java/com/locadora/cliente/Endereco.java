package com.locadora.cliente;

// ------------------------------
// Classes com Atributos Privados
// ------------------------------
public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String numero;
    private String cep;

    // ------------------------------
    // Construtores com Validações
    // ------------------------------
    public Endereco(String rua, String bairro, String cidade, String numero, String cep){
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
    }

    // ------------------------------
    // GETTERS
    // ------------------------------
    public String getRua(){return rua;}
    public String getBairro(){return bairro;}
    public String getCidade(){return cidade;}
    public String getNumero(){return numero;}
    public String getCep(){return cep;}

    // ------------------------------
    // Mostrar Informações.
    // ------------------------------
    public class retornarEndereco(){
        return rua + ", " + numero + "," + bairro + ", " + cidade + "- CEP: " + cep
    }
}
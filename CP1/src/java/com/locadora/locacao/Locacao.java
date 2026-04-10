package com.locadora.locacao;

import java.time.LocalDate;
import java.util.UUID;

// ------------------------------
// Classes com Atributos Privados
// ------------------------------
public class Locacao {
    private String id;
    private String clienteId;
    private String veiculoId;

    private LocalDate dataRetirada;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataRealDevolucao;

    // ------------------------------
    // Construtores com Validações
    // ------------------------------
    public Locacao(String id, String clienteId, String veiculoId, LocalDate dataRetirada, LocalDate dataPrevistaDevolucao,
                   LocalDate dataPrevistaDevolucao)
        this.id = UUID.randomUUID().toString();
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
        this.dataRetirada = dataRetirada;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataRealDevolucao = null;
    }

    // ------------------------------
    // GETTERS
    // ------------------------------
    public String getId() { return id; }
    public String getClienteId() { return clienteId; }
    public String getVeiculoId() { return veiculoId; }

    public LocalDate getDataRetirada() { return dataRetirada; }
    public LocalDate getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public LocalDate getDataRealDevolucao() { return dataRealDevolucao; }
}
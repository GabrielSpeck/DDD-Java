package com.locadora.locacao;
import com.locadora.cliente.Cliente;
import com.locadora.veiculo.Veiculo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Locacao {
    private String id;
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataRetirada;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataRealDevolucao;

    // Construtor com regras de negócio
    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataRetirada, LocalDate dataPrevistaDevolucao) {

        // Regra 1: Veículo deve estar disponível
        if (!veiculo.isDisponivel()) {
            throw new RuntimeException("Veículo já está alugado!");
        }

        // Regra 2: Cliente deve ter CNH válida
        if (!cliente.temCnhValida()) {
            throw new RuntimeException("Cliente com CNH vencida!");
        }

        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataRetirada = dataRetirada;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;

        // Marca o veículo como alugado
        veiculo.alugar();
    }

    // Registrar devolução
    public void registrarDevolucao(LocalDate dataReal) {
        this.dataRealDevolucao = dataReal;
        veiculo.devolver();
    }

    // Cálculo do valor base
    public double calcularValorBase() {
        long dias = ChronoUnit.DAYS.between(dataRetirada, dataPrevistaDevolucao);
        return dias * veiculo.getPrecoDiaria();
    }

    // Cálculo de atraso
    public long calcularDiasAtraso() {
        if (dataRealDevolucao == null || !dataRealDevolucao.isAfter(dataPrevistaDevolucao)) {
            return 0;
        }
        return ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataRealDevolucao);
    }

    // Multa
    public double calcularMulta() {
        return calcularDiasAtraso() * 50;
    }

    // Valor total
    public double calcularValorTotal() {
        return calcularValorBase() + calcularMulta();
    }

    // GETTERS
    public String getId() {return id;}
    public Cliente getCliente() {return cliente;}
    public Veiculo getVeiculo() {return veiculo;}
    public LocalDate getDataRetirada() {return dataRetirada;}
    public LocalDate getDataPrevistaDevolucao() {return dataPrevistaDevolucao;}
    public LocalDate getDataRealDevolucao() {return dataRealDevolucao;}
}
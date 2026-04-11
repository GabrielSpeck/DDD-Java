import com.locadora.cliente.Cliente;
import com.locadora.cliente.CNH;
import com.locadora.veiculo.Veiculo;
import com.locadora.veiculo.Veiculo.Categoria;
import com.locadora.locacao.Locacao;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA LOCADORA ===\n");

        // ------------------------------
        // CENÁRIO 1: Locação com sucesso
        // ------------------------------
        try {
            CNH cnhValida = new CNH("12345", LocalDate.of(2027, 1, 1));
            Cliente cliente1 = new Cliente("João", "12345678900", "119999999", cnhValida);

            Veiculo veiculo1 = new Veiculo("ABC1234", "Fiat", "Uno", 2020, Categoria.ECONOMICO);

            Locacao locacao1 = new Locacao(
                    cliente1,
                    veiculo1,
                    LocalDate.now(),
                    LocalDate.now().plusDays(3)
            );

            System.out.println("Locação criada com sucesso!");
            System.out.println("Valor: R$ " + locacao1.calcularValorBase());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n------------------------------\n");

        // ------------------------------
        // CENÁRIO 2: Veículo já alugado
        // ------------------------------
        try {
            CNH cnhValida = new CNH("12345", LocalDate.of(2027, 1, 1));
            Cliente cliente2 = new Cliente("Maria", "98765432100", "118888888", cnhValida);

            Veiculo veiculo2 = new Veiculo("DEF5678", "VW", "Gol", 2021, Categoria.INTERMEDIARIO);

            Locacao locacaoA = new Locacao(cliente2, veiculo2, LocalDate.now(), LocalDate.now().plusDays(2));

            // Tentativa de alugar o mesmo veículo novamente
            Locacao locacaoB = new Locacao(cliente2, veiculo2, LocalDate.now(), LocalDate.now().plusDays(2));

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n------------------------------\n");

        // ------------------------------
        // CENÁRIO 3: CNH vencida
        // ------------------------------
        try {
            CNH cnhVencida = new CNH("99999", LocalDate.of(2020, 1, 1));
            Cliente cliente3 = new Cliente("Carlos", "11122233344", "117777777", cnhVencida);

            Veiculo veiculo3 = new Veiculo("GHI9012", "Toyota", "Corolla", 2022, Categoria.EXECUTIVO);

            Locacao locacao3 = new Locacao(cliente3, veiculo3, LocalDate.now(), LocalDate.now().plusDays(2));

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n------------------------------\n");

        // ------------------------------
        // CENÁRIO 4: Devolução no prazo
        // ------------------------------
        try {
            CNH cnhValida = new CNH("22222", LocalDate.of(2027, 1, 1));
            Cliente cliente4 = new Cliente("Ana", "55566677788", "116666666", cnhValida);

            Veiculo veiculo4 = new Veiculo("JKL3456", "Honda", "Civic", 2023, Categoria.EXECUTIVO);

            Locacao locacao4 = new Locacao(
                    cliente4,
                    veiculo4,
                    LocalDate.now(),
                    LocalDate.now().plusDays(3)
            );

            locacao4.registrarDevolucao(LocalDate.now().plusDays(3));

            System.out.println("Valor total (sem multa): R$ " + locacao4.calcularValorTotal());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n------------------------------\n");

        // ------------------------------
        // CENÁRIO 5: Devolução com atraso
        // ------------------------------
        try {
            CNH cnhValida = new CNH("33333", LocalDate.of(2027, 1, 1));
            Cliente cliente5 = new Cliente("Pedro", "99988877766", "115555555", cnhValida);

            Veiculo veiculo5 = new Veiculo("MNO7890", "Chevrolet", "Onix", 2022, Categoria.ECONOMICO);

            Locacao locacao5 = new Locacao(
                    cliente5,
                    veiculo5,
                    LocalDate.now(),
                    LocalDate.now().plusDays(2)
            );

            // devolveu 2 dias atrasado
            locacao5.registrarDevolucao(LocalDate.now().plusDays(4));

            System.out.println("Multa: R$ " + locacao5.calcularMulta());
            System.out.println("Valor total: R$ " + locacao5.calcularValorTotal());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
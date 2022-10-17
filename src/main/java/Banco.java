import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Banco {

    private static Long tamanho_contas_no_banco = 0L;
    private static Long contas_cc = 0L;
    private static Long contas_cp = 0L;
    private static boolean verifica = true;

    private String nome;
    private List<Conta> contas = new ArrayList<>();


    public Banco(String nome) {
        this.nome = nome;
    }


    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void estatisticasDoBanco(){
        verifica = true;
        do {
            if (tamanho_contas_no_banco == (long) contas.size()) {
                System.out.println("=== Estatísticas do banco ===");
                System.out.println("Total de Contas(CC): " + contas_cc);
                System.out.println("Total de Contas(CP): " + contas_cp);
                System.out.println("\nTotal de Contas: " + tamanho_contas_no_banco);
                System.out.println("=============================");
                verifica = false;
            } else {
                tamanho_contas_no_banco = (long) contas.size();
                contas_cc = 0L;
                contas_cp = 0L;
                contas.forEach(c -> {
                    if ("cc".equals(c.getCliente().getTipoConta())) {
                        contas_cc += 1L;
                    } else {
                        contas_cp += 1L;
                    }
                });
            }
        }while (verifica);
    }


}

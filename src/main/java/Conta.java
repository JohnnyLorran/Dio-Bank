import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Conta implements IConta {

    private static int agencia_padrao = 0033;
    private static int sequencial = 1;
    private static boolean verifica = true ;

    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = agencia_padrao;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(verifica){
            if(saldo >= valor){
                saldo -= valor;
                System.out.printf("Sacado: %.2f%n \n", valor);
            }else{
                System.out.println("Saldo insuficiente.\n");
            }
        }else{
            saldo -= valor;
        }

    }

    @Override
    public void depositar(double valor) {
        if(verifica) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.\n");
        }else{
            saldo += valor;
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(saldo >= valor){
            verifica = false;
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.\n");
            verifica = true;
        }else{
            System.out.println("Transferência não realiazada, saldo insuficiente.\n");
        }
    }

    protected void imprmirDadosConta() {
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: %.2f %n", this.saldo);
        System.out.println("===============================\n");
    }

}

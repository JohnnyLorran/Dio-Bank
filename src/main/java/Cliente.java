import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    private String nome;
    private String cpf;
    private String tipoConta;


    public Cliente(String nome, String cpf, String tipoConta) {
        this.nome = nome;
        this.cpf = cpf;
        if(tipoConta.equals("cc") || (tipoConta.equals("cp"))){
            this.tipoConta = tipoConta;
        }else{
            System.out.println("Tipo de conta informado, é inválido !");
            System.out.println("A conta foi criada como conta corrent. !");
            this.tipoConta = "cc";
        }

    }

    public void imprimirDadosCliente(){
        System.out.println("=== Dados do cliente ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("=========================\n");
    }


}

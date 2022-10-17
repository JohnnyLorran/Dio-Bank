public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("AgixBank");

        Conta cc = new ContaCorrente(new Cliente("Johnny", "14575859625","cc"));
        cc.depositar(100);

        banco.adicionarConta(cc);

        Conta cp = new ContaPoupanca(new Cliente("Rodrigues", "14575859627","cp"));
        cp.depositar(150);

        banco.adicionarConta(cp);

        cc.transferir(100,cp);

        cp.imprimirExtrado();
        cp.getCliente().imprimirDadosCliente();

        banco.estatisticasDoBanco();

    }
}

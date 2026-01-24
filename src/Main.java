//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BancoDeDados dados = new BancoDeDados();
        Relatorio relatorio = new Relatorio(dados);

        InterfaceGrafica tela = new InterfaceGrafica(dados, relatorio);
        Notificacoes notificacao = new Notificacoes(relatorio);
        notificacao.start();

        }
    }
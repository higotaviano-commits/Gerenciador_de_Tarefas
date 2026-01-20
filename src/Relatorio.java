import java.util.Comparator;

public class Relatorio {


    /// Atributos
    private BancoDeDados banco;


    /// Construtor
    public Relatorio(BancoDeDados banco) {
        this.banco = banco;
    }


    /// Método Listar
    public void listarTodos(){
        banco.getLista().forEach(System.out::println);
    }


    /// Filtrar por status
    public void filtrarPorStatus(Status status){
        banco.filtrarPorStatus(status).forEach(System.out::println);
    }

    /// Ordenar por data limite
    public void ordenarPorDataLimite(){
        banco.ordenarPorDataLimite().forEach(System.out::println);
    }
}



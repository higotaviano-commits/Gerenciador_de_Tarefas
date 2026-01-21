import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Relatorio {


    /// Atributos
    private BancoDeDados banco;


    /// Construtor
    public Relatorio(BancoDeDados banco) {
        this.banco = banco;
    }

    /// Método Listar List
    public List<Tarefa> listarTodosList(){
        return banco.getLista();
    }


    /// Método Listar
    public String listarTodos(){
        return banco.getLista().stream().
                map(Tarefa::toString).
                collect(Collectors.joining("\n", "============", "\n"));
    }


    /// Método Filtrar por Status
    public String filtrarPorStatus(Status status) {
        return banco.getLista().stream().
                filter(s -> s.getStatus() == status).
                map(Tarefa::toString).
                collect(Collectors.joining("\n", "============", "\n"));
    }


    /// Ordenar por data limite
    public String ordenarPorDataLimite() {
        return banco.getLista().stream().
                sorted(Comparator.comparing(Tarefa::getDataLimite)).
                map(Tarefa::toString).
                collect(Collectors.joining("\n", "============", "\n"));
    }
}



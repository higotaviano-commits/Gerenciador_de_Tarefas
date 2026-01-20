import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BancoDeDados {


    /// Atributos
    private final List<Tarefa> lista = new ArrayList<>();


    /// Método Get
    public List<Tarefa> getLista() {
        return lista.stream().toList();
    }


    /// Método Cadastrar
    public void cadastrarTarefa(Tarefa tarefa) {
        lista.add(tarefa);
    }


    /// Método Filtrar por Status
    public List<Tarefa> filtrarPorStatus(Status status) {
        return lista.stream().
                filter(s -> s.getStatus() == status).
                toList();
    }

    /// Ordenar por data limite
    public List<Tarefa> ordenarPorDataLimite() {
        return lista.stream().
                sorted(Comparator.comparing(Tarefa::getDataLimite)).
                toList();
    }
}

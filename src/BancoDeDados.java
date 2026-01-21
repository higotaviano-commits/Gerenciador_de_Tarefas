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

}


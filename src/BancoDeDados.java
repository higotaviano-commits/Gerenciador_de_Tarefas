import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BancoDeDados implements Serializable {


    /// Atributos
    private List<Tarefa> lista;


    public BancoDeDados() {
        this.lista = new ArrayList<>();
    }

    public BancoDeDados(List<Tarefa> lista) {
        this.lista = lista;
    }



    /// Método Get
    public List<Tarefa> getLista() {
        return lista.stream().
                collect(Collectors.toList());
    }


    /// Método Cadastrar
    public void cadastrarTarefa(Tarefa tarefa) {
        lista.add(tarefa);
    }

}


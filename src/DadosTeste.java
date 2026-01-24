import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DadosTeste {

    /// Gerar lista
    public static List<Tarefa> gerarDados() {
        List<Tarefa> lista = new ArrayList<>();
        lista.add(new Tarefa("Tarefa 1", "Descrição Teste 1", LocalDate.of(2026, 05, 05), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 1", "Descrição Teste 1", LocalDate.of(2026, 6, 12), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 2", "Descrição Teste 2", LocalDate.of(2026, 7, 3), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 3", "Descrição Teste 3", LocalDate.of(2026, 6, 25), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 4", "Descrição Teste 4", LocalDate.of(2026, 8, 1), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 5", "Descrição Teste 5", LocalDate.of(2026, 7, 19), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 6", "Descrição Teste 6", LocalDate.of(2026, 6, 4), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 7", "Descrição Teste 7", LocalDate.of(2026, 9, 10), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 8", "Descrição Teste 8", LocalDate.of(2026, 7, 27), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 9", "Descrição Teste 9", LocalDate.of(2026, 8, 18), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 10", "Descrição Teste 10", LocalDate.of(2026, 6, 30), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 11", "Descrição Teste 11", LocalDate.of(2026, 7, 8), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 12", "Descrição Teste 12", LocalDate.of(2026, 8, 5), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 13", "Descrição Teste 13", LocalDate.of(2026, 6, 15), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 14", "Descrição Teste 14", LocalDate.of(2026, 9, 2), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 15", "Descrição Teste 15", LocalDate.of(2026, 7, 14), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 16", "Descrição Teste 16", LocalDate.of(2026, 8, 9), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 17", "Descrição Teste 17", LocalDate.of(2026, 6, 21), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 18", "Descrição Teste 18", LocalDate.of(2026, 9, 18), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 19", "Descrição Teste 19", LocalDate.of(2026, 7, 1), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 20", "Descrição Teste 20", LocalDate.of(2026, 8, 23), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 21", "Descrição Teste 21", LocalDate.of(2026, 6, 8), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 22", "Descrição Teste 22", LocalDate.of(2026, 9, 5), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 23", "Descrição Teste 23", LocalDate.of(2026, 7, 22), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 24", "Descrição Teste 24", LocalDate.of(2026, 8, 14), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 25", "Descrição Teste 25", LocalDate.of(2026, 6, 3), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 26", "Descrição Teste 26", LocalDate.of(2026, 7, 30), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 27", "Descrição Teste 27", LocalDate.of(2026, 9, 22), Status.CONCLUIDO));
        lista.add(new Tarefa("Tarefa 28", "Descrição Teste 28", LocalDate.of(2026, 8, 27), Status.PENDENTE));
        lista.add(new Tarefa("Tarefa 29", "Descrição Teste 29", LocalDate.of(2026, 6, 18), Status.EM_ANDAMENTO));
        lista.add(new Tarefa("Tarefa 30", "Descrição Teste 30", LocalDate.of(2026, 9, 12), Status.CONCLUIDO));

        return lista;
    }


}

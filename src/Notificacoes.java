import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Notificacoes {


    private Relatorio relatorio;
    private ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();


    /// Construtor
    public Notificacoes(Relatorio relatorio) {
        this.relatorio = relatorio;
    }


    /// Comecar a notificacao
    public void start (){
        schedule.scheduleAtFixedRate(this::verificarTarefaProxima, 0, 10, TimeUnit.SECONDS);
    }


    /// Metodo verificar alertas
    public String verificarTarefaProxima(){
        LocalDate amanha = LocalDate.now().plusDays(1);
        return relatorio.listarTodosList().stream().
                filter(tarefa -> tarefa.getDataLimite().plusDays(1) == amanha).
                map(Tarefa::toString).
                collect(Collectors.joining("\n", "====== Tarefas com data limite para amanhã ! ======", "\n"));

    }


}

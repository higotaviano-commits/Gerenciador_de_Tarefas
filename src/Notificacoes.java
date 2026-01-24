import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
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
        schedule.scheduleAtFixedRate(this::verificarTarefaProxima, 0, 20, TimeUnit.SECONDS);
    }


    /// Metodo verificar alertas
    public void verificarTarefaProxima(){
        LocalDate amanha = LocalDate.now().plusDays(1);
        List<Tarefa> filtro = relatorio.listarTodosList().stream().
                filter(tarefa -> tarefa.getDataLimite().isEqual(amanha)).
                collect(Collectors.toList());

        if(filtro.isEmpty()){
            return;
        }

        String mensagem = filtro.stream()
                .map(Tarefa::toString)
                .collect(Collectors.joining("\n", "========== Tarefas com data limite para amanhã ! ==========\n", "\n"));

        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, mensagem);
        });
    }


}

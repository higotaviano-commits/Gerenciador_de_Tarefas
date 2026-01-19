import java.time.LocalDate;

public class Tarefa {

    /// Atributos
    private final String titulo;
    private final String descricao;
    private final LocalDate dataLimite;
    private Status status;



    /// Construtor
    public Tarefa(String titulo, String descricao, LocalDate dataLimite, Status status) {
        validacao(titulo, dataLimite, status);
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataLimite = dataLimite;
        this.status = status;
    }


    /// validação de dados para o construtor
    private void validacao(String titulo, LocalDate dataLimite, Status status){
        if (titulo == null || titulo.length()<5){
            throw new IllegalArgumentException("Digite um titulo com no mínimo 5 caracteres.");
        }
        if (dataLimite == null || dataLimite.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("A data limite não pode ser uma data passada.");
        }
        if (status == null){
            throw new IllegalArgumentException("Você precisa definir um status para a tarefa.");
        }
    }



    /// Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    /// toString Override
    @Override
    public String toString(){
        return """
                Título: %s
                Data Limite: %s
                Status: %s
                Descrição: %s
                """.formatted(titulo, dataLimite, status, descricao);
    }
}

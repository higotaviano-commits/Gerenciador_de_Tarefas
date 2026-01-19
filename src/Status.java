public enum Status {

    PENDENTE("Pendente"), EM_ANDAMENTO("Em Andamento"), CONCLUIDO("Concluído");


    /// Atributo String Status
    private final String status;



    /// Construtor para toString
    Status(String status) {
        this.status = status;
    }


    /// metodo toString
    @Override
    public String toString(){
        return status;
    }
}

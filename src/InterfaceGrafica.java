import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



public class InterfaceGrafica {
    private BancoDeDados bancoDeDados;
    private Relatorio relatorio;

    JButton botaoSalvar;
    JTextField fieldTitulo;
    JTextField fieldData;
    JTextField fieldDescricao;
    JComboBox<Status> listaSuspensaStatus;
    JComboBox<Status> listaSuspensaFiltro;
    JComboBox<String> listaSuspensaOrdenarPorData;
    DefaultTableModel tabelaModelo;
    JFrame frame;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    /// Construtor
    public InterfaceGrafica(BancoDeDados bancoDeDados, Relatorio relatorio) {
        this.bancoDeDados = bancoDeDados;
        this.relatorio = relatorio;
        this.criaInterface();
    }

    /// Método Atualizar Lista
    public void atualizaLista(List<Tarefa> lista){
        tabelaModelo.setRowCount(0);
        for(Tarefa tarefa : lista){
            tabelaModelo.addRow(new Object[]{tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataLimite().format(formato), tarefa.getStatus()});
        }
    }

    ///  Metodo Salvar
    public void salvarTarefa(){

        if (!fieldData.getText().matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Use o formato dd/mm/yyyy no campo data.");
            return;
        }
        if (LocalDate.parse(fieldData.getText(),formato).isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "A data limite deve não pode ser anterior a hoje.");
            return;
        }
        if (fieldTitulo.getText().length() < 5) {
            JOptionPane.showMessageDialog(null, "Digite um título com no mínimo 5 caracteres.");
            return;
        }

        bancoDeDados.cadastrarTarefa(new Tarefa (
                fieldTitulo.getText(),
                fieldDescricao.getText(),
                LocalDate.parse(fieldData.getText(),formato),
                (Status) listaSuspensaStatus.getSelectedItem()
                )
        );
        fieldData.setText("");
        fieldDescricao.setText("");
        fieldTitulo.setText("");
        this.atualizaLista(bancoDeDados.getLista());
        JOptionPane.showMessageDialog(null, "Tarefa salva.");
    }


    /// Filtrar por status
    public void filtrarPorStatus(Status status){
        this.atualizaLista(relatorio.filtrarPorStatus(status));
    }


    /// Ordenar por Data
    public void ordenarPorData(){
        this.atualizaLista(relatorio.ordenarPorDataLimite());
    }






    /// Criando o frame
    public void criaInterface() {
        /// Button
        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> this.salvarTarefa());


        /// TextField
        fieldTitulo = new JTextField(20);
        fieldData = new JTextField(20);
        fieldDescricao = new JTextField(20);

        fieldTitulo.setToolTipText("Escreva um título para a tarefa.");
        fieldData.setToolTipText("dd/mm/yyyy");
        fieldDescricao.setToolTipText("Escreva uma descrição da tarefa.");


        /// Lista Suspensa
        listaSuspensaStatus = new JComboBox<>(Status.values());
        listaSuspensaFiltro = new JComboBox<>(Status.values());
        listaSuspensaFiltro.addActionListener(e -> {
                switch ((Status) listaSuspensaFiltro.getSelectedItem()) {
                    case Status.PENDENTE -> this.atualizaLista(relatorio.filtrarPorStatus(Status.PENDENTE));
                    case Status.EM_ANDAMENTO -> this.atualizaLista(relatorio.filtrarPorStatus(Status.EM_ANDAMENTO));
                    case Status.CONCLUIDO -> this.atualizaLista(relatorio.filtrarPorStatus(Status.CONCLUIDO));
                };
                });
        listaSuspensaOrdenarPorData = new JComboBox<>(new String[]{"Selecionar", "Data"});
        listaSuspensaOrdenarPorData.addActionListener(e -> {
            switch ((String) listaSuspensaOrdenarPorData.getSelectedItem()) {
                case "Selecionar" -> this.atualizaLista(bancoDeDados.getLista());
                case "Data" -> this.atualizaLista(relatorio.ordenarPorDataLimite());
            };
        });


        /// Tabela
        String[] colunas = {"Título", "Descrição", "Data limite", "Status"};
        tabelaModelo = new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(tabelaModelo);

        JScrollPane scroll = new JScrollPane(tabela);


        /// Painel
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JPanel painelNorte = new JPanel(new GridLayout(2, 4, 10, 10));
        JPanel painelSul = new JPanel(new GridLayout(2, 2, 10, 10));

        painelNorte.add(new JLabel("Título"));
        painelNorte.add(fieldTitulo);

        painelNorte.add(new JLabel("Descrição"));
        painelNorte.add(fieldDescricao);
        painelNorte.add(new JLabel(""));

        painelNorte.add(new JLabel("Data Limite"));
        painelNorte.add(fieldData);

        painelNorte.add(new JLabel("Status da Tarefa"));
        painelNorte.add(listaSuspensaStatus);

        painelNorte.add(botaoSalvar);

        painelSul.add(new JLabel("Filtrar por Status"));
        painelSul.add(listaSuspensaFiltro);

        painelSul.add(new JLabel("Ordenar por"));
        painelSul.add(listaSuspensaOrdenarPorData);


        painelPrincipal.add(painelNorte, BorderLayout.NORTH);
        painelPrincipal.add(scroll, BorderLayout.CENTER);
        painelPrincipal.add(painelSul, BorderLayout.SOUTH);


        /// Frame
        frame = new JFrame("Gerenciador de Tarefas");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(painelPrincipal);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }




}

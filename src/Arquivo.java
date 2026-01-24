import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Arquivo {


    /// Salvar em arquivo
    public static void salvarDados(List<Tarefa> lista){

        try (ObjectOutputStream streamObjeto = new ObjectOutputStream(new FileOutputStream("arquivo.ser"))){

        streamObjeto.writeObject(lista);
    }
    catch(IOException e){
            SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar os dados.")
            );
        }
    }



    /// Carregar arquivo
    public static List<Tarefa> carregarDados(){
        File arquivo = new File("arquivo.ser");

        if (!arquivo.exists()){
            return new ArrayList<>();
        }
        try (ObjectInputStream streamObjeto = new ObjectInputStream(new FileInputStream("arquivo.ser"))){
            return (List<Tarefa>) streamObjeto.readObject();
        }

        catch(IOException | ClassNotFoundException e){
            SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, "Erro ao tentar carregar os dados.")
            );
            return new ArrayList<>();
        }
    }

}

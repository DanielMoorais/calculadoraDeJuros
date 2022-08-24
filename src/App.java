import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    /* ***************************************************************
    * Metodo: main
    * Funcao: executa o programa
    * Parametros: args(dar prioridade na execucao)
    * Retorno: void
    *************************************************************** */

    public static void main(String[] args) throws Exception {
       launch(args);
    }

    /* ***************************************************************
    * Metodo: start
    * Funcao: carregar e inicializar a tela do programa
    * Parametros: primaryStage(carregar a tela)
    * Retorno: void
    *************************************************************** */

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("telaCalculadora.fxml"));
        Parent root = loader.load();
        Scene primaryScene = (new Scene(root));
        primaryStage.setTitle("Calculadora de Juros");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
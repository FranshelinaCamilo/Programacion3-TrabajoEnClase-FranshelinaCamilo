import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml")); 

        Scene scene = new Scene(loader.load());
        PrimaryStage.setTitle("Sistema básico de citas médicas");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
}

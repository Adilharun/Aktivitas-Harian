package scenebuilderlatihan;





import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneBuilderlatihan extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/scenebuilderlatihan/view/aktivitas-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Data Aktivitas Harian");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

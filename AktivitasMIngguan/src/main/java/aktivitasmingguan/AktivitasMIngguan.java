package aktivitasmingguan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AktivitasMIngguan extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/java/com/mycompany/aktivitasmingguan/AktivitasMingguan.java"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Data Aktivitas Harian");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

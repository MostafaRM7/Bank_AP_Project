package Bank_AP_Project.src.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }


}

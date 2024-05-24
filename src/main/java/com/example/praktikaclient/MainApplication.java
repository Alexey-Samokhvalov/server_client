package com.example.praktikaclient;

import com.example.praktikaclient.controller.AddSummaryController;
import com.example.praktikaclient.controller.MainController;
import com.example.praktikaclient.entity.SummaryEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainApplication extends Application {
    private FXMLLoader fxmlLoader;
    private static MainController mainController;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("Кадровое агентство");
        stage.setScene(scene);
        stage.show();
    }


    public static void showSummaryDialog(Optional<SummaryEntity> summary){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("summary-add-view.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Работа с книгами");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            AddSummaryController controller = loader.getController();
            controller.setSummary(summary);
            controller.start();
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            summary = controller.getSummary();
            System.out.println(summary);
            mainController.setSummary(summary);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
package com.example.praktikaclient.controller;

import com.example.praktikaclient.MainApplication;
import com.example.praktikaclient.entity.SummaryEntity;
import com.example.praktikaclient.service.SummaryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class MainController {

    SummaryService service = new SummaryService();

    private boolean addFlag = true;
    @FXML
    private void initialize() {

        service.getAll();

        columnLns.setCellValueFactory(new PropertyValueFactory<SummaryEntity, String>("lns"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory<SummaryEntity, String>("birthday"));
        columnActivities.setCellValueFactory(new PropertyValueFactory<SummaryEntity, String>("activities"));
        columnExperience.setCellValueFactory(new PropertyValueFactory<SummaryEntity, String>("experience"));
        columnEducation.setCellValueFactory(new PropertyValueFactory<SummaryEntity, String>("education"));
        columnSkills.setCellValueFactory(new PropertyValueFactory<SummaryEntity, String>("skills"));
        columnContacts.setCellValueFactory(new PropertyValueFactory<SummaryEntity, String>("contacts"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<SummaryEntity, String>("description"));
        summaryTable.setItems(service.getData());
    }

    @FXML
    private TableView<SummaryEntity> summaryTable;

    @FXML
    private TableColumn<SummaryEntity, String> columnActivities;

    @FXML
    private TableColumn<SummaryEntity, String> columnContacts;

    @FXML
    private TableColumn<SummaryEntity, String> columnDescription;

    @FXML
    private TableColumn<SummaryEntity, String> columnEducation;

    @FXML
    private TableColumn<SummaryEntity, String> columnExperience;

    @FXML
    private TableColumn<SummaryEntity, String> columnLns;

    @FXML
    private TableColumn<SummaryEntity, String> columnSkills;

    @FXML
    private TableColumn<SummaryEntity, String> columnBirthday;

    @FXML
    void addSummaryAction(ActionEvent event) {
        Optional<SummaryEntity> summary = Optional.empty();
        MainApplication.showSummaryDialog(summary);
    }


    private SummaryEntity getSelectionElement() {
        SummaryEntity temp = summaryTable.getSelectionModel().getSelectedItem();
        return temp;
    }

    private Optional<SummaryEntity> summary = Optional.empty();
    public void setSummary(Optional<SummaryEntity> summary) {
        this.summary = summary;
        if (summary.isPresent()) {
            if (summary.get().getId() != null) {
                service.update(summary.get(), summaryTable.getSelectionModel().getSelectedItem());
            }else service.add(summary.get());
        }
    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
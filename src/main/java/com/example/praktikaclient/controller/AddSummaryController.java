package com.example.praktikaclient.controller;

import com.example.praktikaclient.entity.SummaryEntity;
import com.example.praktikaclient.service.SummaryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class AddSummaryController {
    private final SummaryService service = new SummaryService();
    private boolean addFlag = true;


    @FXML
    private TextField textLns;

    @FXML
    private TextField textBirthday;

    @FXML
    private TextField textActivities;

    @FXML
    private TextField textExperience;

    @FXML
    private TextField textEducation;

    @FXML
    private TextField textSkills;

    @FXML
    private TextField textContacts;

    @FXML
    private TextField textDescription;

    @Setter
    @Getter
    private Optional<SummaryEntity> summary;

    public void start() {
        if (summary.isPresent()) {
            textLns.setText(summary.get().getLns());
            textBirthday.setText(summary.get().getBirthday());
            textActivities.setText(summary.get().getActivities());
            textExperience.setText(summary.get().getExperience());
            textEducation.setText(summary.get().getEducation());
            textSkills.setText(summary.get().getSkills());
            textContacts.setText(summary.get().getContacts());
            textDescription.setText(summary.get().getDescription());

        }
    }

    @FXML
    void addAction(ActionEvent event) {

        SummaryEntity temp = SummaryEntity.builder()
                .lns(textLns.getText())
                .birthday(textBirthday.getText())
                .activities(textActivities.getText())
                .experience(textExperience.getText())
                .education(textEducation.getText())
                .contacts(textContacts.getText())
                .description(textDescription.getText())
                .build();
        if (summary.isEmpty()) {
            summary = Optional.of(temp);
        } else {
            temp.setId(summary.get().getId());
            summary = Optional.of(temp);
        }
    }

    @FXML
    void cancelAction(ActionEvent event) {
        addFlag = true;
    }

}

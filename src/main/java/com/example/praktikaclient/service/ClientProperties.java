package com.example.praktikaclient.service;

import com.example.praktikaclient.MainApplication;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class ClientProperties {

    private final Properties properties = new Properties();

    private String allSummary;
    private String saveSummary;
    private String updateSummary;
    private String deleteSummary;
    private String fineByActivitiesSummary;
    private String fineBySkillsSummary;
    private String saveUser;
    private String allUser;
    private String allVacancy;
    private String saveVacancy;
    private String updateVacancy;
    private String deleteVacancy;
    private String fineByActivitiesVacancy;
    private String fineByChartVacancy;
    private String fineByRemoteWorkVacancy;
    private String allRecommendations;
    private String saveRecommendations;
    private String updateRecommendations;

    public ClientProperties() {
        try(
                InputStream input = MainApplication.class.getClassLoader().getResourceAsStream("config.properties")) {
            System.out.println(input);
            properties.load(input);
            allSummary = properties.getProperty("summary.getAll");
            saveSummary = properties.getProperty("summary.save");
            updateSummary = properties.getProperty("author.update");
            deleteSummary = properties.getProperty("summary.del");
            fineByActivitiesSummary = properties.getProperty("summary.fineByActivities");
            fineBySkillsSummary = properties.getProperty("summary.fineBySkills");
            saveUser = properties.getProperty("user.save");
            allUser = properties.getProperty("user.getAll");
            allVacancy = properties.getProperty("vacancy.getAll");
            saveVacancy = properties.getProperty("vacancy.save");
            updateVacancy = properties.getProperty("vacancy.update");
            deleteVacancy = properties.getProperty("vacancy.del");
            fineByActivitiesVacancy = properties.getProperty("vacancy.fineByActivities");
            fineByChartVacancy = properties.getProperty("vacancy.fineByChart");
            fineByRemoteWorkVacancy = properties.getProperty("vacancy.fineByRemoteWork");
            allRecommendations = properties.getProperty("recommendations.getAll");
            saveRecommendations = properties.getProperty("recommendations.save");
            updateRecommendations = properties.getProperty("recommendations.update");

        }catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}


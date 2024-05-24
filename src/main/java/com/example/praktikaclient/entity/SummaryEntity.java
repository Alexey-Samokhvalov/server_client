package com.example.praktikaclient.entity;

import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Section;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryEntity {

    private Long id;
    private String lns;
    private String birthday;
    private String activities;
    private String experience;
    private String education;
    private String skills;
    private String contacts;
    private String description;


    @Override
    public String toString() {
        return activities;
    }
}

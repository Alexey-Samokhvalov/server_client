package com.example.praktikaclient.service;

import com.example.praktikaclient.entity.SummaryEntity;
import com.example.praktikaclient.response.BaseResponse;
import com.example.praktikaclient.response.DataResponse;
import com.example.praktikaclient.response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.Comparator;

public class SummaryService {
    @Getter
    public ObservableList<SummaryEntity> data = FXCollections.observableArrayList();
    private final HttpService http = new HttpService();
    JsonService service = new JsonService();

    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<SummaryEntity>>() {
    }.getType();
    private Type listType = new TypeToken<ListResponse<SummaryEntity>>() {
    }.getType();

    public void getAll() {
        ListResponse<SummaryEntity> data = new ListResponse<>();
        data = service.getObject(http.get(prop.getAllSummary()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
            sort();
        }else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(SummaryEntity data) {
        String temp = http.post(prop.getSaveSummary(), service.getJson(data));

        DataResponse<SummaryEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void update(SummaryEntity after, SummaryEntity before) {
        String temp = http.put(prop.getUpdateSummary(), service.getJson(after));
        DataResponse<SummaryEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.remove(before);
            this.data.add(after);
            sort();
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(SummaryEntity data) {
        String temp = http.delete(prop.getDeleteSummary(), data.getId());
        BaseResponse response = service.getObject(temp, BaseResponse.class);
        if(response.isSuccess()) {
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
    private void sort() {
        data.sort(Comparator.comparing(SummaryEntity::getActivities));
    }
}

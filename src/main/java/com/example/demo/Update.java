package com.example.demo;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdatePaymentController extends Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField locationField;
    @FXML
    private Spinner<Integer> ageField;
    @FXML
    private Spinner<Boolean> scoreField;
    @FXML
    private Button updateButton;
    private Players player;


    public void setPerson(Players player) {
        this.player = player;
        nameField.setText((this.player.getName()));
        locationField.setText((this.player.getLocation()));
        ageField.getValueFactory().setValue((this.player.getAge()));

    }



    @FXML
    public void updateClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String location = locationField.getText().trim();
        int age = ageField.getValue();
        Boolean pontok=scoreField.getValue();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        if (location.isEmpty()) {
            warning("Location is required");
            return;
        }
        // TODO: validate email format
        this.player.setName(name);
        this.player.setEmail(location);
        this.player.setAge(age);
        this.player.setScore(scoreField);
        Gson converter = new Gson();
        String json = converter.toJson(this.player);
        try {
            String url= App.BASE_URL+ "/" +this.player.getId();
            Response response = RequestHandler.put(url, json);
            if (response.getResponseCode() == 200) {
                Stage stage =(Stage) this.updateButton.getScene().getWindow();
                stage.close();
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ch.fhnw.springfx.presentation.first;

import ch.fhnw.springfx.presentation.ViewNavigator;
import ch.fhnw.springfx.presentation.second.SecondPresenter;
import ch.fhnw.springfx.presentation.second.SecondView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
@Scope("prototype")
public class FirstPresenter {

    @Inject
    ViewNavigator navigator;

    @FXML
    TextField nameTextField;
    @FXML
    Button nextPageButton;

    @FXML
    public void initialize() {
        System.out.println("init FirstPresenter");

        nextPageButton.disableProperty().bind(nameTextField.textProperty().isEmpty());
    }

    @FXML
    private void handleNextPage() {
        String name = nameTextField.getText();

        Map<String, Object> params = new HashMap<>();
        params.put(SecondPresenter.NAME_KEY, name);

        navigator.setMainView(SecondView.class, params);
    }

}

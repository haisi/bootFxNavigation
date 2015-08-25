package ch.fhnw.springfx.presentation.first;

import ch.fhnw.springfx.presentation.ViewNavigator;
import ch.fhnw.springfx.presentation.second.SecondView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
@Configuration
public class FirstPresenter {

    @Inject
    ViewNavigator navigator;

    @Inject
    SecondView secondView;

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
        navigator.setMainView(SecondView.class);
    }

    @Bean
    public String name() {
        return nameTextField != null ? nameTextField.getText() : "";
    }

}

package ch.fhnw.springfx.presentation.second;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
public class SecondPresenter {

    @Inject
    String name;

    @FXML
    Label greetingLbl;

    @FXML
    public void initialize() {
        System.out.println("init SecondPresenter");

        greetingLbl.setText("Hallo " + name);
    }


}

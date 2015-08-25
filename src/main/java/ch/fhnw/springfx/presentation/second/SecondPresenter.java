package ch.fhnw.springfx.presentation.second;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
@Scope("prototype")
public class SecondPresenter {

    @FXML
    Label greetingLbl;

    @FXML
    public void initialize() {
        System.out.println("init SecondPresenter");

        greetingLbl.setText("Hallo "); //Here I want to get the value from the previous view!!!
    }


}

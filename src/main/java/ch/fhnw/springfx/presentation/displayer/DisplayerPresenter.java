package ch.fhnw.springfx.presentation.displayer;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
@Scope("prototype")
public class DisplayerPresenter {

    @FXML
    Label valueLbl;

    @FXML
    public void initialize() {
        System.out.println("init SliderPresenter");
    }

    public StringProperty labelValueProperty() {
        return valueLbl.textProperty();
    }
}

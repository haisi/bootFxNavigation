package ch.fhnw.springfx.presentation.slider;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
@Scope("prototype")
public class SliderPresenter {

    @FXML
    Slider slider;

    @FXML
    public void initialize() {
        System.out.println("init SliderPresenter");
    }

    public DoubleProperty sliderValueProperty() {
        return slider.valueProperty();
    }
}

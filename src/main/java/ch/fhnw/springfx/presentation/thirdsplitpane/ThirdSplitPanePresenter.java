package ch.fhnw.springfx.presentation.thirdsplitpane;

import ch.fhnw.springfx.presentation.displayer.DisplayerPresenter;
import ch.fhnw.springfx.presentation.displayer.DisplayerView;
import ch.fhnw.springfx.presentation.slider.SliderPresenter;
import ch.fhnw.springfx.presentation.slider.SliderView;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
@Scope("prototype")
public class ThirdSplitPanePresenter implements Initializable {

    @Inject
    SliderView sliderView;

    @Inject
    DisplayerView displayerView;

    @FXML
    private SplitPane splitPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DisplayerPresenter displayerPresenter = (DisplayerPresenter) displayerView.getPresenter();
        SliderPresenter sliderPresenter = (SliderPresenter) sliderView.getPresenter();

        // bind the value of the slider to the label
        displayerPresenter.labelValueProperty()
                .bind(Bindings.format("%.2f", sliderPresenter.sliderValueProperty()));

        splitPane.getItems().add(displayerView.getView());
        splitPane.getItems().add(sliderView.getView());
    }
}

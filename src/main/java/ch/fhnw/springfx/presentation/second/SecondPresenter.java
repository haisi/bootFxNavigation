package ch.fhnw.springfx.presentation.second;

import ch.fhnw.springfx.presentation.PassableParameters;
import ch.fhnw.springfx.presentation.ViewNavigator;
import ch.fhnw.springfx.presentation.thirdsplitpane.ThirdSplitPaneView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
@Scope("prototype")
public class SecondPresenter implements PassableParameters{

    static public final String NAME_KEY = "NAME_KEY";

    @Inject
    ViewNavigator navigator;

    @FXML
    Label greetingLbl;

    @FXML
    public void initialize() {
        System.out.println("init SecondPresenter");

        greetingLbl.setText("Hallo "); //Here I want to get the value from the previous view!!!
    }


    @Override
    public void setPassedParameters(Map<String, Object> parameters) {
        String name = (String) parameters.getOrDefault(NAME_KEY, "");

        greetingLbl.setText("Hallo " + name);
    }

    public void handleNextPage(ActionEvent actionEvent) {
        navigator.setMainView(ThirdSplitPaneView.class);
    }
}

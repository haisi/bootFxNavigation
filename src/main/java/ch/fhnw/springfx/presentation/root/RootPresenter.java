package ch.fhnw.springfx.presentation.root;

import ch.fhnw.springfx.presentation.ViewNavigator;
import ch.fhnw.springfx.presentation.first.FirstView;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
public class RootPresenter {

    @Inject
    FirstView firstView;

    @Inject
    ViewNavigator navigator;

    @FXML
    private BorderPane rootBorderPane;

    @FXML
    public void initialize() {
        System.out.println("init RootPresenter");

        navigator.setMainView(firstView.getView());

        rootBorderPane.centerProperty().bind(navigator.mainViewProperty());
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}

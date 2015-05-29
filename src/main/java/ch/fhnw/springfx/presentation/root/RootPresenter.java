package ch.fhnw.springfx.presentation.root;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Component;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Component
public class RootPresenter {

    @FXML
    private BorderPane rootBorderPane;

    @FXML
    public void initialize() {
        System.out.println("init RootPresenter");
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}

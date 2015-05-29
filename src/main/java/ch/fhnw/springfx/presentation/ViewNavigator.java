package ch.fhnw.springfx.presentation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Service
public class ViewNavigator {

    private final ObjectProperty<Node> mainView = new SimpleObjectProperty(this, "mainView", null);

    public ObjectProperty<Node> mainViewProperty() {
        return mainView;
    }

    public final Node getMainView() {
        return mainView.get();
    }

    public final void setMainView(Node mainView) {
        this.mainView.set(mainView);
    }
}

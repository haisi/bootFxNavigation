package ch.fhnw.springfx.presentation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Stack;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@Service
public class ViewNavigator {

    @Inject
    ApplicationContext appContext;

    private final Stack<Class<? extends AbstractFxmlView>> viewHistory = new Stack<>();

    private final ObjectProperty<Node> mainView = new SimpleObjectProperty(this, "mainView", null);

    public ObjectProperty<Node> mainViewProperty() {
        return mainView;
    }

    public final Node getMainView() {
        return mainView.get();
    }

    public final void setMainView(Class<? extends AbstractFxmlView> viewClass) {
        Parent newMainView = createNewBeanInstanceOfView(viewClass);
        this.mainView.set(newMainView);

        viewHistory.add(viewClass);
    }

    public final void stepBack() {
        if (viewHistory.size() > 1) {
            viewHistory.pop();
            this.mainView.set(createNewBeanInstanceOfView(viewHistory.peek()));

        } else {
            System.out.println("Can't go further back");
        }
    }

    private Parent createNewBeanInstanceOfView(Class<? extends AbstractFxmlView> viewClass) {
        return (appContext.getBean(viewClass)).getView();
    }
}

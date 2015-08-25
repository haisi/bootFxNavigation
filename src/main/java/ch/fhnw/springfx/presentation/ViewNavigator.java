package ch.fhnw.springfx.presentation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Map;
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

    /**
     * Loads and displays the passed viewClass.
     * Gets the instance of the bean from the Spring ApplicationContext!
     *
     * @param viewClass to be loaded and displayed.
     */
    public final void setMainView(Class<? extends AbstractFxmlView> viewClass) {
        setMainView(viewClass, null);
    }

    /**
     * Loads and displays the passed viewClass.
     * Gets the instance of the bean from the Spring ApplicationContext!
     * One can also pass parameters to the view by passing a Map of values, but then the passed
     *
     * @param viewClass to be loaded and displayed.
     * @param parameters to pass to the next presenter. Only if next presenter is instanceOf <code>PassableParameters</code>
     */
    public final void setMainView(Class<? extends AbstractFxmlView> viewClass, Map<String, Object> parameters) {
        AbstractFxmlView abstractView = createNewBeanInstanceOfView(viewClass);

        if (parameters != null && abstractView.getPresenter() instanceof PassableParameters) {
            ((PassableParameters) abstractView.getPresenter()).setPassedParameters(parameters);
        } else if (parameters != null && !parameters.isEmpty()) {
            // if the user has passed parameters for the next presenter
            // but the presenter class didn't implement the `PassableParameters`-interface
            throw new IllegalArgumentException("You passed parameters for the next presenter even though, the passed presenter hasn't implemented the `PassableParameters`-interface!");
        }

        this.mainView.set(abstractView.getView());

        viewHistory.add(viewClass);
    }

    public final void stepBack() {
        if (viewHistory.size() > 1) {
            viewHistory.pop();
            this.mainView.set(createNewBeanInstanceOfView(viewHistory.peek()).getView());

        } else {
            System.out.println("Can't go further back");
        }
    }

    private AbstractFxmlView createNewBeanInstanceOfView(Class<? extends AbstractFxmlView> viewClass) {
        return (appContext.getBean(viewClass));
    }
}

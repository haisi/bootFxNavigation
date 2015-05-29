package ch.fhnw.springfx;

import ch.fhnw.springfx.presentation.root.RootView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import javax.inject.Inject;

@Lazy
@SpringBootApplication
public class SpringFxNavigationApplication extends AbstractJavaFxApplicationSupport{

    @Inject
    RootView rootView;

    public static void main(String[] args) {
        launchApp(SpringFxNavigationApplication.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(rootView.getView()));
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}

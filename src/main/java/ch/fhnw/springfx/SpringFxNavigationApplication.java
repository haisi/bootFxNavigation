package ch.fhnw.springfx;

import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class SpringFxNavigationApplication extends AbstractJavaFxApplicationSupport{

    public static void main(String[] args) {
        launchApp(SpringFxNavigationApplication.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}

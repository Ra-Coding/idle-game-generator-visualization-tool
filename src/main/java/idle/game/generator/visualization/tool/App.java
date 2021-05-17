package idle.game.generator.visualization.tool;

import javafx.application.Application;
import javafx.stage.Stage;
 
public class App extends Application {
 
    @Override public void start(Stage stage) {
    	final UI ui = new UI();
    	
        stage.setTitle("Idle-Game Generator Visualization Tool");
        stage.setResizable(false);
        stage.setScene(ui.getScene());
        stage.show();
    }
 
    public static void main(String[] args) {
    	Application.launch(App.class);
    }
}
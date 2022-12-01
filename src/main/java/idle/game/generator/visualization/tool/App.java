package idle.game.generator.visualization.tool;

import javafx.application.Application;
import javafx.stage.Stage;
 
public class App extends Application {
 
    @Override public void start(Stage stage) {
      final GeneratorReader generatorReader = new GeneratorReader();
      final GeneratorWriter generatorWriter = new GeneratorWriter();
    	final UI ui = new UI(stage, generatorReader, generatorWriter);
    	
      stage.setTitle("Idle-Game Generator Visualization Tool");
      stage.setResizable(false);
      stage.setScene(ui.getScene());
      stage.show();
    }
 
    public static void main(String[] args) {
    	Application.launch(App.class);
    }
}
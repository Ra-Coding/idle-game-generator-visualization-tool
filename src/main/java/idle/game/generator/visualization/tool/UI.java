package idle.game.generator.visualization.tool;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class UI {

  private final MenuBar menuBar;

	private final Button buttonC;
	private final TextField inputFieldButtonC;
	
	private final LineChart<Number,Number> lineChart;
	
	private final Label labelBC;
	private final TextField inputFieldBC;
	
  private final Label labelCF;
  private final TextField inputFieldCF;
    
  private final Label labelBR;
  private final TextField inputFieldBR;
    
  private final Label labelPTIS;
  private final TextField inputFieldPTIS;
    
  private final Label labelM;
  private final TextField inputFieldM;
    
  private final GridPane gridPane;
  private final Scene scene;
    
  private final XYChart.Series<Number, Number> seriesC;
  private final XYChart.Series<Number, Number> seriesPPS;
    
  public UI() {
    this.menuBar = setupMenuBar();

    this.lineChart = setupLineChart();
    	
    this.labelBC = new Label("Base Cost:");
    this.inputFieldBC = new TextField("10");
        
    this.labelCF = new Label("Cost Factor:");
    this.inputFieldCF = new TextField("1.05");
        
    this.labelBR = new Label("Base Revenue:");
    this.inputFieldBR = new TextField("7");

    this.labelPTIS = new Label("Production Time In Seconds:");
    this.inputFieldPTIS = new TextField("2");
        
    this.labelM = new Label("Multiplier:");
    this.inputFieldM = new TextField("1");
        
    this.buttonC = setupButtonC();
    this.inputFieldButtonC = new TextField("100");
        
    this.gridPane = setupGridPane();
    BorderPane borderPane = setupBorderPane();

    this.scene = new Scene(borderPane, 800, 640);

    this.seriesC = new XYChart.Series<>();
    this.seriesC.setName("Cost");
    this.seriesPPS = new XYChart.Series<>();
    this.seriesPPS.setName("Production Per Second");
        
    this.lineChart.getData().add(seriesC);
    this.lineChart.getData().add(seriesPPS);
  }
    
  private LineChart<Number, Number> setupLineChart() {
    final NumberAxis xAxis = new NumberAxis();
    xAxis.setLabel("Owned");
    final NumberAxis yAxis = new NumberAxis();

    // yAxis formatting to scientific notation
    NumberFormat format = new DecimalFormat("#.#E0");
    yAxis.setTickLabelFormatter(new StringConverter<>() {
      @Override
      public String toString(Number number) {
        return format.format(number.doubleValue());
      }

      @Override
      public Number fromString(String string) {
        try {
          return format.parse(string);
        } catch (ParseException e) {
          e.printStackTrace();
          return 0;
        }
      }
    });
        
    final LineChart<Number,Number> lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.setTitle("Generator");
    lineChart.setAnimated(false);
    lineChart.setCreateSymbols(false);
        
    return lineChart;
  }
    
  private GridPane setupGridPane() {
    final GridPane gridPane = new GridPane();
    gridPane.setHgap(2);
    gridPane.setVgap(2);
    gridPane.setPadding(new Insets(0, 10, 0, 10));

    gridPane.add(this.labelBC, 1, 0);
    gridPane.add(this.labelCF, 2, 0);
    gridPane.add(this.labelBR, 3, 0);
    gridPane.add(this.labelPTIS, 4, 0);
    gridPane.add(this.labelM, 5, 0);
    gridPane.add(this.inputFieldBC, 1, 1);
    gridPane.add(this.inputFieldCF, 2, 1);
    gridPane.add(this.inputFieldBR, 3, 1);
    gridPane.add(this.inputFieldPTIS, 4, 1);
    gridPane.add(this.inputFieldM, 5, 1);
    gridPane.add(this.buttonC, 1, 2);
    gridPane.add(this.inputFieldButtonC, 2, 2);
        
    return gridPane;
  }
    
  private BorderPane setupBorderPane() {
    final BorderPane borderPane = new BorderPane();
    borderPane.setTop(this.menuBar);
    borderPane.setCenter(this.lineChart);
    borderPane.setPadding(new Insets(0, 10, 15, 10));
    borderPane.setBottom(this.gridPane);
        
    return borderPane;
  }
    
  private Button setupButtonC() {
    final Button buttonC = new Button("Calculate For:");
  
    buttonC.setOnAction(e -> {
      Generator generator = new Generator(Double.parseDouble(inputFieldBC.getText()),
          Double.parseDouble(inputFieldCF.getText()),
          Double.parseDouble(inputFieldBR.getText()),
          Float.parseFloat(inputFieldPTIS.getText()),
          Double.parseDouble(inputFieldM.getText()));

      seriesC.getData().clear();
      seriesPPS.getData().clear();

      int owned = Integer.parseInt(inputFieldButtonC.getText());

      for (int i = 0; i < owned; i++) {
        generator.calculateCosts();
        seriesC.getData().add(new Data<>(i, generator.getNextCost()));
        seriesPPS.getData().add(new Data<>(i, generator.productionPerSecond()));
      }
    });
    	
    return buttonC;
  }

  private MenuBar setupMenuBar() {
    MenuBar menuBar = new MenuBar();

    Menu menuAbout = new Menu("About");
    MenuItem menuItemGithub = new MenuItem("Github");

    menuItemGithub.setOnAction(e -> {
      Desktop desktop = java.awt.Desktop.getDesktop();
      try {
        URI oURL = new URI("https://github.com/Ra-Coding/idle-game-generator-visualization-tool");
        desktop.browse(oURL);
      } catch (URISyntaxException | IOException ex) {
        ex.printStackTrace();
      }
    });

    menuAbout.getItems().add(menuItemGithub);

    menuBar.getMenus().add(menuAbout);

    return menuBar;
  }

	public Scene getScene() {
		return scene;
	}

}

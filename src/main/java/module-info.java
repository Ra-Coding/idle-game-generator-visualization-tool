module Main {
  requires javafx.controls;
  requires java.desktop;
  requires com.fasterxml.jackson.databind;
  opens idle.game.generator.visualization.tool to javafx.graphics;
  exports idle.game.generator.visualization.tool;
}
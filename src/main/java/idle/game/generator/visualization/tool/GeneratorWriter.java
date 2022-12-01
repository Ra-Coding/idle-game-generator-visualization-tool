package idle.game.generator.visualization.tool;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GeneratorWriter {

  public void writeGenerator(Generator generator, String generatorName) {
    FileOutputStream fileOutputStream = null;
    try {
      fileOutputStream = new FileOutputStream(generatorName + ".txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    ObjectOutputStream objectOutputStream = null;
    try {
      objectOutputStream = new ObjectOutputStream(fileOutputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      objectOutputStream.writeObject(generator);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      objectOutputStream.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      objectOutputStream.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

package idle.game.generator.visualization.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GeneratorReader {

  public Generator readGenerator(String generatorName) {
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream(generatorName);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    ObjectInputStream objectInputStream = null;
    try {
      objectInputStream = new ObjectInputStream(fileInputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Generator generator = null;
    try {
      generator = (Generator) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    try {
      objectInputStream.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return generator;
  }
}

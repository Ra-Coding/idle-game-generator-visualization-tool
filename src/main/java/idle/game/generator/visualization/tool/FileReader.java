package idle.game.generator.visualization.tool;

import java.io.*;

public class FileReader {

  public String readFile(String fileName) {
    try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
      StringBuilder out = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        out.append(line);
      }
      reader.close();
      return out.toString();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

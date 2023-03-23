package idle.game.generator.visualization.tool;

import java.io.*;

public class FileWriter {

  public static String JSON_FILE_TYPE = "json";

  public void writeJSON(String generatorName, String fileContent) {
    writeFile(generatorName, fileContent, JSON_FILE_TYPE);
  }

  private void writeFile(String generatorName, String fileContent, String fileType) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(generatorName + "." + fileType)) {
      byte[] contentBytes = fileContent.getBytes();
      fileOutputStream.write(contentBytes);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

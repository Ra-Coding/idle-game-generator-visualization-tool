package idle.game.generator.visualization.tool;

public class GeneratorJSONReader implements GeneratorReader {

  private final FileReader fileReader;
  private final GeneratorJSONMapper generatorJSONMapper;

  public GeneratorJSONReader(FileReader fileReader, GeneratorJSONMapper generatorJSONMapper) {
    this.fileReader = fileReader;
    this.generatorJSONMapper = generatorJSONMapper;
  }

  @Override
  public Generator readGenerator(String fileName) {
    return generatorJSONMapper.parseJSONToGenerator(fileReader.readFile(fileName));
  }
}

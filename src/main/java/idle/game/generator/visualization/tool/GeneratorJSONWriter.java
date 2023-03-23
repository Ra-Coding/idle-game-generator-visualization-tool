package idle.game.generator.visualization.tool;

public class GeneratorJSONWriter implements GeneratorWriter {

  private final FileWriter fileWriter;
  private final GeneratorJSONMapper generatorJSONMapper;

  public GeneratorJSONWriter(FileWriter fileWriter, GeneratorJSONMapper generatorJSONMapper) {
    this.fileWriter = fileWriter;
    this.generatorJSONMapper = generatorJSONMapper;
  }

  @Override
  public void writeGenerator(Generator generator) {
    fileWriter.writeJSON(generator.getName(), generatorJSONMapper.parseGeneratorToJSON(generator));
  }
}

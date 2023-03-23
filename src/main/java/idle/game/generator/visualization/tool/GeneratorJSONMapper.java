package idle.game.generator.visualization.tool;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GeneratorJSONMapper {

  private final ObjectMapper objectMapper = new ObjectMapper();

  public String parseGeneratorToJSON(Generator generator) {
    try {
      return objectMapper.writeValueAsString(generator);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public Generator parseJSONToGenerator(String json) {
    try {
      return objectMapper.readValue(json, Generator.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}

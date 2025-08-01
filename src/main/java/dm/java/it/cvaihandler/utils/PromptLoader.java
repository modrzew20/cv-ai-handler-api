package dm.java.it.cvaihandler.utils;

import static org.springframework.core.io.ResourceLoader.CLASSPATH_URL_PREFIX;

import dm.java.it.cvaihandler.exception.LoadPromptException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromptLoader {

  private final ResourceLoader resourceLoader;

  public String  loadPrompt(String filename) {
    try {
      Resource resource = resourceLoader.getResource(CLASSPATH_URL_PREFIX+ "prompts/" + filename);
      try (Scanner scanner = new Scanner(resource.getInputStream(), StandardCharsets.UTF_8)) {
        return scanner.useDelimiter("\\A").next();
      }
    } catch (Exception e) {
      throw new LoadPromptException("Cannot load prompt file: " + filename, e);
    }
  }
}

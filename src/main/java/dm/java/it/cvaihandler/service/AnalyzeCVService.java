package dm.java.it.cvaihandler.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dm.java.it.cvaihandler.exception.ChatJSONResponseException;
import dm.java.it.cvaihandler.utils.PdfUtils;
import dm.java.it.cvaihandler.utils.PromptLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AnalyzeCVService {

  private final OpenAiChatModel chatClient;
  private final PromptLoader promptLoader;
  private final ObjectMapper objectMapper;

  /**
   * Analyzes a CV by extracting text from a PDF file and generating a response using a chat model.
   * @param file the PDF file containing the CV to be analyzed
   * @return a ChatResponse containing the analysis of the CV
   */
  public CvReviewDto analyzeCV(MultipartFile file) {
    String extractedText = PdfUtils.extractTextFromPdf(file);
    String prompt = promptLoader.loadPrompt("cv_analysis_prompt.txt").formatted(extractedText);
    ChatResponse call = chatClient.call(new Prompt(prompt));
    try {
      return objectMapper.readValue(call.getResult().getOutput().getText(), CvReviewDto.class);
    } catch (JsonProcessingException e) {
      throw new ChatJSONResponseException(
          "Error processing chat response JSON: " + e.getMessage(), e);
    }
  }

}


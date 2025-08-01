package dm.java.it.cvaihandler.api;

import dm.java.it.cvaihandler.service.AnalyzeCVService;
import dm.java.it.cvaihandler.service.CvReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cv")
@RequiredArgsConstructor
public class AnalyzeCVController {

  private final AnalyzeCVService analyzeCVService;

  @PostMapping("/analyze")
  public ResponseEntity<CvReviewDto> analyzeCV(@RequestParam("file") MultipartFile file) {
    // Logic to handle the uploaded CV file
    return ResponseEntity.ok(analyzeCVService.analyzeCV(file));
  }

}

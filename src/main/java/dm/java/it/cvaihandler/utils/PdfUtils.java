package dm.java.it.cvaihandler.utils;

import dm.java.it.cvaihandler.exception.PDFProcessingException;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdfUtils {

  public static String extractTextFromPdf(MultipartFile file) {
    try (PDDocument document = Loader.loadPDF(file.getInputStream().readAllBytes())) {
      return new PDFTextStripper().getText(document);
    } catch (IOException e) {
      throw new PDFProcessingException("Error extracting text from PDF file", e);
    }
  }
}

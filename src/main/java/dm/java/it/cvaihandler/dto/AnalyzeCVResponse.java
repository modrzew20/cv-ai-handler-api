package dm.java.it.cvaihandler.dto;

import java.util.List;

public record AnalyzeCVResponse(
    String experienceLevel,
    List<String> skills,
    List<String> strengths,
    List<String> weaknesses,
    List<String> improvements

) {

}

package dm.java.it.cvaihandler.service;

import java.util.List;

public record CvReviewDto(
    List<StepDto> steps,
    String final_answer
) {

}


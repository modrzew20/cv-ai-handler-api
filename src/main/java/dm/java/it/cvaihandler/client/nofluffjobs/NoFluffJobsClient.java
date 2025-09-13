package dm.java.it.cvaihandler.client.nofluffjobs;

import dm.java.it.cvaihandler.client.nofluffjobs.dto.JobDTO;
import dm.java.it.cvaihandler.client.nofluffjobs.dto.JobSearchDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "noFluffJobsClient", name = "noFluffJobs", url = "${clients.nofluffjobs.base-url}")
public interface NoFluffJobsClient {

    @PostMapping(value = "/api/search/posting")
    List<JobDTO> getJobs(
            @RequestParam(value = "pageFrom") int pageFrom,
            @RequestParam(value = "withSalaryMatch") boolean withSalaryMatch,
            @RequestParam(value = "pageTo") int pageTo,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "salaryCurrency") String salaryCurrency,
            @RequestParam(value = "salaryPeriod") String salaryPeriod,
            @RequestParam(value = "region") String region,
            @RequestParam(value = "language") String language,
            @RequestBody JobSearchDTO searchCriteria
    );

    default List<JobDTO> getJobsWithDefaults() {
        return getJobs(
                1,           // pageFrom
                true,        // withSalaryMatch
                1,           // pageTo
                20,          // pageSize
                "PLN",       // salaryCurrency
                "month",     // salaryPeriod
                "pl",        // region
                "pl-PL",     // language
                JobSearchDTO.defaults()
        );
    }


}
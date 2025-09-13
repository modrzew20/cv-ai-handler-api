package dm.java.it.cvaihandler.client.nofluffjobs.dto;

public record JobSearchDTO(
        String rawSearch,
        int pageSize,
        boolean withSalaryMatch
) {
    public JobSearchDTO {
        if (rawSearch == null || rawSearch.isBlank()) {
            rawSearch = "requirement=Java";
        }
        if (pageSize <= 0) {
            pageSize = 20;
        }
    }

    public JobSearchDTO() {
        this("requirement=Java", 20, true);
    }

    public static JobSearchDTO defaults() {
        return new JobSearchDTO("requirement=Java", 20, true);
    }

}

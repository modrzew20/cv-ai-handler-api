package dm.java.it.cvaihandler.client.nofluffjobs.dto;

import java.util.List;

public record JobDTO(
        String id,
        String name,
        LocationDTO location,
        String reference,
        boolean searchBoost,
        boolean onlineInterviewAvailable,
        TileDTO tiles,
        String title,
        String technology,
        String logo,
        String category,
        List<String> seniority,
        String url,
        List<String> regions,
        boolean fullyRemote,
        SalaryDTO salary
) {
}


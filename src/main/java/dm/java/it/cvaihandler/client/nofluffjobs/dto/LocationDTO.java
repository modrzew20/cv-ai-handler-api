package dm.java.it.cvaihandler.client.nofluffjobs.dto;

import java.util.List;

public record LocationDTO(
        List<PlaceDTO> places,
        boolean fullyRemote,
        boolean covidTimeRemotely,
        String hybridDesc
) {
}

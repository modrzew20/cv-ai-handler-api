package dm.java.it.cvaihandler.client.nofluffjobs.dto;

public record PlaceDTO(
        CountryDTO country,
        String city,
        String street,
        String postalCode,
        String url
) {
}

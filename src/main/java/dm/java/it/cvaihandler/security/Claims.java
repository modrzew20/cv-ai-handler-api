package dm.java.it.cvaihandler.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Claims {
    EMAIL ("email"),
    NAME ("name"),
    PICTURE ("picture");

    private final String value;
}

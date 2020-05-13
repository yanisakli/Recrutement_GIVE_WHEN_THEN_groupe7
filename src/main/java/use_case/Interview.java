package main.java.use_case;

import java.util.UUID;

public class Interview {
    private final UUID candidatUuid;
    private final String name;

    public Interview(UUID candidatUuid, String name) {
        this.candidatUuid = candidatUuid;
        this.name = name;
    }
}

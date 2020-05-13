package main.java.use_case;

import java.util.UUID;

public class Candidat {
    private final UUID candidatUuid;
    private final String name;

    public Candidat(UUID candidatUuid, String name) {
        this.candidatUuid = candidatUuid;
        this.name = name;
    }

}

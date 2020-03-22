package de.hsos.prog3.dokranke.ab1.orchester;

import java.util.Objects;

public abstract class Mitglied {

    private String name;

    public Mitglied(String name) {
        Objects.requireNonNull(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Domenik Kranke <domenik@kranke.de>
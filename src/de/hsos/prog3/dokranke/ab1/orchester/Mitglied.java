package de.hsos.prog3.dokranke.ab1.orchester;

public abstract class Mitglied {

    private String name;

    public Mitglied(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package de.hsos.prog3.dokranke.ab01.aufgabe1;

import java.util.Objects;

public class Nachbar {

    private String vorname;
    private String nachname;

    public Nachbar(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    @Override
    public String toString() {
        return vorname + " " + nachname;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            Nachbar nachbar = (Nachbar) o;
            return Objects.equals(vorname, nachbar.vorname) &&
                    Objects.equals(nachname, nachbar.nachname);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(vorname, nachname);
    }
}

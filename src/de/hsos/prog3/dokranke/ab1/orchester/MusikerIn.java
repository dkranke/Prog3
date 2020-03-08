package de.hsos.prog3.dokranke.ab1.orchester;

import java.util.Objects;

public class MusikerIn extends Mitglied {

    private Instrument instrument;

    public MusikerIn(String name, Instrument instrument) {
        super(name);
        this.instrument = instrument;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            MusikerIn musikerIn = (MusikerIn) o;
            return getName().equals(musikerIn.getName()) && instrument == musikerIn.instrument;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), instrument);
    }
}

package bm.app.springplayfield.models;

public class Troll {

    private Spear pike;

    public Spear getPike() {
        return pike;
    }

    public void setPike(Spear pike) {
        this.pike = pike;
    }

    public void armUp() {
        pike.arm();
    }
}

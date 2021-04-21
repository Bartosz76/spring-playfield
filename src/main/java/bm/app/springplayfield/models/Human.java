package bm.app.springplayfield.models;

public class Human {

    private Armour armour;

    public Human() {
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public void prepareForBattle() {
        armour.donTheArmour();
    }
}

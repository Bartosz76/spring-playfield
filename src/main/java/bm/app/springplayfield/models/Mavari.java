package bm.app.springplayfield.models;

public class Mavari {

    private int height;
    private Armour armour;

    public Mavari(int height, Armour armour) {
        this.height = height;
        this.armour = armour;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }
}

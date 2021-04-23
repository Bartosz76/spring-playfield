package bm.app.springplayfield.models;

public class Troll {

    private int age;
    private Spear weapon;

    public Spear getWeapon() {
        return weapon;
    }

    public void setWeapon(Spear weapon) {
        this.weapon = weapon;
    }

    public void armUp() {
        weapon.arm();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package bm.app.springplayfield.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dwarf {

    @Autowired
    Weapon weapon;

    public void attackTheEnemy() {
        weapon.hitTheFoe();
    }

}

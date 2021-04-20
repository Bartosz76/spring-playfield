package bm.app.springplayfield.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Elf {

    public void attackTheFoe() {
        System.out.println("Attack the dwarf!");
    }
}

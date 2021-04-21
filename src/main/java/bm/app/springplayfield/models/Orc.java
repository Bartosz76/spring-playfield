package bm.app.springplayfield.models;

import org.springframework.stereotype.Component;

@Component
public class Orc {

    public Orc() {
        System.out.println("I, an orc, was summoned by dark warlocks of Spring without ever being called manually by the user!" +
                "... and that is because I am of singleton scope.");
    }
}

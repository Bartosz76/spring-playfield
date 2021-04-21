package bm.app.springplayfield.models;

import org.springframework.stereotype.Component;

@Component
public class Gnome {

    private int age = 246;

    public Gnome() {
        System.out.println("I, a gnome, am not called automatically, because I am of prototype scope and " +
                "Spring Container will not summon me by itself.");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

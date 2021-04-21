package bm.app.springplayfield.models;

public class Ogre {

    private int age;

    public Ogre() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("---------------------");
        System.out.println("I am an ogre and this is my setter being called to prove that Spring Container " +
                "uses it when property is set for a bean in spring.xml file.");
        System.out.println("---------------------");
        this.age = age;
    }
}

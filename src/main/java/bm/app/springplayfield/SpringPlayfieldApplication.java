package bm.app.springplayfield;

import bm.app.springplayfield.models.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SpringBootApplication
public class SpringPlayfieldApplication {

    public static void main(String[] args) {
        /**
         * Automatically creates a Spring Container for me (ApplicationContext)?
         */
        ApplicationContext context = SpringApplication.run(SpringPlayfieldApplication.class, args);

        Dwarf dwarf = context.getBean(Dwarf.class);
        dwarf.attackTheEnemy();
        printTheDivider();

       /**
        * Instead of ApplicationContext - an archaic solution with BeanFactory (requires spring.xml file within the
        * root directory, not the resources one.
        *
        *         BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        *
        *         Elf elf = (Elf) factory.getBean("elf");
        *         elf.attackTheFoe();
        */

        /**
         * Spring Container solution with spring.xml file to configure the scope of beans.
         */
        ApplicationContext contextNew = new ClassPathXmlApplicationContext("spring.xml");
        Elf elf = (Elf) contextNew.getBean("elf");
        elf.setAge(678);
        System.out.println("I am an elf and my age is " + elf.getAge());
        printTheDivider();

        /**
         * Age variable is different than the default one because a previous object of Elf bean changed it and Elf is a singleton by default.
         */
        Elf anotherElf = (Elf) contextNew.getBean("elf");
        System.out.println("I am an elf and my age is " + anotherElf.getAge());
        printTheDivider();

        /**
         * An orc bean never being called by me.
         */

        /**
         * A gnome being of prototype scope.
         */
        Gnome gnome = (Gnome) contextNew.getBean("gnome");
        gnome.setAge(341);
        System.out.println(gnome.getAge());
        printTheDivider();

        /**
         * This bean's variable is the default one because the previous one changed it only for itself. Prototype scope allows for multiple objects.
         */
        Gnome anotherGnome = (Gnome) contextNew.getBean("gnome");
        System.out.println(anotherGnome.getAge());
        printTheDivider();

        /**
         * Ogre's default variable is set in spring.xml. By setting a default property there, I am making Spring Container call the setter.
         */

        Ogre ogre = (Ogre) contextNew.getBean("ogre");
        System.out.println("I am an ogre and my default age was set as a bean property in spring.xml file. It is: " + ogre.getAge());
        printTheDivider();

        /**
         * Human bean has Armour bean set as its property in the spring.xml. Due to being a reference type and not a primitive type,
         * it's a ref instead of a value.
         */

        Human human = (Human) contextNew.getBean("human");
        System.out.println("I am a human and bean armour is set as a property for me in the spring.xml file.");
        human.prepareForBattle();
        printTheDivider();

        /**
         * Mavari's fields are set by constructor injection within spring.xml file. If I want to inject a value/ref like that,
         * I need to have a constructor within the bean take in those values/refs as arguments.
         * Setter injection can be used for optional variables and constructor injection for required ones.
         */

        Mavari mavari = (Mavari) contextNew.getBean("mavari");
        System.out.println("I am a mavari and my fields are set by constructor injection in the spring.xml file.");
        System.out.println("My height is " + mavari.getHeight());
        printTheDivider();

        /**
         * Troll bean has autowire set in spring.xml file to look 'byName'. Changing the name of the
         * field in troll bean points spring which concrete implementation of interface Spear I want
         * to use (be it a pike or a javelin). I also do not need to set spear as a property of the
         * bean.
         * I can set autowire to look 'byType' instead and then it won't look for the name, but the
         * type.
         * When I had both pike and javelin set as beans and told troll bean to autowire by type...
         * it didn't want to do it, because the type of the variable in troll bean is the interface
         * both classes share and Spring could not determine which implementation I looked for.
         */

        Troll troll = (Troll) contextNew.getBean("troll");
        troll.armUp();
        printTheDivider();
    }

    private static void printTheDivider() {
        System.out.println("-------------------------------");
    }
}

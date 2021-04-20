package bm.app.springplayfield;

import bm.app.springplayfield.models.Dwarf;
import bm.app.springplayfield.models.Elf;
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

       /**
        * Instead of ApplicationContext - an archaic solution with BeanFactory (requires spring.xml file within the
        * root directory, not the resources one.
        *
        *         BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        *
        *         Elf elf = (Elf) factory.getBean("elf");
        *         elf.attackTheFoe();
        */

        ApplicationContext contextNew = new ClassPathXmlApplicationContext("spring.xml");
        Elf elf = (Elf) contextNew.getBean("elf");
        elf.attackTheFoe();


    }
}

package bm.app.springplayfield;

import bm.app.springplayfield.models.Dwarf;
import bm.app.springplayfield.models.Elf;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SpringBootApplication
public class SpringPlayfieldApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringPlayfieldApplication.class, args);

        Dwarf dwarf = context.getBean(Dwarf.class);
        dwarf.attackTheEnemy();

        // Instead of ApplicationContext
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));

        Elf elf = (Elf) factory.getBean("elf");
        elf.attackTheFoe();

    }
}

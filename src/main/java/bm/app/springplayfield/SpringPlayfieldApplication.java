package bm.app.springplayfield;

import bm.app.springplayfield.models.Dwarf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPlayfieldApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringPlayfieldApplication.class, args);

        Dwarf dwarf = context.getBean(Dwarf.class);
        dwarf.attackTheEnemy();

    }
}

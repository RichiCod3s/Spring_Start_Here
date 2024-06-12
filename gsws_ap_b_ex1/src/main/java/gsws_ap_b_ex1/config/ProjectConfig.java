package gsws_ap_b_ex1.config;

import gsws_ap_b_ex1.main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//Using @ComponentScan annotation over the configuration class, instruct Spring on where to find the classes you marked @Component.
@ComponentScan(basePackages = "main") // this is another way instead of creating the Beans below. It will scan the Parrot Class
public class ProjectConfig {

    @Bean
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    //We can name our Beans
    @Bean(name = "miki")
    // A primary bean is the one Spring will choose if it has multiple options and you don’t specify a name;
    // the primary bean is simply Spring’s default choice.
    @Primary
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }

    @Bean
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }


}//class

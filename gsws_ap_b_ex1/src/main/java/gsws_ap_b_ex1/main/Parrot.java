package gsws_ap_b_ex1.main;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//Using the @Component annotation, mark the classes for which you want Spring to add an instance to its context
@Component
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // @PostConstruct sends instructs Spring to call that method after the constructor finishes its execution.
    // need to add dependency in maven
    //@PostConstruct
    //public void init() {
   //     this.name = "Kiki";
   // }
// Omitted getters and setters
}
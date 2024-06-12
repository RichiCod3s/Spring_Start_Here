package gsws_ap_b_ex1.main;

import gsws_ap_b_ex1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

         /*
         1: You don’t need to do any explicit casting. Spring looks for a bean of the type you requested in its context.
         If such a bean doesn’t exist, Spring will throw an exception. Ony works if one Object Type
        String s = context.getBean(String.class);
        System.out.println(s);
         */

        //2: we can get the object by calling the method name - no need to specify the class
        Parrot p = context.getBean("parrot1",Parrot.class);
        System.out.println(p.getName());

        //2: We can get the object by calling the Bean we have a name to. Also no need to assign variable to object
        System.out.println(context.getBean("miki",Parrot.class).getName());

        //3. Miki is also the Primary bean so we can us Miki by just referring to the class
        System.out.println(context.getBean(Parrot.class).getName());

        // we can call this type from the parrot class as we used @component and @component scan
        // we also use @PostConstruct for the name which instructs Spring to call that method after the constructor finishes its execution.
       // Parrot stereoType = context.getBean(Parrot.class);
       // System.out.println(stereoType.getName());

    }
}
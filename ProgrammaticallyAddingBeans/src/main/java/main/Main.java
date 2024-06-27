package main;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);


        // 1. We create the instance we want to add to the Spring context.
        Parrot x = new Parrot();
        x.setName("Kiki");

        //2.We define a Supplier to return this instance.
        Supplier<Parrot> parrotSupplier = () -> x;

        //context.registerBean("parrot1", Parrot.class, parrotSupplier);

        //3. We call the registerBean() method to add the instance to the Spring context.

        context.registerBean("parrot1", //first parameter beanName to define a name for the bean you add in the Spring context.
                Parrot.class, // second parameter is the class that defines the bean you add to the context.
                parrotSupplier, // third parameter is an instance of Supplier. The implementation of this Supplier needs to return the value of the instance you add to the context.
                bc -> bc.setPrimary(true)); //fourth and last parameter is a varargs of BeanDefinitionCustomizer.
        //the BeanDefinitionCustomizer is just an interface you implement to configure different characteristics of the bean; e.g., making it primary.)


        //4. To verify the bean is now in the context, we refer to the parrot bean and print its name in the console.
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

    }
}

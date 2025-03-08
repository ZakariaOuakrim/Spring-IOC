package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ext","metier","dao");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Resultat = " + metier.calcul());
    }
}

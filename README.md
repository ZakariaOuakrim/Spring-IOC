<h1 align="center">
  <a href="https://github.com/ZakariaOuakrim/Spring-IOC">
    <img src="https://raw.githubusercontent.com/ZakariaOuakrim/Spring-IOC/master/src/main/resources/images/1.png" >
  </a>
</h1>
<p align="center">
&nbsp <a target="_blank" href="https://www.linkedin.com/in/zakariaouakz/"><img height="20" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" /></a>
<a href="https://mail.google.com/mail/?view=cm&to=ouakrimzakaria18@gmail.com" target="_blank" onclick="window.open(this.href,'_blank'); return false;">
  <img height="20" src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" />
</a>

</p>
<p align="center">
  This repository contains the <strong>Dependency Injection</strong> source code.
   It teaches dependency injection in Spring Boot using config.xml file and Annotations.
</p>

<p align="center">
<a href="#introduction">Introduction</a> &nbsp;&bull;&nbsp;
<a href="#installation">Installation</a> &nbsp;&bull;&nbsp;
<a href="#Injection-config-xml">Injection-config-xml</a> &nbsp;&bull;&nbsp;
<a href="#Injection-Annotation">Injection-Annotation</a> &nbsp;&bull;&nbsp;
<a href="#issue">Issue?</a>
</p>

# Introduction
This <b>Dependency Injection</b> teaches dependency injection in Spring boot. You can:

- Implements dependency injection in Spring.
- Demonstrates dependency injection using a config.xml file
- Demonstrates dependency injection using Annotations

## Installation
##### Copy the repository to your local machine
```
git clone https://github.com/ZakariaOuakrim/Spring-IOC
```
##### Understand the code 
- The code contains two packages <b>dao</b> and <b>metier</b> which are the implementation of the <b>IDao</b> and <b>IMetier</b> interfaces.
- The ext package contains another implementation of the <b>IDao</b> interface.
- The pres package contains the main class which demonstrates the dependency injection using a config.xml file and Annotations.

<img src="https://raw.githubusercontent.com/ZakariaOuakrim/Spring-IOC/master/src/main/resources/images/2.png" />

## Injection-config-xml
Using a config.xml file to inject the dependencies, it creates the beans and injects them into the classes.
In this case, the <b>DaoImpl</b> class is injected into the <b>MetierImpl</b> class using the constructor, but we can inject it using the setter as well.

<img src="https://raw.githubusercontent.com/ZakariaOuakrim/Spring-IOC/master/src/main/resources/images/3.png" />


## Injection-Annotation

This part demonstrates the dependency injection using Annotations.
- Here we used the <b>@Component</b> annotation to create the beans and inject them into the classes.
```
import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImplV2 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version Webservice");
        double t=77;
        return t;
    }
}
```
- We can use specific annotations to inject beans related to data access, service, or controller.

```
@Repository("dao")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Base de donnée");
        double temp=25;
        return temp;
    }
}
```
- The <b>@Autowired</b> annotation is used to inject the beans into the classes, but it is not recommended to use it.
- The <b>@Qualifier</b> annotation is used to specify the bean to be injected into the class, if we have multiple beans of the same type.
```
@Service("metier")// Pour déclarer un bean
public class MetierImpl implements IMetier {

   // @Autowired // Injection de dépendance
    private IDao idao;

    public MetierImpl(@Qualifier("dao2") IDao dao ) {
        this.idao = dao;
    }


    @Override
    public double calcul() {
        double data = idao.getData();
        double res=data*2;
        return res;
    }

    public void setDao(IDao idao) {
        this.idao = idao;
    }
}
```


## Issue
This repository is maintained actively, so if you face any issue please <a href="https://github.com/ZakariaOuakrim/Spring-IOC/issues/new">raise an issue</a>.

<h4>Liked the work ?</h4>
Give the repository a star :-)
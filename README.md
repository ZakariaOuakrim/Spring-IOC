<h1 align="center">
  <a href="https://github.com/ZakariaOuakrim/Spring-IOC">
    <img src="https://raw.githubusercontent.com/ZakariaOuakrim/Spring-IOC/master/src/main/resources/images/1.png" >
  </a>
</h1>
<p align="center">
&nbsp <a target="_blank" href="https://www.linkedin.com/in/zakariaouakz/"><img height="20" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" /></a>
</p>
<p align="center">
  This repository contains the <strong>Dependency Injection</strong> source code.
   It teaches dependency injection in Spring Boot using config.xml file and Annotations.
</p>

<p align="center">
<a href="#introduction">Introduction</a> &nbsp;&bull;&nbsp;
<a href="#installation">Installation</a> &nbsp;&bull;&nbsp;
<a href="#Injection-config.xml">Injection-config.xml</a> &nbsp;&bull;&nbsp;
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

<img src="https://raw.githubusercontent.com/ZakariaOuakrim/Spring-IOC/master/src/main/resources/images/2.png" >

## Injection-config.xml
Using the static approach with either a getter or constructor:<br/>
```
public static void main(String[] args) {  
    DaoImpl d = new DaoImpl();  
    MetierImpl metier = new MetierImpl(d);  
    //metier.setDao(d); //injection via le setter  
    System.out.println("Resultat "+ metier.calcul());  
}
```


## Dynamic-Approach

Reading from a config file then loading and building the classes with their properties/methods
### 1. Config file
```
dao.DaoImpl  
metier.MetierImpl
```
This approach also provides two options either with a constructor or a setter, the choice between <b>DaoImpl</b> or <b>DaoImpv2</b> depends on the config file
```
public static void main(String[] args) {  
    try {  
        Scanner scanner = new Scanner(new File("config.txt"));  
        String daoClassName = scanner.nextLine();  
        System.out.println("Class: " + daoClassName);  
  
        //DaoImpl d = new DaoImpl();  
        Class cDao=Class.forName(daoClassName);  
        IDao dao = (IDao) cDao.getConstructor().newInstance();  
        System.out.println("Dao: " + dao.getData());  
  
        //MetierImpl metier = new MetierImpl(d);  
        String metierClassName = scanner.nextLine();  
        System.out.println("Metier: " + metierClassName);  
        Class cMetier=Class.forName(metierClassName);  
        //using constructor  
        //IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);  
        //using setter        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();  
  
        //metier.setDao(d);  
        Method setDao=cMetier.getDeclaredMethod("setDao", IDao.class);  
        setDao.invoke(metier,dao);  
  
        System.out.println("Resultat "+metier.calcul());  
  
    } catch (Exception e) {  
        System.out.println(e.getMessage());  
    }  
}
```

## Issue
This repository is maintained actively, so if you face any issue please <a href="https://github.com/ZakariaOuakrim/Dependency-Injection-Spring/issues/new">raise an issue</a>.

<h4>Liked the work ?</h4>
Give the repository a star :-)
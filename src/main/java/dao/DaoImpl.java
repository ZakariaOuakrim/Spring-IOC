package dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Base de donnée");
        double temp=25;
        return temp;
    }
}

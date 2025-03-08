package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")// Pour déclarer un bean
public class MetierImpl implements IMetier {
    @Autowired // Injection de dépendance
    private IDao idao;
    public MetierImpl(IDao dao ) {
        this.idao = dao;
    }

    public MetierImpl() {
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

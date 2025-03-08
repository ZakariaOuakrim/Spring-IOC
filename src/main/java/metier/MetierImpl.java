package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

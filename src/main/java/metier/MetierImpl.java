package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
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

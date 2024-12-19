package Repository.DAO;

import Model.Cheque;

import java.util.List;
import java.util.Map;

public interface ChequeDAO {
    boolean addCheque(Cheque cheque);
    List<Map<String,Object>> getInformacionCheques() ;
}

package olivecrypto.upi.batch.dao3;

import java.sql.SQLException;

import olivecrypto.upi.batch.domain3.IdbDB;


public interface IdbDAO {
    public void insert(IdbDB idbDb) throws SQLException;
}

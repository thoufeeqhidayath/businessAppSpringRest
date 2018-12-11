package businessapp.business;

import java.sql.SQLException;

public interface appRepository {

	public void insertIntoProduct(String productName) throws SQLException;
	
	public void deleteFromProduct(int productId) throws SQLException;
	
    public void insertIntoCustomer(String customerName) throws SQLException;
	 
    public void deleteFromCustomer(int customerCode) throws SQLException;
	
    public void insertIntoSupplier(String supplierName) throws SQLException;
    
    public void deleteFromSupplier(int supplierCode) throws SQLException;
    
    public void insertIntoBank(String bankName) throws SQLException;
    
    public void deleteFromBank(int bankCode) throws SQLException;
    
	
}

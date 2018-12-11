package businessapp.business;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService {
	
	@Autowired
	private appDBrepository appDBrepository;
	
	
	public String addProduct(String productName) throws SQLException
	{
		appDBrepository.insertIntoProduct(productName);
		return "product added";
		
	}
	
	
	public String deleteProduct(int productCode) throws SQLException
	{
		
		String returnValue="deleted";
		if(!(appDBrepository.checkValueExists("product","product_code",productCode)).equals("exist"))
		{
		returnValue="Product not exists";
		}
		else
		{
			appDBrepository.deleteFromProduct(productCode);
		}
		return returnValue;

	}
	
	public String updateProduct(int productCode,String productName) throws SQLException
	{	
		String returnValue="updated";
		if(!(appDBrepository.checkValueExists("product","product_code",productCode)).equals("exist"))
		{
		returnValue="Product not exists";
		}
		else
		{
			appDBrepository.updateProduct(productCode, productName);
		}
		return returnValue;
	}
	
	
	public String addCustomer(String customerName) throws SQLException
	{
		appDBrepository.insertIntoCustomer(customerName);
		return "Customer added";
		
	}
	
	
	public String deleteCustomer(int customerCode) throws SQLException
	{
		
		String returnValue="deleted";	
		if(!(appDBrepository.checkValueExists("customer","customer_code",customerCode)).equals("exist"))
		{
			returnValue="Customer not exists";
		}
		
		else
		
		{
			appDBrepository.deleteFromCustomer(customerCode);
		}
		return returnValue;	
		
	}
	
	public String updateCustomer(int customerCode,String customerName) throws SQLException
	{
		String returnValue="deleted";
		
		if(!(appDBrepository.checkValueExists("customer","customer_code",customerCode)).equals("exist"))
		{
		returnValue="Customer not exists";
		}
		else
		{
		appDBrepository.updateCustomer(customerCode, customerName);
		}
		
		return returnValue;	
	}
	
	public String addSupplier(String supplierName) throws SQLException
	{
		appDBrepository.insertIntoSupplier(supplierName);
		return "Supplier added";
	}
	
	
	public String deleteSupplier(int supplierCode) throws SQLException
	{
		String returnValue="deleted";
		if(!(appDBrepository.checkValueExists("supplier","supplier_code",supplierCode)).equals("exist"))
		{
		returnValue="Supplier not exists";
		}
		else
		{
		appDBrepository.deleteFromSupplier(supplierCode);
		}
		
		return returnValue;			
	}
	
	public String updateSupplier(int supplierCode,String supplierName) throws SQLException
	
	{
		String returnValue="Updated";
		if(!(appDBrepository.checkValueExists("supplier","supplier_code",supplierCode)).equals("exist"))
		{
		returnValue="Supplier not exists";
		}
		else
		{
		appDBrepository.updateSupplier(supplierCode, supplierName);
		}
		
		return returnValue;		
		
	}
	
	
	
	
	public String addBank(String bankName) throws SQLException
	{	
		    String returnValue="ADDED";
			appDBrepository.insertIntoBank(bankName);	
			return returnValue;
		
	}
	
	

	
	
	public String deleteBank(int bankCode) throws SQLException
	{
		String returnValue="deleted";
		if(!(appDBrepository.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
	
		{
		returnValue="bank not exists";
		}
	
		else
		{
		appDBrepository.deleteFromBank(bankCode);
		}
		return returnValue;	
	}

	
	public String updateBank(int bankCode,String bankName) throws SQLException
	{
		String returnValue="Updated";
		if(!(appDBrepository.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
	
		{
		returnValue="bank not exists";
		}
	
		else
		{
		appDBrepository.updateBank(bankCode, bankName);
		}
		return returnValue;	
	}

	
	
	
	public String addStock(int productCode,int itemCode,double buyingPrice,double sellingPrice,double quantity) throws SQLException
	{
		
		String returnValue="NOT ADDED";
		
		if(!(appDBrepository.checkValueExists("product","product_code",productCode)).equals("exist"))
		{
			returnValue="Product Id not exists";
		}
		
		else if(!(appDBrepository.checkValueExists("stock","item_code",itemCode)).equals("exist"))
		{
			appDBrepository.insertIntoStock(productCode, itemCode, buyingPrice, sellingPrice, quantity);
			returnValue="added";
		}
		else
		{
			appDBrepository.updateStock(productCode, itemCode, buyingPrice, sellingPrice, quantity);
			returnValue="added";
		}
		return returnValue;
	}
	
	
	public String deleteStock(int productCode) throws SQLException
	{
		String returnValue="NOT DELETED";
	
		if(!(appDBrepository.checkValueExists("stock","product_code",productCode)).equals("exist"))
	
		{
		returnValue="Product Id not exists";
		}
		else
		{
		appDBrepository.deleteFromStock(productCode);
		returnValue="deleted";
		}	
		return returnValue;
	}
	
	public String updateStock(int productCode,int itemCode,double buyingPrice,double sellingPrice,double quantity) throws SQLException
	{
		String returnValue="Not Updated";
		if(!(appDBrepository.checkValueExists("stock","product_code",productCode)).equals("exist"))
		{
		returnValue="Product Id not exists";
		}
		else
		{
		appDBrepository.updateStock(productCode, itemCode, buyingPrice, sellingPrice, quantity);
		returnValue="updated";
		}	
		return returnValue;	
    }
}

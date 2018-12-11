package businessapp.business;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class viewService {
	
	@Autowired
	private appDBrepository appDBrepository;
	
	
	public ArrayList<viewModel> viewProducts() throws ClassNotFoundException, SQLException, IOException
	{
		
		return appDBrepository.readFromProduct();	
	}

	
	public ArrayList<viewModel> viewCustomers() throws ClassNotFoundException, SQLException, IOException
	{	
	     return appDBrepository.readFromCustomer();
	}
	
	public ArrayList<viewModel> viewSuppliers() throws ClassNotFoundException, SQLException, IOException
	{
		return appDBrepository.readFromSupplier();
	}
	
	public ArrayList<viewModel> viewBank() throws ClassNotFoundException, SQLException, IOException
	{
		return appDBrepository.readFromBank();
	}
	
	public ArrayList<viewModel> viewPurchaseInvoices() throws ClassNotFoundException, SQLException, IOException
	{
		return appDBrepository.readFromPurchaseInvoice();
	}
	
	
	
	public ArrayList<viewModel> viewSalesInvoices() throws ClassNotFoundException, SQLException, IOException
	{
		return appDBrepository.readFromSalesInvoice();
	}
	
	
	public ArrayList<viewModel> viewPayment() throws ClassNotFoundException, SQLException, IOException
	{
		return appDBrepository.readFromPayment();
	}
	
	
	public ArrayList<viewModel> viewReceipt() throws ClassNotFoundException, SQLException, IOException
	{
		return  appDBrepository.readFromReceipt();
	}

	
	public  ArrayList<viewModel> viewPurchaseList() throws ClassNotFoundException, SQLException, IOException
	{
		return appDBrepository.readFromPurchaseList();
	}
	
	
	public ArrayList<viewModel> viewSalesList() throws ClassNotFoundException, SQLException, IOException
	{
		return appDBrepository.readFromSalesList();
	}
	public  ArrayList<viewModel> viewStock() throws ClassNotFoundException, SQLException, IOException
	{
		return appDBrepository.readFromStock();
	}
}

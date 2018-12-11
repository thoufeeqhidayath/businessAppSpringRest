/*package businessapp.business;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class viewController {
	
	
	@Autowired
	private viewService viewService;
	
	@RequestMapping(value= "/viewProducts" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewProducts() throws ClassNotFoundException, SQLException, IOException
	{ 	
		return viewService.viewProducts();
	}

	@RequestMapping(value= "/viewCustomers" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewCustomers() throws ClassNotFoundException, SQLException, IOException
	{	
		return viewService.viewCustomers();
	}
	
	
	@RequestMapping(value= "/viewSuppliers" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewSuppliers() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewSuppliers();
	}
	
	@RequestMapping(value= "/viewBank" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewBank() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewBank();
	}

	@RequestMapping(value= "/viewPurchaseInvoices" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewPurchaseInvoices() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewPurchaseInvoices();
	}
	
	
	@RequestMapping(value= "/viewSalesInvoices" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewSalesInvoices() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewSalesInvoices();
	}
	
	@RequestMapping(value= "/viewpayments" ,method = RequestMethod.GET)
	public  ArrayList<viewModel> viewPayment() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewPayment();
	}
	
	@RequestMapping(value= "/viewReceipt" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewReceipt() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewReceipt();
	}
	              
	@RequestMapping(value= "/viewPurchaseList" ,method = RequestMethod.GET)
	public  ArrayList<viewModel> viewPurchaseList() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewPurchaseList();
	}
	
	@RequestMapping(value= "/viewSalesList" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewSalesList() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewSalesList();
	}
	@RequestMapping(value= "/viewStock" ,method = RequestMethod.GET)
	public  ArrayList<viewModel> viewStock() throws ClassNotFoundException, SQLException, IOException
	{
		return viewService.viewStock();
	}
	
	
}
*/
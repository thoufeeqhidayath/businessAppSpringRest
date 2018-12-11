package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.dbCommonServices;
import appDBrepository.salesInvoiceDbRepository;
import businessapp.business.viewModel;


@Service
public class salesInvoiceService {
	
	@Autowired
	private salesListService salesListService;
	
	@Autowired
	private salesInvoiceDbRepository purchaseInvoiceDbRepository;
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	
 public String addSalesInvoice(int customerCode,int bankCode) throws SQLException
	
	{
		String returnValue="sales invoice added";
		
		purchaseInvoiceDbRepository.insertIntoSalesInvoice(customerCode, bankCode);
		
		return returnValue;
	}
	
	
	
	public String deletesalesInvoice(int salesNo) throws SQLException
	
	{
		String returnValue="deleted";
		
		if(!(dbCommonServices.checkValueExists("sales_invoice","sales_no",salesNo)).equals("exist"))
		{
		returnValue="sales number not exists";
		}
		else
		{
			salesListService.deletesalesList(salesNo);
			purchaseInvoiceDbRepository.deleteFromSalesInvoice(salesNo);
		}
		
		return returnValue;
	}
	
	public String updatesalesInvoice(int salesNo,int customerCode,int bankCode) throws SQLException
	
	{
		String returnValue="updated";
		
		if(!(dbCommonServices.checkValueExists("sales_invoice","sales_no",salesNo)).equals("exist"))
		{
		returnValue="sales number not exists";
		}
		else
		{
		
			purchaseInvoiceDbRepository.updateSalesInvoice(salesNo, customerCode, bankCode);
		}
		
		return returnValue;
	}

	public ArrayList<viewModel> viewSalesInvoices() throws ClassNotFoundException, SQLException, IOException
	{
		return purchaseInvoiceDbRepository.readFromSalesInvoice();
	}

}

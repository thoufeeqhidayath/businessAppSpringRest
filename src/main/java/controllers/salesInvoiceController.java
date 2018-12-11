package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import businessapp.business.viewModel;
import services.salesInvoiceService;

@RestController
public class salesInvoiceController {

	@Autowired
	private salesInvoiceService salesInvoiceService;
	
	@RequestMapping(value="/addSalesInvoice",method=RequestMethod.GET)
	public String addSalesInvoice(@RequestParam(value="customerCode",defaultValue="000")int customerCode,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{	
		return salesInvoiceService.addSalesInvoice(customerCode, bankCode);
	}
     
	@RequestMapping(value="/deleteSalesInvoice",method=RequestMethod.GET)
	public String deleteSalesInvoice(@RequestParam(value="salesNo",defaultValue="000")int salesNo) throws SQLException
	{	
		return salesInvoiceService.deletesalesInvoice(salesNo);
	}
	
	@RequestMapping(value="/updateSalesInvoice",method=RequestMethod.GET)
	public String updatesalesInvoice(int salesNo,int customerCode,int bankCode) throws SQLException
	{
		return salesInvoiceService.updatesalesInvoice(salesNo, customerCode, bankCode);
	}

	@RequestMapping(value= "/viewSalesInvoices" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewSalesInvoices() throws ClassNotFoundException, SQLException, IOException
	{
		return salesInvoiceService.viewSalesInvoices();
	}
	
	
}

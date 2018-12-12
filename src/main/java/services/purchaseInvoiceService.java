package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.dbCommonServices;
import appDBrepository.purchaseInvoiceDbRepository;
import businessapp.business.viewModel;
import models.purchaseInvoiceModel;
@Service
public class purchaseInvoiceService {
	
	@Autowired
	private purchaseInvoiceDbRepository purchaseInvoiceDbRepository;
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	@Autowired
	private purchaseListService purchaseListService;
	
	public String addPurchaseInvoice(int supplierId,int bankCode) throws SQLException
	{
		purchaseInvoiceDbRepository.insertIntoPurchaseInvoice(supplierId, bankCode);
		return dbCommonServices.readMaxFrom("purchase_invoice","purchase_no");
	}
	
	public String deletePurchaseInvoice(int purchaseNo) throws SQLException
	{
		String returnValue="deleted";
		
		if(!(dbCommonServices.checkValueExists("purchase_invoice","purchase_no",purchaseNo)).equals("exist"))
		{
		returnValue="Purchase number not exists";
		}
		else
		{
			purchaseListService.deletePurchaseList(purchaseNo);
			purchaseInvoiceDbRepository.deleteFromPurchaseInvoice(purchaseNo);
		}
		
		return returnValue;
	}
	
	public String updatePurchaseInvoice(int purchaseNo,int supplierCode,int bankCode) throws SQLException
	{
		String returnValue="deleted";
		
		if(!(dbCommonServices.checkValueExists("purchase_invoice","purchase_no",purchaseNo)).equals("exist"))
		{
		returnValue="Purchase number not exists";
		}
		else 
		{
			purchaseListService.deletePurchaseList(purchaseNo);
			purchaseInvoiceDbRepository.updatePurchaseInvoice(purchaseNo, supplierCode, bankCode);
		}
		
		return returnValue;
	}
	
	public ArrayList<purchaseInvoiceModel> viewPurchaseInvoices() throws ClassNotFoundException, SQLException, IOException
	{
		return purchaseInvoiceDbRepository.readFromPurchaseInvoice();
	}

}

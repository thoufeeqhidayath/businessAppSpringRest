package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.dbCommonServices;
import appDBrepository.purchaseListDbRepository;
import appDBrepository.stockDbRepository;
import businessapp.business.viewModel;

@Service
public class purchaseListService {
	
	@Autowired
	private purchaseListDbRepository purchaseListDbRepository;
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	
	
	@Autowired
	private stockDbRepository stockDbRepository;
	
	public String addPurchaseList(int purchaseNo,int itemCode,double price,double quantity) throws SQLException
	{
		String returnValue="added";
		
		if(!(dbCommonServices.checkValueExists("purchase_list","purchase_no",purchaseNo)).equals("exist"))
		{
			
		returnValue="purchase number not exists";
		
		}
		else if(!(dbCommonServices.checkValueExists("stock","item_code",itemCode)).equals("exist"))
		{
			
		}
		else{
		purchaseListDbRepository.insertIntoPurchaseList(purchaseNo, itemCode, price, quantity);
		stockDbRepository.updateStockInc(quantity, itemCode);
		}
		return returnValue;
	}
	
	
	public String deletePurchaseList(int purchaseNo) throws SQLException
	{
		String returnValue="Purchase List deleted";

		if(!(dbCommonServices.checkValueExists("purchase_list","purchase_no",purchaseNo)).equals("exist"))
		{
		returnValue="purchase number not exists";
		}else
		{
			purchaseListDbRepository.deleteFromPurchaseList(purchaseNo);
		}
		return returnValue;
		
	}
	
	public String updatePurchaseList(int purchaseNo,int itemCode,double price,double quantity) throws SQLException
	{ 
		String returnValue="updated";
		

		if(!(dbCommonServices.checkValueExists("purchase_list","purchase_no",purchaseNo)).equals("exist"))
		{
			returnValue="purchase number not exists";
		}else
		{
			purchaseListDbRepository.updatePurchaseList(purchaseNo, itemCode, price, quantity);
		}
		
		return returnValue;
		
	}
	
	public  ArrayList<viewModel> viewPurchaseList() throws ClassNotFoundException, SQLException, IOException
	{
		return purchaseListDbRepository.readFromPurchaseList();
	}


}

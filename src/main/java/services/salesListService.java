package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.stockDbRepository;
import appDBrepository.salesListDbRepository;
import appDBrepository.dbCommonServices;
import businessapp.business.viewModel;
import models.salesListModel;

@Service
public class salesListService {
	
	@Autowired
	private salesListDbRepository salesListDbRepository;
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	@Autowired
	private stockDbRepository stockDbRepository;
	
	public String addSalesList(int salesNo,int itemCode,double price,double quantity) throws SQLException
	{
		String returnValue="sales invoice added";
		
		if(!(dbCommonServices.checkValueExists("sales_invoice","sales_no",salesNo)).equals("exist"))
		{
			returnValue="sales number not exists";
		}
		
		else if(!(dbCommonServices.checkValueExists("stock","item_code",itemCode)).equals("exist"))
		{
			returnValue="item Code not exists";
		}
		
		else
		{
		salesListDbRepository.insertIntoSalesList(salesNo, itemCode, price, quantity);
		stockDbRepository.updateStockDec(quantity, itemCode);
		}
		
		return returnValue;
	}
	
	
	
	public String deletesalesList(int salesNo) throws SQLException
	{
		String returnValue="Sales List deleted";
		
		if(!(dbCommonServices.checkValueExists("sales_list","sales_no",salesNo)).equals("exist"))
		{
			returnValue="sales number not exists";
		}
		else
		{
			salesListDbRepository.deleteFromSalesList(salesNo);
		}
		
		return returnValue;
		
	}
    
	public String updatesalesList(int salesNo,int itemCode,double price,double quantity) throws SQLException
	{
		String returnValue="purchase invoice updated";
		if(!(dbCommonServices.checkValueExists("sales_list","sales_no",salesNo)).equals("exist"))
		{
			returnValue="sales number not exists";
		}else if(!(dbCommonServices.checkValueExists("sales_list","item_code",itemCode)).equals("exist"))
		{
			returnValue="item code Doesn't exist";
		}
		else
		{
			salesListDbRepository.updateSalesList(salesNo, itemCode, price, quantity);
		}
		
		return returnValue;
	}

	public ArrayList<salesListModel> viewSalesList() throws ClassNotFoundException, SQLException, IOException
	{
		return salesListDbRepository.readFromSalesList();
	}
}

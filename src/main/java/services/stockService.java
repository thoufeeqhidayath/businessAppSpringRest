package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.stockDbRepository;
import businessapp.business.viewModel;
import appDBrepository.dbCommonServices;


@Service
public class stockService {
	@Autowired
	private stockDbRepository stockDbRepository;
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	public String addStock(int productCode,int itemCode,double buyingPrice,double sellingPrice,double quantity) throws SQLException
	{
		
		String returnValue="NOT ADDED";
		
		if(!(dbCommonServices.checkValueExists("product","product_code",productCode)).equals("exist"))
		{
			returnValue="Product Id not exists";
		}
		
		else if(!(dbCommonServices.checkValueExists("stock","item_code",itemCode)).equals("exist"))
		{
			stockDbRepository.insertIntoStock(productCode, itemCode, buyingPrice, sellingPrice, quantity);
			returnValue="added";
		}
		else
		{
			stockDbRepository.updateStock(productCode, itemCode, buyingPrice, sellingPrice, quantity);
			returnValue="added";
		}
		return returnValue;
	}
	
	
	public String deleteStock(int productCode) throws SQLException
	{
		String returnValue="NOT DELETED";
	
		if(!(dbCommonServices.checkValueExists("stock","product_code",productCode)).equals("exist"))
	
		{
		returnValue="Product Id not exists";
		}
		else
		{
			stockDbRepository.deleteFromStock(productCode);
		returnValue="deleted";
		}	
		return returnValue;
	}
	
	public String updateStock(int productCode,int itemCode,double buyingPrice,double sellingPrice,double quantity) throws SQLException
	{
		String returnValue="Not Updated";
		if(!(dbCommonServices.checkValueExists("stock","product_code",productCode)).equals("exist"))
		{
		returnValue="Product Id not exists";
		}
		else
		{
		stockDbRepository.updateStock(productCode, itemCode, buyingPrice, sellingPrice, quantity);
		returnValue="updated";
		}	
		return returnValue;	
    }
	
	
	public  ArrayList<viewModel> viewStock() throws ClassNotFoundException, SQLException, IOException
	{
		return stockDbRepository.readFromStock();
	}
}

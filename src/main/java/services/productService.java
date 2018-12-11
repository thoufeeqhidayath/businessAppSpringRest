package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.productDbRepository;
import businessapp.business.viewModel;
import appDBrepository.dbCommonServices;

@Service
public class productService {
	
	@Autowired
	private productDbRepository productDbRepository;
	
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	
	public String addProduct(String productName) throws SQLException
	{
		productDbRepository.insertIntoProduct(productName);
		return "product added";
		
	}
	
	
	public String deleteProduct(int productCode) throws SQLException
	{
		
		String returnValue="deleted";
		if(!(dbCommonServices.checkValueExists("product","product_code",productCode)).equals("exist"))
		{
		returnValue="Product not exists";
		}
		else
		{
			productDbRepository.deleteFromProduct(productCode);
		}
		return returnValue;

	}
	
	public String updateProduct(int productCode,String productName) throws SQLException
	{	
		String returnValue="updated";
		if(!(dbCommonServices.checkValueExists("product","product_code",productCode)).equals("exist"))
		{
		returnValue="Product not exists";
		}
		else
		{
			productDbRepository.updateProduct(productCode, productName);
		}
		return returnValue;
	}
	
	
	
	
	
	public ArrayList<viewModel> viewProducts() throws ClassNotFoundException, SQLException, IOException
	{
		
		return productDbRepository.readFromProduct();	
	}

}

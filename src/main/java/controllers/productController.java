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
import services.productService;


@RestController
public class productController {
	
	@Autowired
	private productService productService;
	
	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String addProduct(@RequestParam(value="productName",defaultValue="nothing")String productName) throws SQLException
	{
		return productService.addProduct(productName);	
	}
	
	@RequestMapping(value="/deleteProduct",method=RequestMethod.GET)
	public String deleteProduct(@RequestParam(value="productId",defaultValue="000")int productId) throws SQLException
	{
		return productService.deleteProduct(productId);	
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.GET)
	public String updateProduct(@RequestParam(value="productCode",defaultValue="000")int productCode,@RequestParam(value="productName",defaultValue="nothing")String productName) throws SQLException
	{
		return productService.updateProduct(productCode, productName);
	}
	
	@RequestMapping(value= "/viewProducts" ,method = RequestMethod.GET)
	public ArrayList<viewModel> viewProducts() throws ClassNotFoundException, SQLException, IOException
	{ 	
		return productService.viewProducts();
	}
}

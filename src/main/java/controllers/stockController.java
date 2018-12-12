package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.stockService;
import models.stockModel;


@RestController
public class stockController {
	
	@Autowired
	private stockService stockService;
	
	
	@RequestMapping(value="/addStock",method=RequestMethod.GET)
	public String addStock(@RequestParam(value="productCode",defaultValue="000")int productCode,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="buyingPrice",defaultValue="000")double buyingPrice,@RequestParam(value="sellingPrice",defaultValue="000")double sellingPrice,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{	
		return stockService.addStock(productCode, itemCode, buyingPrice, sellingPrice, quantity);
	}
	
	
	@RequestMapping(value="/deleteStock",method=RequestMethod.GET)
	public String deleteStock(@RequestParam(value="productCode",defaultValue="000")int productCode) throws SQLException
	{	
		return stockService.deleteStock(productCode);
	}
	
	
	@RequestMapping(value="/updateStock",method=RequestMethod.GET)
	public String updateStock(@RequestParam(value="productCode")int productCode,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="buyingPrice",defaultValue="000")double buyingPrice,@RequestParam(value="sellingPrice",defaultValue="000")double sellingPrice,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{	
		return stockService.updateStock(productCode, itemCode, buyingPrice, sellingPrice, quantity)	;
    }
	
	
	@RequestMapping(value= "/viewStock" ,method = RequestMethod.GET)
	public  ArrayList<stockModel> viewStock() throws ClassNotFoundException, SQLException, IOException
	{
		return stockService.viewStock();
	}
	

}

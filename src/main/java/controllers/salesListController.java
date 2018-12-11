package controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.salesListService;

@RestController
public class salesListController {

	@Autowired
	private salesListService salesListService;
	
	@RequestMapping(value="/addSalesList",method=RequestMethod.GET)
	public String addSalesList(@RequestParam(value="salesNo",defaultValue="000")int salesNo,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="price",defaultValue="000")double price,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{
		String returnValue="sales invoice added";
		
		salesListService.addSalesList(salesNo, itemCode, price, quantity);
		
		
		return returnValue;
	}
	
	
	@RequestMapping(value="/deletesalesList",method=RequestMethod.GET)
	public String deletesalesList(@RequestParam(value="salesNo",defaultValue="000")int salesNo) throws SQLException{

		String returnValue="purchase invoice added";
		
		salesListService.deletesalesList(salesNo);
		
		return returnValue;
	}
	
	
	@RequestMapping(value="/updatesalesList",method=RequestMethod.GET)
	public String updatesalesList(@RequestParam(value="salesNo",defaultValue="000")int salesNo,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="price",defaultValue="000")double price,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{
		String returnValue="sales invoice updated";
		
		salesListService.updatesalesList(salesNo, itemCode, price, quantity);
		
		return returnValue;
	}
	
}

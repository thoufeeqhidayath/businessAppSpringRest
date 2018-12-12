package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.purchaseListService;
import models.purchaseListModel;

@RestController
public class purchaseListController {

	@Autowired
	private purchaseListService purchaseListService;
	
	@RequestMapping(value="/addPurchaseList",method=RequestMethod.GET)
	public String addPurchaseList(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="price",defaultValue="000")double price,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{
		String returnValue="added";
		
		purchaseListService.addPurchaseList(purchaseNo, itemCode, price, quantity);
	
		return returnValue;
	}
	
	
	@RequestMapping(value="/deletePurchaseList",method=RequestMethod.GET)
	public String deletePurchaseList(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo) throws SQLException
	{
		purchaseListService.deletePurchaseList(purchaseNo);
		return "Purchase Invoice deleted";
	}
	
	
	@RequestMapping(value="/updatePurchaseList",method=RequestMethod.GET)
	public String updatePurchaseList(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="price",defaultValue="000")double price,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{
		purchaseListService.updatePurchaseList(purchaseNo, itemCode, price, quantity);
		return "Purchase Invoice updated";
	}

	
	@RequestMapping(value= "/viewPurchaseList" ,method = RequestMethod.GET)
	public  ArrayList<purchaseListModel> viewPurchaseList() throws ClassNotFoundException, SQLException, IOException
	{
		return purchaseListService.viewPurchaseList();
	}
	
	
	
}

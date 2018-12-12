package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.supplierService;
import models.supplierModel;

@RestController
public class supplierController {
	
	
	@Autowired
	private supplierService supplierService;

	@RequestMapping(value="/addSupplier",method=RequestMethod.GET)
	public String addSupplier(@RequestParam(value="supplierName",defaultValue="nothing")String supplierName) throws SQLException
	{	
		return supplierService.addSupplier(supplierName);		
	}
	
	@RequestMapping(value="/deleteSupplier",method=RequestMethod.GET)
	public String deleteSupplier(@RequestParam(value="supplierCode",defaultValue="000")int supplierCode) throws SQLException
	{
		return supplierService.deleteSupplier(supplierCode);	
	}
	
	@RequestMapping(value="/updateSupplier",method=RequestMethod.GET)
	public String updateSupplier(@RequestParam(value="supplierCode",defaultValue="000")int supplierCode,@RequestParam(value="supplierName",defaultValue="nothing")String supplierName) throws SQLException
	{
		return supplierService.updateSupplier(supplierCode, supplierName);
			
	}
	
	@RequestMapping(value= "/viewSuppliers" ,method = RequestMethod.GET)
	public ArrayList<supplierModel> viewSuppliers() throws ClassNotFoundException, SQLException, IOException
	{
		return supplierService.viewSuppliers();
	}

	
	
}

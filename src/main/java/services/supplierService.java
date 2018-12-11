package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appDBrepository.supplierDbRepository;
import businessapp.business.viewModel;
import appDBrepository.dbCommonServices;


@Service
public class supplierService {
	@Autowired
	private supplierDbRepository supplierDbRepository;
	
	@Autowired
	private dbCommonServices dbCommonServices;
	
	public String addSupplier(String supplierName) throws SQLException
	{
		supplierDbRepository.insertIntoSupplier(supplierName);
		return "Supplier added";
	}
	
	
	public String deleteSupplier(int supplierCode) throws SQLException
	{
		String returnValue="deleted";
		if(!(dbCommonServices.checkValueExists("supplier","supplier_code",supplierCode)).equals("exist"))
		{
		returnValue="Supplier not exists";
		}
		else
		{
		supplierDbRepository.deleteFromSupplier(supplierCode);
		}
		
		return returnValue;			
	}
	
	public String updateSupplier(int supplierCode,String supplierName) throws SQLException
	
	{
		String returnValue="Updated";
		if(!(dbCommonServices.checkValueExists("supplier","supplier_code",supplierCode)).equals("exist"))
		{
		returnValue="Supplier not exists";
		}
		else
		{
		supplierDbRepository.updateSupplier(supplierCode, supplierName);
		}
		
		return returnValue;		
		
	}
	
	public ArrayList<viewModel> viewSuppliers() throws ClassNotFoundException, SQLException, IOException
	{
		return supplierDbRepository.readFromSupplier();
	}
	
}

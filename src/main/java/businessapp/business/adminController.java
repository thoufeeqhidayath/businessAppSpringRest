/*package businessapp.business;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class adminController {
	
	@Autowired
	private adminService adminService;
	
	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String addProduct(@RequestParam(value="productName",defaultValue="nothing")String productName) throws SQLException
	{
		return adminService.addProduct(productName);	
	}
	
	@RequestMapping(value="/deleteProduct",method=RequestMethod.GET)
	public String deleteProduct(@RequestParam(value="productId",defaultValue="000")int productId) throws SQLException
	{
		return adminService.deleteProduct(productId);	
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.GET)
	public String updateProduct(@RequestParam(value="productCode",defaultValue="000")int productCode,@RequestParam(value="productName",defaultValue="nothing")String productName) throws SQLException
	{
		return adminService.updateProduct(productCode, productName);
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.GET)
	public String addCustomer(@RequestParam(value="customerName",defaultValue="nothing")String customerName) throws SQLException
	{
		return adminService.addCustomer(customerName);	
	}
	
	@RequestMapping(value="/deleteCustomer",method=RequestMethod.GET)
	public String deleteCustomer(@RequestParam(value="customerCode",defaultValue="000")int customerCode) throws SQLException
	{
		return adminService.deleteCustomer(customerCode);	
	}
	
	@RequestMapping(value="/updateCustomer",method=RequestMethod.GET)
	public String updateCustomer(@RequestParam(value="customerCode",defaultValue="000")int customerCode,@RequestParam(value="customerName",defaultValue="nothing")String customerName) throws SQLException
	{
		return adminService.updateCustomer(customerCode, customerName);
	}
	
	
	@RequestMapping(value="/addSupplier",method=RequestMethod.GET)
	public String addSupplier(@RequestParam(value="supplierName",defaultValue="nothing")String supplierName) throws SQLException
	{	
		return adminService.addSupplier(supplierName);		
	}
	
	@RequestMapping(value="/deleteSupplier",method=RequestMethod.GET)
	public String deleteSupplier(@RequestParam(value="supplierCode",defaultValue="000")int supplierCode) throws SQLException
	{
		return adminService.deleteSupplier(supplierCode);	
	}
	
	@RequestMapping(value="/updateSupplier",method=RequestMethod.GET)
	public String updateSupplier(@RequestParam(value="supplierCode",defaultValue="000")int supplierCode,@RequestParam(value="supplierName",defaultValue="nothing")String supplierName) throws SQLException
	{
		return adminService.updateSupplier(supplierCode, supplierName);
			
	}
	
	@RequestMapping(value="/addBank",method=RequestMethod.GET)
	public String addBank(@RequestParam(value="bankName",defaultValue="nothing")String bankName) throws SQLException
	{
		return adminService.addBank(bankName);
	}
	
	@RequestMapping(value="/deleteBank",method=RequestMethod.GET)
	public String deleteBank(@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{	
		return adminService.deleteBank(bankCode);		
	}
	
	@RequestMapping(value="/updateBank",method=RequestMethod.GET)
	public String updateBank(@RequestParam(value="bankCode",defaultValue="000")int bankCode,@RequestParam(value="bankName",defaultValue="000")String bankName) throws SQLException
	{	
		return adminService.updateBank(bankCode, bankName)	;
	}
	
	
	
	
	@RequestMapping(value="/addStock",method=RequestMethod.GET)
	public String addStock(@RequestParam(value="productCode",defaultValue="000")int productCode,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="buyingPrice",defaultValue="000")double buyingPrice,@RequestParam(value="sellingPrice",defaultValue="000")double sellingPrice,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{	
		return adminService.addStock(productCode, itemCode, buyingPrice, sellingPrice, quantity);
	}
	
	
	@RequestMapping(value="/deleteStock",method=RequestMethod.GET)
	public String deleteStock(@RequestParam(value="productCode",defaultValue="000")int productCode) throws SQLException
	{	
		return adminService.deleteStock(productCode);
	}
	
	
	@RequestMapping(value="/updateStock",method=RequestMethod.GET)
	public String updateStock(@RequestParam(value="productCode")int productCode,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="buyingPrice",defaultValue="000")double buyingPrice,@RequestParam(value="sellingPrice",defaultValue="000")double sellingPrice,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{	
		return adminService.updateStock(productCode, itemCode, buyingPrice, sellingPrice, quantity)	;
    }
}
*/
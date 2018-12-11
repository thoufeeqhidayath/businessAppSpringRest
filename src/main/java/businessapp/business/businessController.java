/*package businessapp.business;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class businessController {
	
	@Autowired
	private businessService businessService;
	

	
	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public String Start()
	{  
		String returnValue="Machine is running";
		return returnValue;
	}
	
	@RequestMapping(value="/addPurchaseInvoice" ,method=RequestMethod.GET)
	public String addPurchaseInvoice(@RequestParam(value="supplierCode",defaultValue="000")int supplierCode,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{ 
		return businessService.addPurchaseInvoice(supplierCode,bankCode);
	}
	
	@RequestMapping(value="/deletePurchaseInvoice",method=RequestMethod.GET)
	public String deletePurchaseInvoice(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo) throws SQLException
	{	
		return businessService.deletePurchaseInvoice(purchaseNo);
	}
	
	@RequestMapping(value="/updatePurchaseInvoice",method=RequestMethod.GET)
	public String updatePurchaseInvoice(int purchaseNo,int supplierCode,int bankCode) throws SQLException
	{
		return businessService.updatePurchaseInvoice(purchaseNo, supplierCode, bankCode);
	}
	
	@RequestMapping(value="/addSalesInvoice",method=RequestMethod.GET)
	public String addSalesInvoice(@RequestParam(value="customerCode",defaultValue="000")int customerCode,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{	
		return businessService.addSalesInvoice(customerCode, bankCode);
	}
     
	@RequestMapping(value="/deleteSalesInvoice",method=RequestMethod.GET)
	public String deleteSalesInvoice(@RequestParam(value="salesNo",defaultValue="000")int salesNo) throws SQLException
	{	
		return businessService.deletesalesInvoice(salesNo);
	}
	
	@RequestMapping(value="/updateSalesInvoice",method=RequestMethod.GET)
	public String updatesalesInvoice(int salesNo,int customerCode,int bankCode) throws SQLException
	{
		return businessService.updatesalesInvoice(salesNo, customerCode, bankCode);
	}
	
	
	@RequestMapping(value="/addpayment",method=RequestMethod.GET)
	public String  addPayment(@RequestParam(value="supplierId",defaultValue="000")int supplierId,@RequestParam(value="amount",defaultValue="000")double  amount,@RequestParam(value="bankCode",defaultValue="000")int  bankCode) throws SQLException
	{
		return businessService.addPayment(supplierId, amount, bankCode);
	}
	
	
	@RequestMapping(value="/deletePayment",method=RequestMethod.GET)
	public String  deletePayment(@RequestParam(value="paymentNo",defaultValue="000")int paymentNo) throws SQLException
	{	
	    return businessService.deletePayment(paymentNo);
	}
	
	@RequestMapping(value="/updatePayment",method=RequestMethod.GET)
	public String updatePayment(@RequestParam(value="paymentNo",defaultValue="000")int paymentNo,@RequestParam(value="supplierCode",defaultValue="000")int supplierCode,@RequestParam(value="amount",defaultValue="000")double amount,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{
		return businessService.updatePayment(paymentNo, supplierCode, amount, bankCode);
	}
	
	@RequestMapping(value="/addReceipt",method=RequestMethod.GET)
	public String  addReceipt(@RequestParam(value="customerCode",defaultValue="000")int customerCode,@RequestParam(value="amount",defaultValue="000")double amount,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{
		return businessService.addReceipt(customerCode, amount, bankCode);
	}
	
	@RequestMapping(value="/deleteReceipt",method=RequestMethod.GET)
	public String  deleteReceipt(@RequestParam(value="receiptCode",defaultValue="000")int receiptCode) throws SQLException
	{
		return businessService.deleteReceipt(receiptCode);
	}
	
	@RequestMapping(value="/updateReceipt",method=RequestMethod.GET)
	public String updateReceipt(@RequestParam(value="receiptCode",defaultValue="000")int receiptCode,@RequestParam(value="customerCode",defaultValue="000")int customerCode,@RequestParam(value="amount",defaultValue="000")double amount,@RequestParam(value="bankCode",defaultValue="000")int bankCode) throws SQLException
	{
		return businessService.UpdateReceipt(receiptCode, amount, customerCode, bankCode);
	}
	
	
	@RequestMapping(value="/addPurchaseList",method=RequestMethod.GET)
	public String addPurchaseList(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="price",defaultValue="000")double price,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{
		String returnValue="added";
		
		businessService.addPurchaseList(purchaseNo, itemCode, price, quantity);
	
		return returnValue;
	}
	
	@RequestMapping(value="/deletePurchaseList",method=RequestMethod.GET)
	public String deletePurchaseList(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo) throws SQLException
	{
		businessService.deletePurchaseList(purchaseNo);
		return "Purchase Invoice deleted";
	}
	
	@RequestMapping(value="/updatePurchaseList",method=RequestMethod.GET)
	public String updatePurchaseList(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="price",defaultValue="000")double price,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{
		businessService.updatePurchaseList(purchaseNo, itemCode, price, quantity);
		return "Purchase Invoice updated";
	}

	
	@RequestMapping(value="/addSalesList",method=RequestMethod.GET)
	public String addSalesList(@RequestParam(value="salesNo",defaultValue="000")int salesNo,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="price",defaultValue="000")double price,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{
		String returnValue="sales invoice added";
		
		businessService.addSalesList(salesNo, itemCode, price, quantity);
		
		
		return returnValue;
	}
	
	
	@RequestMapping(value="/deletesalesList",method=RequestMethod.GET)
	public String deletesalesList(@RequestParam(value="purchaseNo",defaultValue="000")int purchaseNo) throws SQLException
	{
		String returnValue="purchase invoice added";
		
		businessService.deletePurchaseList(purchaseNo);
		
		return returnValue;
	}
	
	
	@RequestMapping(value="/updatesalesList",method=RequestMethod.GET)
	public String updatesalesList(@RequestParam(value="salesNo",defaultValue="000")int salesNo,@RequestParam(value="itemCode",defaultValue="000")int itemCode,@RequestParam(value="price",defaultValue="000")double price,@RequestParam(value="quantity",defaultValue="000")double quantity) throws SQLException
	{
		String returnValue="sales invoice updated";
		
		businessService.updatesalesList(salesNo, itemCode, price, quantity);
		
		return returnValue;
	}

}
*/
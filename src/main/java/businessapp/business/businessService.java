package businessapp.business;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class businessService {
	
	@Autowired
	private appDBrepository appDBrepository;
	
	public String addPurchaseInvoice(int supplierId,int bankCode) throws SQLException
	{
		appDBrepository.insertIntoPurchaseInvoice(supplierId, bankCode);
		return appDBrepository.readMaxFrom("purchase_invoice","purchase_no");
	}
	
	public String deletePurchaseInvoice(int purchaseNo) throws SQLException
	{
		String returnValue="deleted";
		
		if(!(appDBrepository.checkValueExists("purchase_invoice","purchase_no",purchaseNo)).equals("exist"))
		{
		returnValue="Purchase number not exists";
		}
		else
		{
			deletePurchaseList(purchaseNo);
			appDBrepository.deleteFromPurchaseInvoice(purchaseNo);
		}
		
		return returnValue;
	}
	
	public String updatePurchaseInvoice(int purchaseNo,int supplierCode,int bankCode) throws SQLException
	{
		String returnValue="deleted";
		
		if(!(appDBrepository.checkValueExists("purchase_invoice","purchase_no",purchaseNo)).equals("exist"))
		{
		returnValue="Purchase number not exists";
		}
		else 
		{
			deletePurchaseList(purchaseNo);
			appDBrepository.updatePurchaseInvoice(purchaseNo, supplierCode, bankCode);
		}
		
		return returnValue;
	}
	
	
	
	
	public String addSalesInvoice(int customerCode,int bankCode) throws SQLException
	
	{
		String returnValue="sales invoice added";
		
		appDBrepository.insertIntoSalesInvoice(customerCode, bankCode);
		
		return returnValue;
	}
	
	
	
	public String deletesalesInvoice(int salesNo) throws SQLException
	
	{
		String returnValue="deleted";
		
		if(!(appDBrepository.checkValueExists("sales_invoice","sales_no",salesNo)).equals("exist"))
		{
		returnValue="sales number not exists";
		}
		else
		{
			deletesalesList(salesNo);
			appDBrepository.deleteFromSalesInvoice(salesNo);
		}
		
		return returnValue;
	}
	
	public String updatesalesInvoice(int salesNo,int customerCode,int bankCode) throws SQLException
	
	{
		String returnValue="updated";
		
		if(!(appDBrepository.checkValueExists("sales_invoice","sales_no",salesNo)).equals("exist"))
		{
		returnValue="sales number not exists";
		}
		else
		{
		
			appDBrepository.updateSalesInvoice(salesNo, customerCode, bankCode);
		}
		
		return returnValue;
	}
	
	public String addPurchaseList(int purchaseNo,int itemCode,double price,double quantity) throws SQLException
	{
		String returnValue="added";
		
		appDBrepository.insertIntoPurchaseList(purchaseNo, itemCode, price, quantity);
		appDBrepository.updateStockInc(quantity, itemCode);
	
		return returnValue;
	}
	
	
	public String deletePurchaseList(int purchaseNo) throws SQLException
	{
		String returnValue="Purchase List deleted";

		if(!(appDBrepository.checkValueExists("purchase_list","purchase_no",purchaseNo)).equals("exist"))
		{
		returnValue="purchase number not exists";
		}else
		{
		appDBrepository.deleteFromPurchaseList(purchaseNo);
		}
		return returnValue;
		
	}
	
	public String updatePurchaseList(int purchaseNo,int itemCode,double price,double quantity) throws SQLException
	{ 
		String returnValue="updated";
		

		if(!(appDBrepository.checkValueExists("purchase_list","purchase_no",purchaseNo)).equals("exist"))
		{
		returnValue="purchase number not exists";
		}else
		{
			appDBrepository.updatePurchaseList(purchaseNo, itemCode, price, quantity);
		}
		return returnValue;
		
		
	}
	
	public String addSalesList(int salesNo,int itemCode,double price,double quantity) throws SQLException
	{
		String returnValue="sales invoice added";
		
		appDBrepository.insertIntoSalesList(salesNo, itemCode, price, quantity);
		appDBrepository.updateStockDec(quantity, itemCode);
		return returnValue;
	}
	
	
	
	public String deletesalesList(int salesNo) throws SQLException
	{
		String returnValue="Sales List deleted";
		
		if(!(appDBrepository.checkValueExists("sales_list","sales_no",salesNo)).equals("exist"))
		{
			returnValue="sales number not exists";
		}
		else
		{
			appDBrepository.deleteFromSalesList(salesNo);
		}
		
		return returnValue;
		
	}
    
	public String updatesalesList(int salesNo,int itemCode,double price,double quantity) throws SQLException
	{
		String returnValue="purchase invoice updated";
		if(!(appDBrepository.checkValueExists("sales_list","sales_no",salesNo)).equals("exist"))
		{
			returnValue="sales number not exists";
		}else if(!(appDBrepository.checkValueExists("sales_list","item_code",itemCode)).equals("exist"))
		{
			returnValue="item code Doesn't exist";
		}
		else
		{
			appDBrepository.updateSalesList(salesNo, itemCode, price, quantity);
		}
		
		return returnValue;
	}

	
	public String  addPayment(int supplierId,double amount,int bankCode) throws SQLException
	{
		String returnValue="payment   added";
		
		if(!(appDBrepository.checkValueExists("supplier","supplier_code",supplierId)).equals("exist"))
		{
			returnValue="SupplierID not exists";
		
		}
		else if(!(appDBrepository.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
		{
			returnValue="bank code not exists";
		}
		else
		{
			appDBrepository.insertIntoPayment(supplierId,amount,bankCode);
		}
		return returnValue;
	}

	
	public String  deletePayment(int paymentNo) throws SQLException
	{
		
		String returnValue="payment deleted";
	
	
		if(!(appDBrepository.checkValueExists("payment","payment_no",paymentNo)).equals("exist"))
	
		{
			returnValue="payment number not exist";
		}
		else
		{
	    	appDBrepository.deleteFromPayment(paymentNo);
		}
		return returnValue;
	}
	
	public String  updatePayment(int paymentNo,int supplierCode,double amount,int bankCode) throws SQLException
	{
		
		String returnValue="payment updated";
		if(!(appDBrepository.checkValueExists("payment","payment_no",paymentNo)).equals("exist"))
		{
		returnValue="payment number not exists";
		}
		else if(!(appDBrepository.checkValueExists("supplier","supplier_code",supplierCode).equals("exist")))
		{
		returnValue="supplier code not exists";
		
		}
		else  if(!(appDBrepository.checkValueExists("bank_table","bank_code",supplierCode).equals("exist")))
		{
			returnValue="bank code not exists";	
		}
		else
		{
	    	appDBrepository.updatePayment(paymentNo, supplierCode, amount, bankCode);
		}
		return returnValue;
	}
	
	
	
	public String addReceipt(int customerCode,double amount,int bankCode) throws SQLException
	{
		String returnValue="Receipt added";
		
		if(!(appDBrepository.checkValueExists("customer","customer_code",customerCode)).equals("exist"))
		{
		returnValue="Customer code not exists";
		
		}else if(!(appDBrepository.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
		{
			returnValue="bank code not exists";
		}
		else
		{
			appDBrepository.insertIntoReceipt(customerCode, amount, bankCode);
		}	
		return returnValue;
	}
	
	
	public String deleteReceipt(int receiptCode) throws SQLException
	{
		String returnValue="Receipt deleted";
		
		if(!(appDBrepository.checkValueExists("payment","receipt_code",receiptCode)).equals("exist"))
		{
			returnValue="Receipt number not exist";
		}
		else
		{
			appDBrepository.deleteFromReceipt(receiptCode);
		}
		
		return returnValue;
	}
	
	public String UpdateReceipt(int receiptCode,double amount,int customerCode,int bankCode) throws SQLException
	{
		String returnValue="Receipt Updted";
		
		if(!(appDBrepository.checkValueExists("receipt","receipt_code",receiptCode)).equals("exist"))
		{
			returnValue="Receipt number not exist";
		}
		else if(!(appDBrepository.checkValueExists("customer","customer_code",customerCode)).equals("exist"))
		{
			returnValue="Customer code Doesn't Exist";
		}
		else if(!(appDBrepository.checkValueExists("bank_table","bank_code",bankCode)).equals("exist"))
		{
			returnValue="Bank code Doesn't Exist";
		}
		
		else{
			appDBrepository.updateReceipt(receiptCode, customerCode, amount, bankCode);
		}
		
		return returnValue;
	}

}
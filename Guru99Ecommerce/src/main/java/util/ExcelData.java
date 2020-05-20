package util;

public class ExcelData {

	public ExcelData(String invoiceDate) {
		super();
		this.invoiceDate = invoiceDate;
	}

	String invoiceDate;

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
}
package dad.facturas;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InvoiceModel {
	
	private StringProperty invoice = new SimpleStringProperty();
	private StringProperty company = new SimpleStringProperty();
	private StringProperty customer = new SimpleStringProperty();
	private ObjectProperty<LocalDate> invoice_date = new SimpleObjectProperty<LocalDate>();
	private StringProperty  concept = new SimpleStringProperty();
	private StringProperty payMethod = new SimpleStringProperty();
	private StringProperty  price = new SimpleStringProperty();
	private StringProperty  tax = new SimpleStringProperty();
	private StringProperty  taxTotal = new SimpleStringProperty();
	private StringProperty  priceTaxesIncluded = new SimpleStringProperty();
	
	
	@Override
	public String toString() {
		return "[" + invoice.get() +", "+ company.get() +", "+ customer.get() +", "+ invoice_date.get() +", "+ concept.get() +", "+ payMethod.get() 
		+", "+ price.get() +", "+ tax.get() +", "+ taxTotal.get() +", "+ priceTaxesIncluded.get() + "]";
	}

	public final StringProperty invoiceProperty() {
		return this.invoice;
	}
	
	public final String getInvoice() {
		return this.invoiceProperty().get();
	}
	
	public final void setInvoice(final String invoice) {
		this.invoiceProperty().set(invoice);
	}
	
	public final StringProperty companyProperty() {
		return this.company;
	}
	
	public final String getCompany() {
		return this.companyProperty().get();
	}
	
	public final void setCompany(final String company) {
		this.companyProperty().set(company);
	}
	
	public final StringProperty customerProperty() {
		return this.customer;
	}
	
	public final String getCustomer() {
		return this.customerProperty().get();
	}
	
	public final void setCustomer(final String customer) {
		this.customerProperty().set(customer);
	}
	
	public final ObjectProperty<LocalDate> invoice_dateProperty() {
		return this.invoice_date;
	}
	
	public final LocalDate getInvoice_date() {
		return this.invoice_dateProperty().get();
	}
	
	public final void setInvoice_date(final LocalDate invoice_date) {
		this.invoice_dateProperty().set(invoice_date);
	}
	
	public final StringProperty conceptProperty() {
		return this.concept;
	}
	
	public final String getConcept() {
		return this.conceptProperty().get();
	}
	
	public final void setConcept(final String concept) {
		this.conceptProperty().set(concept);
	}
	
	public final StringProperty payMethodProperty() {
		return this.payMethod;
	}
	
	public final String getPayMethod() {
		return this.payMethodProperty().get();
	}
	
	public final void setPayMethod(final String payMethod) {
		this.payMethodProperty().set(payMethod);
	}
	
	public final StringProperty priceProperty() {
		return this.price;
	}
	
	public final String getPrice() {
		return this.priceProperty().get();
	}
	
	public final void setPrice(final String price) {
		this.priceProperty().set(price);
	}
	
	public final StringProperty taxProperty() {
		return this.tax;
	}
	
	public final String getTax() {
		return this.taxProperty().get();
	}
	
	public final void setTax(final String tax) {
		this.taxProperty().set(tax);
	}
	
	public final StringProperty taxTotalProperty() {
		return this.taxTotal;
	}
	
	public final String getTaxTotal() {
		return this.taxTotalProperty().get();
	}
	
	public final void setTaxTotal(final String taxTotal) {
		this.taxTotalProperty().set(taxTotal);
	}
	
	public final StringProperty priceTaxesIncludedProperty() {
		return this.priceTaxesIncluded;
	}
	
	public final String getPriceTaxesIncluded() {
		return this.priceTaxesIncludedProperty().get();
	}
	
	public final void setPriceTaxesIncluded(final String priceTaxesIncluded) {
		this.priceTaxesIncludedProperty().set(priceTaxesIncluded);
	}

}

package dad.facturas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FacturaController implements Initializable {

	@FXML
	private HBox view;

	@FXML
	private Button visualizeButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button deleteButton;

	public FacturaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Dialogo.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}

	@FXML
	void onVisualizeButtonButtonAction(ActionEvent event) {
		// Create the custom dialog.
		Dialog<InvoiceModel> dialog = new Dialog<>();
		dialog.setTitle("Visualizar Facturas");
		dialog.setHeaderText("Esta es la factura seleccionada");

		// PONER ICONO DEL PADRE
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().setAll(FacturaApp.getPrimaryStage().getIcons());
		
		// Set the icon (must be included in the project).
		dialog.setGraphic(new ImageView(this.getClass().getResource("/icons/invoice2.png").toString()));

		ButtonType closeButton = new ButtonType("Cerrar", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(closeButton);
		
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		InvoiceModel factura = getInvoiceExamples();
		Label invoice = new Label(factura.getInvoice());
		Label company = new Label(factura.getCompany());
		Label customer = new Label(factura.getCustomer());
		Label invoiceDate = new Label(factura.getInvoice_date().toString());
		Label concept = new Label(factura.getConcept());
		Label payMethod = new Label(factura.getPayMethod());
		Label price = new Label(factura.getPrice());
		Label tax = new Label(factura.getTax());
		Label taxTotal = new Label(factura.getTaxTotal());
		Label priceTaxesIncluded = new Label(factura.getPriceTaxesIncluded());
		

		grid.add(new Label("Id factura: "), 0, 0);
		grid.add(invoice, 1, 0);
		grid.add(new Label("Id empresa: "), 0, 1);
		grid.add(company, 1, 1);
		grid.add(new Label("Id cliente: "), 0, 2);
		grid.add(customer, 1, 2);
		grid.add(new Label("Fecha de la factura: "), 0, 3);
		grid.add(invoiceDate, 1, 3);
		grid.add(new Label("Id concepto: "), 0, 4);
		grid.add(concept, 1, 4);
		grid.add(new Label("Metodo de pago: "), 0, 5);
		grid.add(payMethod, 1, 5);
		grid.add(new Label("Precio: "), 0, 6);
		grid.add(price, 1, 6);
		grid.add(new Label("Id impuesto: "), 0, 7);
		grid.add(tax, 1, 7);
		grid.add(new Label("Impuesto total: "), 0, 8);
		grid.add(taxTotal, 1, 8);
		grid.add(new Label("Precio de impuestos incluidos: "), 0, 9);
		grid.add(priceTaxesIncluded, 1, 9);
		
		dialog.getDialogPane().setContent(grid);
		
		dialog.setResultConverter(dialogButton -> {
		    return null;
		});
		
		Optional<InvoiceModel> result = dialog.showAndWait();

		result.ifPresent(r -> {
		    System.out.println(r.toString());
		});
	}
	
	@FXML
	void onUpdateButtonAction(ActionEvent event) {
		// Create the custom dialog.
		Dialog<InvoiceModel> dialog = new Dialog<>();
		dialog.setTitle("Actualizar Factura");
		dialog.setHeaderText("Esta es la factura seleccionada");

		// PONER ICONO DEL PADRE
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().setAll(FacturaApp.getPrimaryStage().getIcons());
		
		// Set the icon (must be included in the project).
		dialog.setGraphic(new ImageView(this.getClass().getResource("/icons/invoice2.png").toString()));

		ButtonType buttonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonType, ButtonType.CANCEL);
		
		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField invoiceText = new TextField();
		invoiceText.setPromptText("Id Facturas");
		
		TextField companyText = new TextField();
		companyText.setPromptText("Id Empresa");
		
		TextField customerText = new TextField();
		customerText.setPromptText("Id cliente");
		
		TextField conceptText = new TextField();
		conceptText.setPromptText("Id concepto");
		
		TextField payMethodText = new TextField();
		payMethodText.setPromptText("Id concepto");
		
		TextField priceText = new TextField();
		priceText.setPromptText("Precio");
		
		TextField taxText = new TextField();
		taxText.setPromptText("Id impuesto");
		
		TextField taxTotalText = new TextField();
		taxTotalText.setPromptText("Impuesto total");
		
		TextField priceTaxesIncluded = new TextField();
		priceTaxesIncluded.setPromptText("Impuesto total");
		
		DatePicker invoiceDate = new DatePicker();

		grid.add(new Label("Id factura: "), 0, 0);
		grid.add(invoiceText, 1, 0);
		grid.add(new Label("Id empresa: "), 0, 1);
		grid.add(companyText, 1, 1);
		grid.add(new Label("Id cliente: "), 0, 2);
		grid.add(customerText, 1, 2);
		grid.add(new Label("Fecha de la factura: "), 0, 3);
		grid.add(invoiceDate, 1, 3);
		grid.add(new Label("Id concepto: "), 0, 4);
		grid.add(conceptText, 1, 4);
		grid.add(new Label("Metodo de pago: "), 0, 5);
		grid.add(payMethodText, 1, 5);
		grid.add(new Label("Precio: "), 0, 6);
		grid.add(priceText, 1, 6);
		grid.add(new Label("Id impuesto: "), 0, 7);
		grid.add(taxText, 1, 7);
		grid.add(new Label("Impuesto total: "), 0, 8);
		grid.add(taxTotalText, 1, 8);
		grid.add(new Label("Precio de impuestos incluidos: "), 0, 9);
		grid.add(priceTaxesIncluded, 1, 9);
		
		dialog.getDialogPane().setContent(grid);
		
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == buttonType) {
				InvoiceModel factura = new InvoiceModel();
				factura.setInvoice(invoiceText.getText());
				factura.setCompany(companyText.getText());
				factura.setCustomer(customerText.getText());
				factura.setInvoice_date(invoiceDate.getValue());
				factura.setConcept(conceptText.getText());
				factura.setPayMethod(payMethodText.getText());
				factura.setPrice(priceText.getText());
				factura.setTax(taxText.getText());
				factura.setTaxTotal(taxTotalText.getText());
				factura.setPriceTaxesIncluded(priceTaxesIncluded.getText());
		        return factura;
		    }
		    return null;
		});
		
		Optional<InvoiceModel> result = dialog.showAndWait();

		result.ifPresent(r -> {
		    System.out.println(r.toString());
		});
	}

	@FXML
	void onDeleteButtonAction(ActionEvent event) {
		InvoiceModel factura = getInvoiceExamples();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Borrar");
		alert.setHeaderText("");
		alert.setContentText("Esta usted seguro de eliminar esta factura: "+factura.getInvoice());

		// PONER ICONO DEL PADRE
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().setAll(FacturaApp.getPrimaryStage().getIcons());
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    System.out.println("borrado");
		} 
	}
	
	private InvoiceModel getInvoiceExamples() {
		InvoiceModel factura = new InvoiceModel();
		factura.setInvoice("1");
		factura.setCompany("AED");
		factura.setCustomer("Pepe");
		factura.setInvoice_date(LocalDate.now());
		factura.setConcept("1");
		factura.setPayMethod("1");
		factura.setPrice("23.56");
		factura.setTax("Impuesto de canarias");
		factura.setTaxTotal("20");
		factura.setPriceTaxesIncluded("20");
		return factura;
	}

	public HBox getView() {
		return view;
	}
}

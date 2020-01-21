package dad.facturas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FacturaApp extends Application{
	private static Stage primaryStage;
	FacturaController facturaController;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FacturaApp.primaryStage = primaryStage;
		facturaController = new FacturaController();
		
		Scene scene = new Scene(facturaController.getView(),600,500);
		
		primaryStage.setTitle("Factura");
		primaryStage.getIcons().add(new Image(getClass().getResource("/icons/invoice.png").toString()));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductForm {

    @FXML
    private ComboBox<String> Pid; // Change String to the actual data type

    @FXML
    private TextField Pname;

    @FXML
    private TextField Pprice;

    @FXML
    private TextField Pqty;

    @FXML
    private TableView<Product> table; // Change Product to the actual data type

    @FXML
    private TableColumn<Product, String> tablec1; // Change String to the actual data type
    @FXML
    private TableColumn<Product, String> tablec2; // Change String to the actual data type
    @FXML
    private TableColumn<Product, Integer> tablec3; // Change Integer to the actual data type

    private ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        // Initialize table columns
        tablec1.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        tablec2.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
        tablec3.setCellValueFactory(cellData -> cellData.getValue().getQtyProperty());
        table.setItems(productList);
    }

    @FXML
    void AddBtn(ActionEvent event) {
        // Get data from input fields
        String name = Pname.getText();
        String price = Pprice.getText();
        int qty = Integer.parseInt(Pqty.getText());

        // Create a new product
        Product newProduct = new Product(name, price, qty);

        // Add the new product to the table
        productList.add(newProduct);

        // Clear input fields
        clearFields();
    }

    @FXML
    void DeleteBtn(ActionEvent event) {
        // Get selected product
        Product selectedProduct = table.getSelectionModel().getSelectedItem();

        // Remove the selected product from the table
        productList.remove(selectedProduct);
    }

    @FXML
    void UpdateBtn(ActionEvent event) {
        // Get selected product
        Product selectedProduct = table.getSelectionModel().getSelectedItem();

        // Update the selected product with new data
        selectedProduct.setName(Pname.getText());
        selectedProduct.setPrice(Pprice.getText());
        selectedProduct.setQty(Integer.parseInt(Pqty.getText()));

        // Refresh the table
        table.refresh();

        // Clear input fields
        clearFields();
    }

    @FXML
    void SearchBtn(ActionEvent event) {
        // Implement search functionality here
    }

    @FXML
    void NewBtn(ActionEvent event) {
        // Clear input fields
        clearFields();
    }

    private void clearFields() {
        Pid.setValue(null);
        Pname.clear();
        Pprice.clear();
        Pqty.clear();
    }
}

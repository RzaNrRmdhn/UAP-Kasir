package uap;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button btnProduk;

    @FXML
    private Button btnDataPenjualan;

    @FXML
    private Button btnKategori;


    @FXML
    void goProduk(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnProduk.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goDataPenjualan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnDataPenjualan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goKategori(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnDataPenjualan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}

package uap;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TambahBarangController {

    BarangModel brg = new BarangModel();

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnOK;

    @FXML
    private TextField txtfldKategori;

    @FXML
    private TextField txtfldBarcode;

    @FXML
    private TextField txtfldDiskon;

    @FXML
    private TextField txtfldExpired;

    @FXML
    private TextField txtfldHarga;

    @FXML
    private TextField txtfldJumlah;

    @FXML
    private TextField txtfldNamaProduk;

    @FXML
    void goKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goOK(ActionEvent event) throws IOException {
        Barang brg1 = new Barang(txtfldNamaProduk.getText(), Double.parseDouble(txtfldHarga.getText()),
                                Double.parseDouble(txtfldDiskon.getText()), Integer.parseInt(txtfldJumlah.getText()),
                                txtfldBarcode.getText(), txtfldExpired.getText(), txtfldKategori.getText());
        brg.addBarang(brg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = (Parent) loader.load(); 
        Stage stage = (Stage) btnOK.getScene().getWindow();
        stage.setScene(new Scene(root));   
    }

}

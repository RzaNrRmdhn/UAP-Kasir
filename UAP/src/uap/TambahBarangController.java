package uap;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TambahBarangController {

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
    void goOK(ActionEvent event) {

    }

}

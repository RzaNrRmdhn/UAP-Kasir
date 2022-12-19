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

public class TambahDataPenjualanController {

    DataPenjualanModel pjl = new DataPenjualanModel();

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnOK;

    @FXML
    private TextField txtfldNama;

    @FXML
    private TextField txtfldStok;

    @FXML
    void goKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goOK(ActionEvent event) throws IOException {
        Penjualan pjl1 = new Penjualan(txtfldNama.getText(), Integer.parseInt(txtfldStok.getText()));
        pjl.addPenjualan(pjl1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DataPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnOK.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}

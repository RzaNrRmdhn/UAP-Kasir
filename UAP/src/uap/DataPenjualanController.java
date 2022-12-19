package uap;

import static db.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DataPenjualanController implements Initializable{

    DataPenjualanModel pjl = new DataPenjualanModel();

    @FXML
    private TableColumn<Penjualan, String> ColomnNama;

    @FXML
    private TableColumn<Penjualan, Integer> ColumnStok;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @FXML
    private Label lbl0;

    @FXML
    private TableView<Penjualan> viewTable;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showPenjualan();
        showJumlah();
    }

    @FXML
    void goHapus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hapusDataPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goTambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tambahDataPenjualan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    public ObservableList<Penjualan> getListPenjualan(){
        ObservableList<Penjualan> listPenjualan = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM datapenjualan;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Penjualan pjl1 = new Penjualan(rs.getString("Nama"), rs.getInt("Stok"));
                listPenjualan.add(pjl1);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listPenjualan;
    }

    public void showPenjualan(){
        ObservableList<Penjualan> list = getListPenjualan();
        ColomnNama.setCellValueFactory(new PropertyValueFactory<Penjualan, String>("namaProduk"));
        ColumnStok.setCellValueFactory(new PropertyValueFactory<Penjualan, Integer>("stok"));

        viewTable.setItems(list);
    }

    public void showJumlah() {
        int count = 0;
        String kueri = "SELECT * FROM datapenjualan;";
        Connection CONN = getConnection();
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(kueri);
            while(rs.next()){
                count++;
            }
            lbl0.setText(Integer.toString(count));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

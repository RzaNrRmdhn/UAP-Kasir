package uap;

import static db.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BarangController implements Initializable{

    @FXML
    private TableColumn<Barang, String> ColumnBarcode;

    @FXML
    private TableColumn<Barang, Double> ColumnDiskon;

    @FXML
    private TableColumn<Barang, String> ColumnExpired;

    @FXML
    private TableColumn<Barang, Double> ColumnHarga;

    @FXML
    private TableColumn<Barang, Integer> ColumnJumlah;

    @FXML
    private TableColumn<Barang, String> ColumnKategori;

    @FXML
    private TableColumn<Barang, String> ColumnNama;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @FXML
    private TableView<Barang> viewTabel;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showBarang();
    }

    @FXML
    void goHapus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hapusBarang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goTambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tambahBarang.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    public ObservableList<Barang> getListBarang(){
        ObservableList<Barang> listBarang = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM barang;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Barang brg1 = new Barang(rs.getString("Nama"), rs.getDouble("Harga"), 
                                        rs.getDouble("Diskon"), rs.getInt("Jumlah"), 
                                        rs.getString("Barcode"), rs.getString("Expired"),
                                        rs.getString("Kategori"));
                listBarang.add(brg1);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listBarang;
    }

    public void showBarang(){
        ObservableList<Barang> list = getListBarang();
        ColumnNama.setCellValueFactory(new PropertyValueFactory<Barang, String>("nama_produk"));
        ColumnHarga.setCellValueFactory(new PropertyValueFactory<Barang, Double>("harga"));
        ColumnDiskon.setCellValueFactory(new PropertyValueFactory<Barang, Double>("diskon"));
        ColumnJumlah.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("jumlah"));
        ColumnBarcode.setCellValueFactory(new PropertyValueFactory<Barang, String>("barcode"));
        ColumnExpired.setCellValueFactory(new PropertyValueFactory<Barang, String>("expired"));
        ColumnKategori.setCellValueFactory(new PropertyValueFactory<Barang, String>("category"));

        viewTabel.setItems(list);
    }
}

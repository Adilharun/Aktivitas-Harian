package controller;

import model.Aktivitas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class mainController {

    @FXML private TextField namaField;
    @FXML private DatePicker tanggalPicker;
    @FXML private TextField durasiField;
    @FXML private ComboBox<String> kategoriCombo;

    @FXML private TableView<Aktivitas> tableAktivitas;
    @FXML private TableColumn<Aktivitas, String> colNama;
    @FXML private TableColumn<Aktivitas, String> colKategori;
    @FXML private TableColumn<Aktivitas, Number> colDurasi;
    @FXML private TableColumn<Aktivitas, String> colTanggal;

    private ObservableList<Aktivitas> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        kategoriCombo.getItems().addAll("Belajar", "Olahraga", "Istirahat", "Lainnya");

        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colDurasi.setCellValueFactory(new PropertyValueFactory<>("durasi"));
        colKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));

        tableAktivitas.setItems(data);

        tableAktivitas.setOnMouseClicked(event -> {
            Aktivitas a = tableAktivitas.getSelectionModel().getSelectedItem();
            if (a != null) {
                namaField.setText(a.getNama());
                tanggalPicker.setValue(a.getTanggal());
                durasiField.setText(String.valueOf(a.getDurasi()));
                kategoriCombo.setValue(a.getKategori());
            }
        });
    }

    @FXML
    public void tambah() {
        if (namaField.getText().isEmpty() ||
            tanggalPicker.getValue() == null ||
            durasiField.getText().isEmpty() ||
            kategoriCombo.getValue() == null)
        {
            showAlert("Semua field harus diisi!");
            return;
        }

        Aktivitas a = new Aktivitas(
                namaField.getText(),
                tanggalPicker.getValue(),
                Integer.parseInt(durasiField.getText()),
                kategoriCombo.getValue()
        );

        data.add(a);
        clearForm();
    }

    @FXML
    public void update() {
        Aktivitas a = tableAktivitas.getSelectionModel().getSelectedItem();
        if (a == null) {
            showAlert("Pilih data dulu!");
            return;
        }

        a.setNama(namaField.getText());
        a.setTanggal(tanggalPicker.getValue());
        a.setDurasi(Integer.parseInt(durasiField.getText()));
        a.setKategori(kategoriCombo.getValue());

        tableAktivitas.refresh();
        clearForm();
    }

    @FXML
    public void hapus() {
        Aktivitas a = tableAktivitas.getSelectionModel().getSelectedItem();
        if (a == null) {
            showAlert("Pilih data dulu!");
            return;
        }

        data.remove(a);
        clearForm();
    }

    @FXML
    public void clearForm() {
        namaField.clear();
        tanggalPicker.setValue(null);
        durasiField.clear();
        kategoriCombo.setValue(null);
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}

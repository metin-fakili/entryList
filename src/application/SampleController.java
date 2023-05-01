package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController implements Initializable {

	@FXML
	private TextField txt_name;

	@FXML
	private TextField txt_vorname;

	@FXML
	private TextField txt_eloZahl;

	@FXML
	private TableView<Teilnehmerliste> table_teilnehmer;

	@FXML
	private TableColumn<Teilnehmerliste, Integer> col_spielernr;

	@FXML
	private TableColumn<Teilnehmerliste, String> col_name;

	@FXML
	private TableColumn<Teilnehmerliste, String> col_vorname;

	@FXML
	private TableColumn<Teilnehmerliste, Integer> col_eloZahl;

	@FXML
	private TableColumn<Teilnehmerliste, String> col_gruppe;

	@FXML
	private TableView<Gruppen> table_gruppeA;

	@FXML
	private TableColumn<Gruppen, Integer> col_spielernr_a;

	@FXML
	private TableColumn<Gruppen, String> col_name_a;

	@FXML
	private TableColumn<Gruppen, String> col_vorname_a;

	@FXML
	private TableColumn<Gruppen, Integer> col_eloZahl_a;
	@FXML
	private TableView<Gruppen> table_gruppeB;

	@FXML
	private TableColumn<Gruppen, Integer> col_spielernr_b;

	@FXML
	private TableColumn<Gruppen, String> col_name_b;

	@FXML
	private TableColumn<Gruppen, String> col_vorname_b;

	@FXML
	private TableColumn<Gruppen, Integer> col_eloZahl_b;
	@FXML
	private TableView<Gruppen> table_gruppeC;

	@FXML
	private TableColumn<Gruppen, Integer> col_spielernr_c;

	@FXML
	private TableColumn<Gruppen, String> col_name_c;

	@FXML
	private TableColumn<Gruppen, String> col_vorname_c;

	@FXML
	private TableColumn<Gruppen, Integer> col_eloZahl_c;
	@FXML
	private TableView<Gruppen> table_gruppeD;

	@FXML
	private TableColumn<Gruppen, Integer> col_spielernr_d;

	@FXML
	private TableColumn<Gruppen, String> col_name_d;

	@FXML
	private TableColumn<Gruppen, String> col_vorname_d;

	@FXML
	private TableColumn<Gruppen, Integer> col_eloZahl_d;

	ObservableList<Teilnehmerliste> listM;
	ObservableList<Gruppen> listG;
	int spielerNummer = 0;
	Connection c = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public void add_Spieler() {

		c = MsSqlConnect.ConnectDB();
		String sql = " insert into dbo.Spieler (SpielerNr, Name, Vorname, EloZahl) values (?,?,?,?)";

		try {
			spielerNummer = MsSqlConnect.getDataSpielerAnzahl() + 1;
			System.out.println(spielerNummer);
			pst = c.prepareStatement(sql);
			pst.setString(1, Integer.toString(spielerNummer));
			pst.setString(2, txt_name.getText());
			pst.setString(3, txt_vorname.getText());
			pst.setString(4, txt_eloZahl.getText());
			pst.execute();
			spielerNummer++;
			System.out.println("Created Spieler successfully");
			initializeAllTables();

		} catch (Exception e) {
			System.out.println("error");
		}
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeAllTables();

	}

	private void initializeAllTables() {
		initializeTableTeilnehmerliste();
		initializeTableGruppeA();
		initializeTableGruppeB();
		initializeTableGruppeC();
		initializeTableGruppeD();
	}

	private void initializeTableTeilnehmerliste() {
		col_spielernr.setCellValueFactory(new PropertyValueFactory<Teilnehmerliste, Integer>("SpielerNr"));
		col_name.setCellValueFactory(new PropertyValueFactory<Teilnehmerliste, String>("Name"));
		col_vorname.setCellValueFactory(new PropertyValueFactory<Teilnehmerliste, String>("Vorname"));
		col_eloZahl.setCellValueFactory(new PropertyValueFactory<Teilnehmerliste, Integer>("EloZahl"));
		col_gruppe.setCellValueFactory(new PropertyValueFactory<Teilnehmerliste, String>("GruppenName"));
		listM = MsSqlConnect.getDataTeilnehmerliste();
		table_teilnehmer.setItems(listM);
	}

	private void initializeTableGruppeA() {
		col_spielernr_a.setCellValueFactory(new PropertyValueFactory<Gruppen, Integer>("SpielerNr"));
		col_name_a.setCellValueFactory(new PropertyValueFactory<Gruppen, String>("Name"));
		col_vorname_a.setCellValueFactory(new PropertyValueFactory<Gruppen, String>("Vorname"));
		col_eloZahl_a.setCellValueFactory(new PropertyValueFactory<Gruppen, Integer>("EloZahl"));
		listG = MsSqlConnect.getDataGruppe("1");
		table_gruppeA.setItems(listG);
	}
	private void initializeTableGruppeB() {
		col_spielernr_b.setCellValueFactory(new PropertyValueFactory<Gruppen, Integer>("SpielerNr"));
		col_name_b.setCellValueFactory(new PropertyValueFactory<Gruppen, String>("Name"));
		col_vorname_b.setCellValueFactory(new PropertyValueFactory<Gruppen, String>("Vorname"));
		col_eloZahl_b.setCellValueFactory(new PropertyValueFactory<Gruppen, Integer>("EloZahl"));
		listG = MsSqlConnect.getDataGruppe("2");
		table_gruppeB.setItems(listG);
	}
	private void initializeTableGruppeC() {
		col_spielernr_c.setCellValueFactory(new PropertyValueFactory<Gruppen, Integer>("SpielerNr"));
		col_name_c.setCellValueFactory(new PropertyValueFactory<Gruppen, String>("Name"));
		col_vorname_c.setCellValueFactory(new PropertyValueFactory<Gruppen, String>("Vorname"));
		col_eloZahl_c.setCellValueFactory(new PropertyValueFactory<Gruppen, Integer>("EloZahl"));
		listG = MsSqlConnect.getDataGruppe("3");
		table_gruppeC.setItems(listG);
	}
	private void initializeTableGruppeD() {
		col_spielernr_d.setCellValueFactory(new PropertyValueFactory<Gruppen, Integer>("SpielerNr"));
		col_name_d.setCellValueFactory(new PropertyValueFactory<Gruppen, String>("Name"));
		col_vorname_d.setCellValueFactory(new PropertyValueFactory<Gruppen, String>("Vorname"));
		col_eloZahl_d.setCellValueFactory(new PropertyValueFactory<Gruppen, Integer>("EloZahl"));
		listG = MsSqlConnect.getDataGruppe("4");
		table_gruppeD.setItems(listG);
	}

}

package application;

public class Gruppen {

	int spielerNr, eloZahl;
	String name, vorname;
	

	public Gruppen(int spielerNr,  String name, String vorname, int eloZahl) {
		super();
		this.spielerNr = spielerNr;
		this.eloZahl = eloZahl;
		this.name = name;
		this.vorname = vorname;

	}

	public int getSpielerNr() {
		return spielerNr;
	}
	public void setSpielerNr(int spielerNr) {
		this.spielerNr = spielerNr;
	}
	public int getEloZahl() {
		return eloZahl;
	}
	public void setEloZahl(int eloZahl) {
		this.eloZahl = eloZahl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}

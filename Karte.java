
// Wenn (Farbe Farbe, Wert Wert) sind die enum Klassen im globalen scope nicht mehr aufrufbar, da ueberschattet von lokalen variablen
public record Karte(Farbe thisFarbe, Wert thisWert){

	public String toString() {
		return thisFarbe.toString()+thisWert.toString();
	}
	public static Karte neueKarte(Farbe f, Wert w) {
		 
		Karte nKarte = new Karte(f,w);
		return nKarte;
	 }
	public static Karte neueKarte(String f, String w) {
		return Karte.neueKarte(Farbe.valueOf(f), Wert.valueOf(w));
	 }
}

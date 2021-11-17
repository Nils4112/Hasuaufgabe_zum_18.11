
// Wenn (Farbe Farbe, Wert Wert) sind die enum Klassen im globalen scope nicht mehr aufrufbar, da ueberschattet von lokalen variablen
public record Karte(Farbe thisFarbe, Wert thisWert){

	public String toString() {
	        return thisFarbe.toString()+thisWert.toString();
	    }
	 public static Karte neueKarte(Farbe f, Wert w)
	 {
		 
		Karte nKarte = new Karte(f,w);
		return nKarte;
	 }
	 public static Karte neueKarte(String f, String w)
	 {
		 
		//funktioniert nicht
		 return Karte.neueKarte(Farbe.valueOf(f), Wert.valueOf(w));
		/*switch (f) {
		 case KREUZ: 
			 switch (w) {
			 case SIEBEN: 
			 case ACHT:
			 case NEUN:
			 case ZEHN:
			 case BUBE: 
			 case DAME: 
			 case KOENIG:
			 case ASS:
			 }
		 case PIK:
			 switch (w) {
			 case SIEBEN:
			 case ACHT:
			 case NEUN:
			 case ZEHN:
			 case BUBE:
			 case DAME:
			 case KOENIG:
			 case ASS:
				 }
		 case HERZ:
			 switch (w) {
			 case SIEBEN:
			 case ACHT:
			 case NEUN:
			 case ZEHN:
			 case BUBE:
			 case DAME:
			 case KOENIG:
			 case ASS:
				 }
		 case KARO:
			 switch (w) {
			 case SIEBEN:
			 case ACHT:
			 case NEUN:
			 case ZEHN:
			 case BUBE:
			 case DAME:
			 case KOENIG:
			 case ASS:
				 }
		 }*/
	 }
}

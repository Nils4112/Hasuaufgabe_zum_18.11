
// Wenn (Farbe Farbe, Wert Wert) sind die enum Klassen im globalen scope nicht mehr aufrufbar, da ueberschattet von lokalen variablen
public record Karte(Farbe KartenFarbe, Wert KartenWert){

	public String toString() {
		return KartenFarbe.toString()+KartenWert.toString();
	}
	public static Karte neueKarte(Farbe f, Wert w) {
		 
		Karte nKarte = new Karte(f,w);
		return nKarte;
	}
	public static Karte neueKarte(String f, String w) {
		return Karte.neueKarte(Farbe.valueOf(f), Wert.valueOf(w));
	}
	public static int kombinationen() {
		return Farbe.values().length * Wert.values().length;
	}
	public static Karte[] skatblatt(){
		Karte[] res = new Karte[kombinationen()];

		int i = 0;

		for(Farbe IFarbe : Farbe.values()) {
			for(Wert IWert : Wert.values()) {
				res[i] = neueKarte(IFarbe, IWert);

				i++;
			}
		}

		return res;
	}
	public boolean bedient(Karte other) {
		if(this.KartenWert == Wert.BUBE) {
			return true;
		} else if(this.KartenFarbe == other.KartenFarbe) {
			return true;
		} else if(this.KartenWert == other.KartenWert) {
			return true;
		}
		return false;
	}
	public boolean bedienbar(Karte... kn) {
		for(Karte IKarte : kn) {
			if(IKarte.bedient(this)) {
				return true;
			}
		}
		return false;
	}
	public static void druckeDoppelBedienungen() {
		Karte[] Skatblatt = skatblatt();
		for(Karte IKarte: Skatblatt) {
            for(Karte IKarte2: Skatblatt) {
                if(IKarte.bedient(IKarte2) && IKarte2.bedient(IKarte) && !IKarte.equals(IKarte2)) {
					System.out.println(IKarte + " bedient " + IKarte2 + " und " + IKarte2 + " bedient " + IKarte);
				}
            }
        }
	}
}

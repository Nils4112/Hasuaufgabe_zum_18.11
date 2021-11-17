public class Spieler {
    Karte[] kartenhand;
    String name;
    Karte gespielteKarte;

    public static void main(String[] args) {
        Karte[] ElisabethKarten = {
            new Karte(Farbe.HERZ, Wert.NEUN),
            new Karte(Farbe.HERZ, Wert.ZEHN),
            new Karte(Farbe.PIK, Wert.BUBE),
        };
        Spieler Elisabeth = new Spieler("Elisabeth", ElisabethKarten);

        Karte[] KlausKarten = {
            new Karte(Farbe.HERZ, Wert.ZEHN),
            new Karte(Farbe.PIK, Wert.BUBE),
            new Karte(Farbe.HERZ, Wert.NEUN),
        };
        Spieler Klaus = new Spieler("Elisabeth", KlausKarten);


    }

    Spieler() {
    }

    Spieler(String initName) {
        this.name = initName;
    }

    Spieler(String initName, Karte[] initKartenhand) {
        this.name = initName;
        this.kartenhand = initKartenhand;
    }

    public String toString() {
        return name;
    }

    public void entferneAusKartenHand(int index) {
        Karte[] res = new Karte[kartenhand.length - 1];
        for(int i = 0; i < index; i++) {
            res[i] = kartenhand[i];
        }
        for(int i = index + 1; i < kartenhand.length; i++) {
            res[i - 1] = kartenhand[i];
        }
        kartenhand = res;
    }

    public void spieleKarte(Karte k) {
        for(int i = 0; i < kartenhand.length; i++) {
			if(kartenhand[i].bedient(k)) {
                gespielteKarte = kartenhand[i];
                entferneAusKartenHand(i);
                System.out.println(name + " bedient " + k + " mit " + gespielteKarte);
                return;
			}
		}
        gespielteKarte = null;
    }

    public void spiele(Karte k) {
        
    }
}

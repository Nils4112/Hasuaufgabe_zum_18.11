public class Spieler {
    Karte[] kartenhand;
    String name;
    Karte gespielteKarte;

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
}

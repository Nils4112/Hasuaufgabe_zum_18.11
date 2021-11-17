class Test {
    public static void main(String[] args) {
        //Karte TestKarte = Karte.neueKarte("PIK", "NEUN");
        //System.out.println(TestKarte);

        /*Karte[] TestKarten = Karte.skatblatt();
        for(Karte IKarte: TestKarten) {
            for(Karte IKarte2: TestKarten) {
                System.out.println(IKarte + " " + IKarte2 + " : " + IKarte.bedient(IKarte2));
            }
        }*/

        //Karte.druckeDoppelBedienungen();

        Spieler spieler = new Spieler();
        spieler.kartenhand = Karte.skatblatt();
        for(Karte IKarte: spieler.kartenhand) {
            System.out.println(IKarte);
        }
        spieler.entferneAusKartenHand(4);
        System.out.println("====");
        for(Karte IKarte: spieler.kartenhand) {
            System.out.println(IKarte);
        }
    }
}
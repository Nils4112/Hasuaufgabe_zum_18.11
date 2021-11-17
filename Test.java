class Test {
    public static void main(String[] args) {
        //Karte TestKarte = Karte.neueKarte("PIK", "NEUN");
        //System.out.println(TestKarte);

        Karte[] TestKarten = Karte.skatblatt();
        for(Karte IKarte: TestKarten) {
            for(Karte IKarte2: TestKarten) {
                System.out.println(IKarte + " " + IKarte2 + " : " + IKarte.bedient(IKarte2));
            }
        }
    }
}
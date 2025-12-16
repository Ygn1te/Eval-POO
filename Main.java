public class Main {
    int eau = 100;
    int grains = 50;
    int goblets = 10;
    int usure = 0;
    double monnayeur = 0;
    double caisse = 0;
    Map<String, Recettes> recettes = Map.of(
            "Café Court (Espresso)", new Recettes(1.5, 10, 10, 1),
            "Café Long (Allongé) ", new Recettes(2, 20, 10, 1)
        );
    };

    public boolean VerifUsure() {
        if (usure >= 5) {
            System.out.println("ERREUR : Machine entartrée - Appelez le technicien");
            return false;
        }
        return true;
    }

    public boolean VerifCredit(String choix) {
        if (monnayeur < recettes.get(choix).prix) {
            System.out.println("Crédit insuffisant, ajoutez de la monnaie")
            return false;
        }
        return true;
    }

    public boolean VerifStocks(choix) {
        if (eau < recettes.get(choix).eau) {
            System.out.println("Plus d'eau !")
            return false;
        }
        if (grains < recettes.get(choix).grains) {
            System.out.println("Plus de grains !")
            return false;
        }
        if (goblets < recettes.get(choix).goblets) {
            System.out.println("Plus de gobelets !")
            return false;
        }
        return true;
    }

    public void ExecCommande(choix) {
        eau -= recettes.get(choix).eau;
        grains -= recettes.get(choix).grains;
        gobelets -= recettes.get(choix).gobelets;
        caisse += monnayeur
        monnayeur = 0
        usure += 1
        System.out.println("Votre café est prêt !")
    }
}
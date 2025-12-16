import java.util.*;

public class Machine {
    public int eau;
    public int grains;
    public int goblets;
    public int usure;
    public double monnayeur;
    public double caisse;
    public Map<String, Recettes> recettes;

    Machine() {
        this.eau = 100;
        this.grains = 50;
        this.goblets = 10;
        this.usure = 0;
        this.monnayeur = 0;
        this.caisse = 0;
        this.recettes = Map.of(
                "Café Court (Espresso)", new Recettes(1.5, 10, 10, 1),
                "Café Long (Allongé)", new Recettes(2, 20, 10, 1)
            );
    }

    public boolean VerifUsure() {
        if (this.usure >= 5) {
            System.out.println("ERREUR : Machine entartrée - Appelez le technicien");
            return true;
        }
        return false;
    }

    public boolean VerifCredit(String choix) {
        if (this.monnayeur < this.recettes.get(choix).prix) {
            System.out.println("Crédit insuffisant, ajoutez de la monnaie");
            return false;
        }
        return true;
    }

    public boolean VerifStocks(String choix) {
        if (this.eau < this.recettes.get(choix).eau) {
            System.out.println("Plus d'eau !");
            return false;
        }
        if (this.grains < this.recettes.get(choix).grains) {
            System.out.println("Plus de grains !");
            return false;
        }
        if (this.goblets < this.recettes.get(choix).goblets) {
            System.out.println("Plus de gobelets !");
            return false;
        }
        return true;
    }

    public void ExecCommande(String choix) {
        if (VerifCredit(choix) && VerifStocks(choix)) {
            this.eau -= this.recettes.get(choix).eau;
            this.grains -= this.recettes.get(choix).grains;
            this.goblets -= this.recettes.get(choix).goblets;
            this.caisse += this.monnayeur;
            this.monnayeur = 0;
            this.usure += 1;
            System.out.println("Votre café est prêt !");
        }
    }
}
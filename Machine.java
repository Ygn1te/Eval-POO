import java.util.Map;

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
            "Café Long (Allongé) ", new Recettes(2, 20, 10, 1)
        );
    }
}
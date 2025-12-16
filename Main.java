import java.util.*;

public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        Machine machine1 = new Machine();
        while (true) {
            if (machine1.VerifUsure()) {
                System.out.println("ERREUR : Machine entartrée - Appelez le technicien");
                break;
            }
            System.out.println("-------------------------------------------------");
            System.out.println("ETAT : EAU: " + machine1.eau + "cl | GRAINS: " + machine1.grains + "g | GOBELETS: " + machine1.goblets);
            System.out.println("CREDIT : " + machine1.monnayeur + " €");
            System.out.println("-------------------------------------------------");
            System.out.println("1. Insérer une pièce (Simuler +0.50€)");
            System.out.println("2. Commander un Espresso (1.50€)");
            System.out.println("3. Commander un Allongé (2.00€)");
            System.out.println("4. MENU TECHNICIEN (Maintenance)");
            System.out.println("5. Quitter");
            
            String input = scanner.nextLine();

            if (input.equals("1")) {
                machine1.monnayeur += 0.5;
            }
            else if (input.equals("2")) {
                machine1.ExecCommande("Café Court (Espresso)");
            }
            else if (input.equals("3")) {
                machine1.ExecCommande("Café Long (Allongé)");
            }
            else if (input.equals("4")) {
                while (true) {
                    System.out.println("1. Recharger");
                    System.out.println("2. Détartrer");
                    System.out.println("3. Récupérer l'argent");
                    input = scanner.nextLine();

                    if (input.equals("1")) {
                        machine1.eau = 100;
                        machine1.grains = 50;
                        machine1.goblets = 10;
                        break;
                    }
                    else if (input.equals("2")) {
                        machine1.usure = 0;
                        break;
                    }
                    else if (input.equals("3")) {
                        System.out.println(machine1.caisse);
                        machine1.caisse = 0;
                        break;
                    }
                }
            }
            else if (input.equals("5")) {
                break;
            }
        }
    }
}
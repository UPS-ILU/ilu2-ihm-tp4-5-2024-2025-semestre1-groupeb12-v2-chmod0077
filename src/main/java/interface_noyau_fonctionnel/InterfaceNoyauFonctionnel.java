package interface_noyau_fonctionnel;

import java.time.LocalDate;

public class InterfaceNoyauFonctionnel {

    public String[] trouverTableDisponible(int jour, int mois, int nombrePersonnes, String time) {
        return new String[]{"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6"};
    }
    
    public String[] trouverHeureSelonDate( LocalDate date ) {
        return new String[]{ "11h30", "12h00", "12h30", "13h00", "13h30" };
    }

}

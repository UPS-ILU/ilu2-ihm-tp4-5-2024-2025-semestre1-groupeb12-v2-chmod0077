/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialog;

import interface_noyau_fonctionnel.InterfaceNoyauFonctionnel;
import java.awt.EventQueue;
import java.time.LocalDate;
import presentation.FrameReservation;

public class DialogReservation {

    private FrameReservation frameReservation;
    private InterfaceNoyauFonctionnel inf;
    
    private int jour;
    private int mois;
    private String time;
    private int nbPersonnes;
    private int numTable;

    public DialogReservation(InterfaceNoyauFonctionnel inf) {
        this.inf = inf;
    }

    public void initDialog() {
        frameReservation = new FrameReservation();
        frameReservation.initFrame();
        frameReservation.setDialog(this);
        frameReservation.setVisible(true);
    }

    public void handleDateSelectedEvent(LocalDate date) {
        this.jour = date.getDayOfMonth();
        this.mois = date.getMonthValue();
        
        String[] heures = inf.trouverHeureSelonDate(date);
        frameReservation.jComboBoxHeureValuesUpdated(heures);
        frameReservation.jComboBoxHeureShowOptions();
    }

    public void handleTimeSelectedEvent(String time) {
        this.time = time;
        
        String[] personnes = inf.trouverPersonnesSelonHeure(time);
        frameReservation.jComboBoxPersonnesShowOptions();
        frameReservation.jComboBoxPersonnesValuesUpdated(personnes);
    }

    public void handleNumOfPersonsSelectedEvent(int nbPersons) {
        this.nbPersonnes = nbPersons;
        String[] tables = inf.trouverTableDisponible(this.jour, this.mois, nbPersons, this.time);
        
        frameReservation.jListTablesValuesUpdated(tables);
        frameReservation.jListTablesShowOptions();
    }

    public void handleTableSelectedEvent(int numTable) {
        this.numTable = numTable;
    }

    public void handleCancelEvent() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void handleValidationEvent() {
        javax.swing.JOptionPane.showMessageDialog(frameReservation, "Réservation validée pour le " + this.jour + "/" + this.mois + " à " + this.time + " pour " + this.nbPersonnes + " personnes à la table " + this.numTable + ".");
    }

    public static void main(String[] args) {
        DialogReservation dialog = new DialogReservation(new InterfaceNoyauFonctionnel());
        EventQueue.invokeLater(() -> {
            dialog.initDialog();
        });
    }

}

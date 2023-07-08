package entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Review implements Serializable {
    int review_ID;
    String navn;
    String addresse;
    int crowded;
    int hyggelig;
    int lokation;
    int plads;
    int musik;
    int alder_gennemsnit;
    int kan_se_sport;
    int spil;
    int ølvarianter;
    int charme;
    int typer;
    int øl_pris;
    int shit_pris;
    int drink_pris;
    int user_ID;
    Timestamp dato;


    public Review(int review_ID, String navn, String addresse, int crowded, int hyggelig, int lokation, int plads, int musik, int alder_gennemsnit, int kan_se_sport, int spil, int ølvarianter, int charme, int typer, int øl_pris, int shit_pris, int drink_pris, int user_ID, Timestamp dato) {
        this.review_ID = review_ID;
        this.navn = navn;
        this.addresse = addresse;
        this.crowded = crowded;
        this.hyggelig = hyggelig;
        this.lokation = lokation;
        this.plads = plads;
        this.musik = musik;
        this.alder_gennemsnit = alder_gennemsnit;
        this.kan_se_sport = kan_se_sport;
        this.spil = spil;
        this.ølvarianter = ølvarianter;
        this.charme = charme;
        this.typer = typer;
        this.øl_pris = øl_pris;
        this.shit_pris = shit_pris;
        this.drink_pris = drink_pris;
        this.user_ID = user_ID;
        this.dato = dato;
    }

    public Review(String navn, String addresse, int crowded, int hyggelig, int lokation, int plads, int musik, int alder_gennemsnit, int kan_se_sport, int spil, int ølvarianter, int charme, int typer, int øl_pris, int shit_pris, int drink_pris) {
        this.navn = navn;
        this.addresse = addresse;
        this.crowded = crowded;
        this.hyggelig = hyggelig;
        this.lokation = lokation;
        this.plads = plads;
        this.musik = musik;
        this.alder_gennemsnit = alder_gennemsnit;
        this.kan_se_sport = kan_se_sport;
        this.spil = spil;
        this.ølvarianter = ølvarianter;
        this.charme = charme;
        this.typer = typer;
        this.øl_pris = øl_pris;
        this.shit_pris = shit_pris;
        this.drink_pris = drink_pris;
    }

    public int getReview_ID() {
        return review_ID;
    }

    public void setReview_ID(int review_ID) {
        this.review_ID = review_ID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getCrowded() {
        return crowded;
    }

    public void setCrowded(int crowded) {
        this.crowded = crowded;
    }

    public int getHyggelig() {
        return hyggelig;
    }

    public void setHyggelig(int hyggelig) {
        this.hyggelig = hyggelig;
    }

    public int getLokation() {
        return lokation;
    }

    public void setLokation(int lokation) {
        this.lokation = lokation;
    }

    public int getPlads() {
        return plads;
    }

    public void setPlads(int plads) {
        this.plads = plads;
    }

    public int getMusik() {
        return musik;
    }

    public void setMusik(int musik) {
        this.musik = musik;
    }

    public int getAlder_gennemsnit() {
        return alder_gennemsnit;
    }

    public void setAlder_gennemsnit(int alder_gennemsnit) {
        this.alder_gennemsnit = alder_gennemsnit;
    }

    public int getKan_se_sport() {
        return kan_se_sport;
    }

    public void setKan_se_sport(int kan_se_sport) {
        this.kan_se_sport = kan_se_sport;
    }

    public int getSpil() {
        return spil;
    }

    public void setSpil(int spil) {
        this.spil = spil;
    }

    public int getØlvarianter() {
        return ølvarianter;
    }

    public void setØlvarianter(int ølvarianter) {
        this.ølvarianter = ølvarianter;
    }

    public int getCharme() {
        return charme;
    }

    public void setCharme(int charme) {
        this.charme = charme;
    }

    public int getTyper() {
        return typer;
    }

    public void setTyper(int typer) {
        this.typer = typer;
    }

    public int getØl_pris() {
        return øl_pris;
    }

    public void setØl_pris(int øl_pris) {
        this.øl_pris = øl_pris;
    }

    public int getShit_pris() {
        return shit_pris;
    }

    public void setShit_pris(int shit_pris) {
        this.shit_pris = shit_pris;
    }

    public int getDrink_pris() {
        return drink_pris;
    }

    public void setDrink_pris(int drink_pris) {
        this.drink_pris = drink_pris;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public Timestamp getDato() {
        return dato;
    }

    public void setDato(Timestamp dato) {
        this.dato = dato;
    }
}

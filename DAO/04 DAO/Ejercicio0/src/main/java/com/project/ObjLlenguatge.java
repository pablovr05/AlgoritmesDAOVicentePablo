package com.project;

public class ObjLlenguatge {
    private int id;
    private String nom;
    private int any;
    private String dificultat;
    private int popularitat;

    // Constructor por defecto
    public ObjLlenguatge() {
    }

    public ObjLlenguatge(int id, String nom, int any, String dificultat, int popularitat) {
        this.id = id;
        this.nom = nom;
        this.any = any;
        this.dificultat = dificultat;
        this.popularitat = popularitat;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getDificultat() {
        return dificultat;
    }

    public void setDificultat(String dificultat) {
        this.dificultat = dificultat;
    }

    public int getPopularitat() {
        return popularitat;
    }

    public void setPopularitat(int popularitat) {
        this.popularitat = popularitat;
    }

    @Override
    public String toString() {
        return "Llenguatge: " + id + " " + nom + ", " + any + " - " + dificultat + "/" + popularitat;
    }
}

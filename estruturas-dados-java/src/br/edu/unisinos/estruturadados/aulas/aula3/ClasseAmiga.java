package br.edu.unisinos.estruturadados.aulas.aula3;

public class ClasseAmiga {
    public String classe_amiga = "classe amiga";
    public ClasseAmiga(){
        this.classe_amiga = "Classe Amiga ";
    }
    public String getClasseAmiga(){
        return this.classe_amiga;
    }
    public String retornoNull(){
        return null;
    }
    public String retornoNotNull(){
        return "String Retorno"
    }
}

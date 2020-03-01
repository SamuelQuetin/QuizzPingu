package fr.iut.quizzpingu;

import java.util.ArrayList;
import java.util.List;

class Question {
    private String question;
    private String bonneReponse;
    private String mauvaiseReponse = "";
    private List<String> bonnesReponses;
    private List<String> mauvaisesReponses;

    Question(String question, String bonneReponse, String mauvaiseReponse){
        this.question = question;
        this.bonneReponse = bonneReponse;
        this.mauvaiseReponse = mauvaiseReponse;
    }
    Question(String question, String bonneReponse){
        this.question = question;
        this.bonneReponse = bonneReponse;
    }
    Question(String question, ArrayList<String> bonnesReponses,ArrayList<String> mauvaisesReponses){
        this.question = question;
        this.bonnesReponses = new ArrayList<String>();
        this.bonnesReponses.addAll(bonnesReponses);
        this.mauvaisesReponses = new ArrayList<String>();
        this.mauvaisesReponses.addAll(mauvaisesReponses);
    }

    public boolean estBonneReponse(ArrayList<String> reponses){
        return bonnesReponses.containsAll(reponses);
    }


    String getQuestion(){
        return question;
    }

    String getBonneReponse() {
        return bonneReponse;
    }

    String getMauvaiseReponse() {
        return mauvaiseReponse;
    }

    List<String> getMauvaisesReponses() {
        return mauvaisesReponses;
    }

    List<String> getBonnesReponses() {
        return bonnesReponses;
    }
}

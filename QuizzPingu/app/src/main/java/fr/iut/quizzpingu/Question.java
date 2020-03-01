package fr.iut.quizzpingu;

class Question {
    private String question;
    private String bonneReponse;
    private String mauvaiseReponse = "";

    Question(String question, String bonneReponse, String mauvaiseReponse){
        this.question = question;
        this.bonneReponse = bonneReponse;
        this.mauvaiseReponse = mauvaiseReponse;
    }
    Question(String question, String bonneReponse){
        this.question = question;
        this.bonneReponse = bonneReponse;
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
}

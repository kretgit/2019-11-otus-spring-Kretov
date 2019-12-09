package ru.otus.spring.homework.domain;

public class Dialog {

    private String greeting;

    private String choosing;

    private String variant;

    private String trueAnswer;

    private String falseAnswer;

    private String passAnswer;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void setChoosing(String choosing) {
        this.choosing = choosing;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public void setFalseAnswer(String falseAnswer) {
        this.falseAnswer = falseAnswer;
    }

    public void setPassAnswer(String passAnswer) {
        this.passAnswer = passAnswer;
    }

    public String getGreeting() {

        return greeting;
    }

    public String getChoosing() {
        return choosing;
    }

    public String getVariant() {
        return variant;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public String getFalseAnswer() {
        return falseAnswer;
    }

    public String getPassAnswer() {
        return passAnswer;
    }

    public Dialog(String greeting, String choosing, String variant, String trueAnswer, String falseAnswer, String passAnswer) {

        this.greeting = greeting;
        this.choosing = choosing;
        this.variant = variant;
        this.trueAnswer = trueAnswer;
        this.falseAnswer = falseAnswer;
        this.passAnswer = passAnswer;
    }
}

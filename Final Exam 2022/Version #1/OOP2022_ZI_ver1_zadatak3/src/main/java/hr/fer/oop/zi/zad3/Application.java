package hr.fer.oop.zi.zad3;

import java.util.Comparator;

public class Application{

    private final Applicant applicant;
    private final double score;

    public Application(Applicant applicant, double score) {
        this.applicant = applicant;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public Applicant getApplicant() {
        return applicant;
    }

}

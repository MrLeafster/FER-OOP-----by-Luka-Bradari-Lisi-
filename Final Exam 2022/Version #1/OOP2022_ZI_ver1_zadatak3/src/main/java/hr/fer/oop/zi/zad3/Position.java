package hr.fer.oop.zi.zad3;

import java.util.*;

public class Position{

    private Comparator<Application> appComp = Comparator.comparing(Application::getScore).reversed()
            .thenComparing((a,b) -> a.getApplicant().getId() - b.getApplicant().getId());

    private final String name;
    private List<RequiredSkill> requiredSkills = new ArrayList<>();
    private Collection<Application> applications = new TreeSet<>(appComp);
    // TODO: Create a collection of oredered Application objects, called 'applications'

    public Position(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position addRequiredSkill(RequiredSkill skill) {
    	this.requiredSkills.add(skill);
        return this;
    }

    public void addApplication(Applicant applicant) {
        double score = scoreFor(applicant);
        Application newAplication = new Application(
                applicant,
                score
        );
        applications.add(newAplication);
    }

    public double scoreFor(Applicant app){
        double score = 0;
        for(RequiredSkill skill: requiredSkills){
            double skillScore = app.getRequiredSkillScore(skill.getName());
            if(skillScore < skill.getMinimum()){
                score = 0;
                break;
            } else {
                score += skillScore * skill.getMultiplier();
            }
        }
        return score;
    }

    public Collection<Application> getApplications() {
        return applications;
    }

    public String summarizeApplications() {
        StringBuilder builder = new StringBuilder(this.name);
        builder.append(':');
        
        for(Application app: applications){
            builder.append(String.format("\n\t%s - ", app.getApplicant().getName()));

            if(app.getScore() == 0)
                builder.append("did not meet requirements");
            else
                builder.append(String.format("%.2f", app.getScore()));
        }
        return builder.toString();
    }
}
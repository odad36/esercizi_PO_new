package it.unisa.company;

public class Manager extends Employee {

    private String expertiseArea;
    private int workedHours;

    public Manager(String name, String lastName, String jobTitle, float hourlyWage, String expertiseArea, int workedHours){
        super(name, lastName, jobTitle, hourlyWage);
        this.expertiseArea = expertiseArea;
        this.updateSalary(hourlyWage, workedHours);
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
        this.updateSalary(getHourlyWage(), this.workedHours);
    }

    public void updateSalary(float hourlyWage, int workedHours){
        if(workedHours <= 40) {
            float wage = workedHours * hourlyWage;
            setWage(wage);
        }
        else {
            int straordinari = workedHours - 40;
                setWage(workedHours * hourlyWage + straordinari * hourlyWage * 1.5f);
        }
    }

    @Override
    public void setHourlyWage(float hourlyWage){
        super.setHourlyWage(hourlyWage);
        this.updateSalary(hourlyWage, this.workedHours);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Area di competenza='" + expertiseArea + '\'';
    }
}

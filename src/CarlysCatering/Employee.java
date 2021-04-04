package CarlysCatering;
//Todd Mills
//Unit 11 Case Problems
//This file holds information for the Employee superclass
public abstract class Employee {
    //Class data fields
    private int empIDNum;
    private String empLastName;
    private String empFirstName;
    protected double empPayRate;
    protected String empJobTitle;
    //Class get and set methods
    public void setEmpIDNum(int idInput) {
        empIDNum = idInput;
    }
    public void setEmpLastName(String lastNameInput) {
        empLastName = lastNameInput;
    }
    public void setEmpFirstName(String firstNameInput) {
        empFirstName = firstNameInput;
    }
    public int getEmpIDNum() {
        return empIDNum;
    }
    public String getEmpLastName() {
        return empLastName;
    }
    public String getEmpFirstName() {
        return empFirstName;
    }
    //Abstract methods for setting pay rate and job title
    public abstract void setEmpPayRate(double payInput);
    public abstract void setEmpJobTitle();
    public double getEmpPayRate() {
        return empPayRate;
    }
    public String getEmpJobTitle() {
        return empJobTitle;
    }
    public void printEmployee() {
        System.out.println("ID: " + empIDNum);
        System.out.println("Last name: " + empLastName);
        System.out.println("First name: " + empFirstName);
        System.out.println("Job title: " + empJobTitle);
        System.out.println("Pay rate: " + empPayRate);
    }
}

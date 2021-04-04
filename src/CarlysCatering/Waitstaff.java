package CarlysCatering;
//Todd Mills
//Unit 11 Case Problems
//Class for the waitstaff employees
public class Waitstaff extends Employee{
    public Waitstaff(int empID, String firstName, String lastName, double payRate) {
        setEmpIDNum(empID);
        setEmpFirstName(firstName);
        setEmpLastName(lastName);
        setEmpJobTitle();
        setEmpPayRate(payRate);
    }
    //Override the abstract superclass methods
    @Override
    public void setEmpPayRate(double payInput) {
        if (payInput <= 10.00) {
            empPayRate = payInput;
        } else {
            empPayRate = 10.00;
        }
    }
    @Override
    public void setEmpJobTitle() {
        empJobTitle = "Waitstaff";
    }
}

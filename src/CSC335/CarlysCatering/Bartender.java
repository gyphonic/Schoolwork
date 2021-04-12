package CSC335.CarlysCatering;
//Todd Mills
//Unit 11 Case Problems
//Class for the bartender employees
public class Bartender extends Employee{
    public Bartender(int empID, String firstName, String lastName, double payRate) {
        setEmpIDNum(empID);
        setEmpFirstName(firstName);
        setEmpLastName(lastName);
        setEmpJobTitle();
        setEmpPayRate(payRate);
    }
    //Override the abstract superclass methods
    @Override
    public void setEmpPayRate(double payInput) {
        if (payInput <= 14.00) {
            empPayRate = payInput;
        } else {
            empPayRate = 14.00;
        }
    }

    @Override
    public void setEmpJobTitle() {
        empJobTitle = "Bartender";
    }
}

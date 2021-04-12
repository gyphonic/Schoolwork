package CSC335.CarlysCatering;
//Todd Mills
//Unit 11 Case Problems
//Class for the Coordinator employees
public class Coordinator extends Employee{
    public Coordinator(int empID, String firstName, String lastName, double payRate) {
        setEmpIDNum(empID);
        setEmpFirstName(firstName);
        setEmpLastName(lastName);
        setEmpJobTitle();
        setEmpPayRate(payRate);
    }
    //Override the abstract superclass methods
    @Override
    public void setEmpPayRate(double payInput) {
        if (payInput <= 20.00) {
            empPayRate = payInput;
        } else {
            empPayRate = 20.00;
        }
    }

    @Override
    public void setEmpJobTitle() {
        empJobTitle = "Coordinator";
    }
}

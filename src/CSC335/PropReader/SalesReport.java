package CSC335.PropReader;
//Todd Mills
//CSC335 Project 2
//This class is for holding sales report information by location
public class SalesReport {
    //Data fields
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String date;
    private int price;
    private int rehabCost;
    private int sellPrice;
    private int totalCost;
    private int netIncome;
    private double tax;
    private double profitAfterTax;
    private double gain;

    //Default and overloaded constructors
    public SalesReport() {

    }
    public SalesReport(String address, String city, String state, String zipCode, String date, int price,
                       int rehabCost, int sellPrice) {
        setAddress(address);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setDate(date);
        setPrice(price);
        setRehabCost(rehabCost);
        setSellPrice(sellPrice);
        calculate();
    }

    //Class methods
    //Method to print out data about the object
    public String print()  {
        return  this.address + " " + this.city + " " + this.state + " " + this.zipCode + " " + this.date;
    }
    //Method to calculate sales report data
    private void calculate() {
        //Total cost is purchase price + rehab cost
        totalCost = price + rehabCost;
        //Net income is sell price - total cost
        netIncome = sellPrice - totalCost;
        //Tax rate is 35%
        tax = netIncome * .35;
        //Profit after tax is net income - tax
        profitAfterTax = netIncome - tax;
        //Percent gain is profit after tax divided by total cost
        gain = profitAfterTax / totalCost;
    }
    //Setter methods
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setRehabCost(int rehabCost) {
        this.rehabCost = rehabCost;
    }
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
}

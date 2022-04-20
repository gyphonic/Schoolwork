package CSC335.PropReader;

//Todd Mills
//CSC335 Project 2
//This class is for holding sales report information by location

public class SalesReport {
    //Data fields
    private static final String delimiter = "|";
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

    //Constructor
    public SalesReport(String address, String city, String state, String zipCode, String date, String price,
                       String rehabCost, String sellPrice) {
        setAddress(address);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setDate(date);
        setPrice(formatString(price));
        setRehabCost(formatString(rehabCost));
        setSellPrice(formatString(sellPrice));
        calculate();
    }

    //Class methods
    //Method to print out data about the object
    public String print()  {
        return  address + delimiter + city + delimiter + state + delimiter + zipCode + delimiter + date +
                delimiter + formatInt(price) + delimiter + formatInt(rehabCost) + delimiter + formatInt(sellPrice) +
                delimiter + formatInt(totalCost) + delimiter + formatInt(netIncome) + delimiter +
                formatDouble(tax, true) + delimiter + formatDouble(profitAfterTax, true) + delimiter +
                formatDouble(gain, false);
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
    //Method to parse incoming Strings into ints
    private int formatString(String inputNumber) {
        StringBuilder formattedInt = new StringBuilder();
        for (int i = 0; i < inputNumber.length(); i++) {
            if (Character.isDigit(inputNumber.charAt(i))) {
                formattedInt.append(inputNumber.charAt(i));
            }
        }
        return Integer.parseInt(formattedInt.toString());
    }
    //Method to format ints into currency notation
    private String formatInt(int inputNumber) {
        char[] chars = Integer.toString(inputNumber).toCharArray();
        StringBuilder formattedMoney = new StringBuilder();
        int comma = 0;
        for (int i = chars.length - 1; i > -1; i--) {
            if (comma % 3 == 0 && comma != 0) {
                formattedMoney.insert(0, ",");
            }
            formattedMoney.insert(0, chars[i]);
            comma++;
        }
        formattedMoney.insert(0, "$");
        return formattedMoney.toString();
    }
    //Method to format doubles into currency or percentage notation
    private String formatDouble(Double inputNumber , Boolean currency) {
        char[] chars = String.format("%.2f", inputNumber).toCharArray();
        StringBuilder formattedMoney = new StringBuilder();
        int comma = -3;
        for (int i = chars.length - 1; i > -1; i--) {
            if (comma % 3 == 0 && comma != 0 && comma != -3) {
                formattedMoney.insert(0, ',');
            }
            formattedMoney.insert(0,chars[i]);
            comma++;
        }
        if (currency) {
            formattedMoney.insert(0, "$");
        } else {
            formattedMoney.append("%");
        }
        return formattedMoney.toString();
    }
    //Setter methods
    private void setAddress(String address) {
        this.address = address;
    }
    private void setCity(String city) {
        this.city = city;
    }
    private void setState(String state) {
        this.state = state;
    }
    private void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    private void setDate(String date) {
        this.date = date;
    }
    private void setPrice(int price) {
        this.price = price;
    }
    private void setRehabCost(int rehabCost) {
        this.rehabCost = rehabCost;
    }
    private void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
}

package SammysRentals;
//Todd Mills
//Unit 11 Case Problems
//Superclass for all equipment
public abstract class Equipment {
    //Class data fields
    private int lessonFee;
    private int equipType;
    private String equipName;
    int rentalFee;
    //String array for rental equipment types
    private final String[] RentalEquipment = {"Personal watercraft", "Ski", "Pontoon boat", "Rowboat", "Canoe", "Kayak",
            "Beach chair", "Umbrella", "Other"};
    //Int array for rental equipment costs
    private final int[] RentalEquipmentFees = {50, 40, 15, 12, 10, 2, 1, 0, 0};

    //Class constructor
    public Equipment (int equipmentTypeInput) {
        if (equipmentTypeInput >= 0 && equipmentTypeInput < 8) {
            setEquipType(equipmentTypeInput);
        } else {
            setEquipType(8);
        }
    }
    public void setEquipType(int equipTypeInput) {
        equipType = equipTypeInput;
    }
    public void setEquipName() {
        equipName = RentalEquipment[equipType];
    }
    public void setRentalFee() {
        rentalFee = RentalEquipmentFees[equipType];
    }
    public void setLessonFee(int lessonFeeInput) {
        lessonFee = lessonFeeInput;
    }
    public int getEquipType() {
        return equipType;
    }
    public String getEquipName() {
        return equipName;
    }
    public int getRentalFee() {
        return rentalFee;
    }
    public int getLessonFee() {
        return lessonFee;
    }
    public abstract String getLessonPolicy();
    public String checkEquipType(int equipInt) {
        return RentalEquipment[equipInt];
    }
}

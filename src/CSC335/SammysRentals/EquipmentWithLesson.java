package CSC335.SammysRentals;

public class EquipmentWithLesson extends Equipment{
    //Class constructor
    public EquipmentWithLesson(int equipmentTypeInput) {
        super(equipmentTypeInput);
        if(equipmentTypeInput != 1 && equipmentTypeInput != 6 || equipmentTypeInput != 7) {
            setEquipType(equipmentTypeInput);
        } else {
            setEquipType(8);
        }
        setRentalFee();
        setEquipName();
        setLessonFee(27);
    }

    @Override
    public String getLessonPolicy() {
        return "This equipment requires a lesson. Cost for the lesson is $27.";
    }
}

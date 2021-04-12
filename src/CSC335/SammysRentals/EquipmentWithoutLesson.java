package CSC335.SammysRentals;

public class EquipmentWithoutLesson extends Equipment{
    //Class constructor
    public EquipmentWithoutLesson(int equipmentTypeInput) {
        super(equipmentTypeInput);
        if(equipmentTypeInput == 1 || equipmentTypeInput == 6 || equipmentTypeInput == 7) {
            setEquipType(equipmentTypeInput);
        } else {
            setEquipType(8);
        }
        setRentalFee();
        setEquipName();
        setLessonFee(0);
    }

    @Override
    public String getLessonPolicy() {
        return "This equipment does not require a lesson.";

    }
}

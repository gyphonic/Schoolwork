package SammysRentals;
//Todd Mills
//Unit 10
//This class holds data for the LessonWithRental class
public class LessonWithRental extends Rental {
    //Class data fields
    boolean lessonRequired;
    int equipType;
    String[] instructors = {"Steve", "John", "Mary", "Dr. Monkey", "Bob", "Matt", "Jess", "Imogene"};
    //Class constructor
    public LessonWithRental(String contractNum, int rentalTime, int equipTypeInput) {
        super(contractNum, rentalTime);
        equipType = equipTypeInput;
        setEquipType(equipType);
        if (equipType == 0 || equipType == 1) {
            lessonRequired = true;
        }
    }
    public String getInstructor() {
        StringBuilder lessonString = new StringBuilder();
        if (lessonRequired == true) {
            lessonString.insert(0, (", Lessons are required for this equipment."));
        } else {
            lessonString.insert(0, ", Lessons are not required for this equipment.");
        }
        lessonString.insert(0, (instructors[equipType] + " is the instructor for " + getEquipType()));
        return lessonString.toString();
    }
}

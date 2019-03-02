package seedu.addressbook.data.person;

public class TimeTable {

    private TimeSlot[][] timeslot;
    private boolean isPrivate;
    private boolean isPublic;
    private boolean isFinal;
    private boolean isNotFinal;

    public TimeTable(){

    }

    public TimeSlot getSlot(TimeSlot[][] slots,String date,String period){
        int row = 0;
        int column =0;

        switch(date){
            case "MONDAY" : row = 0;
            break;
            case "TUESDAY" : row =1;
            break;
            case "WEDNESDAY" : row = 2;
            break;
            case "THURSDAY" : row = 3;
            break;
            case "FRIDAY" : row =4;
            break;
            case "SATURDAY" : row =5;
            break;
            case "SUNDAY" : row =6;
            break;
        }

        switch(period){
            case "0AM" : column = 0;
            case "030AM" : column = 1;
            case "1AM" : column = 2;
            case "130AM" : column =3;
            case "2AM" : column =4;

        }

        return slots[row][column];
    }


}

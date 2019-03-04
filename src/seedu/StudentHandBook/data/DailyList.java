package seedu.StudentHandBook.data;

import seedu.StudentHandBook.common.Messages;

import java.util.ArrayList;
import java.util.*;

public class DailyList extends Thread{

    private ArrayList<String> dailyList;
    private ArrayList<String> permaList;
    private Integer index;
    private String emptyString = "";

    public  DailyList() {
        dailyList = new ArrayList<>();
        permaList = new ArrayList<>();
    }


    public String addDailyList(String itemToAdd){
        if (permaList.contains(itemToAdd)) return Messages.MESSAGE_DUPLICATE_DAILYITEM;
        dailyList.add(itemToAdd);
        permaList.add(itemToAdd);
        return emptyString;
    }

    public void tickDailyList(Integer index) { dailyList.remove(index);}

    public void clearDailyList(){ dailyList.clear(); }

    public ArrayList<String> getDailyList(){return dailyList;}

    public ArrayList<String> getPermaList(){return this.permaList; }


    public void removeDailyList(Integer index){
        permaList.remove(index);
    }


    public String getAsTextPermaList(){
        return getAsText(permaList);
    }

    public String getAsTextDailyList() {
        return getAsText(dailyList);
    }

    public boolean checkEndOfDay() {
        Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Integer hour = rightNow.get(Calendar.HOUR_OF_DAY);
        Integer min = rightNow.get(Calendar.MINUTE);
        if (rightNow.get(Calendar.HOUR_OF_DAY) == 23 && rightNow.get(Calendar.MINUTE) == 59) return true;
        return false;
    }

    public void resetDailyList(){
        while (true) {
            try {
                if (checkEndOfDay()) {
                    this.dailyList = getPermaList();
                    Thread.sleep(86280000);
                } else Thread.sleep(60000);
            } catch (InterruptedException ex) {break;}
        }
    }



    public String getAsText(ArrayList<String> itemList){
        String displayTextDailyList = ""; index = 1;
        for (String item: itemList) displayTextDailyList += (index++ + ". " + item + '\n');

        if (displayTextDailyList.equals("")) return "There are no more daily tasks to do!";
        return displayTextDailyList;

    }
}


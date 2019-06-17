package com.learnque.my.stories;

import java.util.ArrayList;

public class PeopleData {
    public static String[][] data = new String[][]{
            {"Cristiano Ronaldo", "I am the best player on the world!", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Cristiano_Ronaldo_2018.jpg/220px-Cristiano_Ronaldo_2018.jpg"},
            {"Lionel Messi", "I just want to be a winner with my country!", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Lionel_Messi_20180626.jpg/220px-Lionel_Messi_20180626.jpg"},
            {"Eden Hazard", "Yippie!, now i play for the best club in the world!", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Eden_Hazard_2018_%28cropped%29.jpg/220px-Eden_Hazard_2018_%28cropped%29.jpg"},
            {"Kylian Mbappe", "hey, Perez! come on take me to Real Madrid!", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Kylian_Mbapp%C3%A9_France.jpg/200px-Kylian_Mbapp%C3%A9_France.jpg"},
            {"Virgil Van Dijk", "Is there anyone out there who can give me a challenge?", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/20160604_AUT_NED_8876_2.jpg/200px-20160604_AUT_NED_8876_2.jpg"}
    };

    public static ArrayList<People> getListData(){
        People people = null;
        ArrayList<People> list = new ArrayList<>();
        for (String[] aData : data){
            people = new People();
            people.setName(aData[0]);
            people.setQuote(aData[1]);
            people.setPhoto(aData[2]);

            list.add(people);
        }

        return list;
    }
}

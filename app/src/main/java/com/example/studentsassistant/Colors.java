package com.example.studentsassistant;

public class Colors {
    static String departmentColor[]=new String[]{"#29b4f0","#32a8a4","#3685BC","#D36280"};
    static String bookColor[]=new String[]{"#F49507","#F35524","#F4D6AA","#E49E88","#FFC107","#ECFB51","#D33CE843","#CD009688"};
    static String versityColor[]=new String[]{"#D500BCD4","#DFF44336","#C69C27B0","#D8673AB7","#DF3F51B5","#D82196F3","#BCE91E63"};

    static int departmentIndex=-1;
    static int bookIndex=-1,versityIndex=-1;

    public static String getDepartmentColor(){
        departmentIndex++;
        return departmentColor[departmentIndex%departmentColor.length];
    }
    public static String getBookColor(){
        bookIndex++;
        return bookColor[bookIndex%bookColor.length];

    }
    public static String getVersityColor(){
        versityIndex++;
        return versityColor[versityIndex%versityColor.length];
    }




}

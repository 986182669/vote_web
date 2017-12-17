package org.web.vote.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpDate {
    public static String simpDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
        return sdf.format(date);
    }
    public static void main(String[] args) {

        System.out.println(new SimpDate().simpDate(new Date()));
    }
}

package dmv.portal;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        DMVPortal dmvPortal = new DMVPortal();
        dmvPortal.getAllCustomers();
        System.out.println("Hello world!");

        LocalDate myObj = LocalDate.now();
        System.out.println(myObj);
    }
}
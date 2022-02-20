package com.company.application;

import com.company.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date chekOut = sdf.parse(sc.next());


        if (chekOut.after(checkIn)) {
            Reservation reservation = new Reservation(roomNumber, checkIn, chekOut);
            System.out.println(reservation);

            System.out.println("----------------------------------------");

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            chekOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || chekOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (chekOut.after(checkIn)) {
                reservation.updateDates(checkIn, chekOut);
                System.out.println(reservation);
            } else {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
        } else {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }



/*
        Room number: 8021
        Check-in date (dd/MM/yyyy): 23/09/2019
        Check-out date (dd/MM/yyyy): 26/09/2019
        Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
        Enter data to update the reservation:
        Check-in date (dd/MM/yyyy): 24/09/2015
        Check-out date (dd/MM/yyyy): 29/09/2015
        Error in reservation: Reservation dates for update must be future dates
*/

        sc.close();
    }
}

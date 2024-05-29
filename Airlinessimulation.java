package com.mycompany.airlinessimulation;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

enum Country {
    USA, CANADA, UK, FRANCE, GERMANY, ITALY, INDIA, CHINA, JAPAN, AUSTRALIA
}

class Ticket {
    private String passengerName;
    private Country destination;
    private String flightNumber;

    public Ticket(String passengerName, Country destination, String flightNumber) {
        this.passengerName = passengerName;
        this.destination = destination;
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "passengerName='" + passengerName + '\'' +
                ", destination=" + destination +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }
}

class TicketBooking<T> {
    private Queue<T> ticketQueue;

    public TicketBooking() {
        ticketQueue = new ConcurrentLinkedQueue<>();
    }

    public void bookTicket(T ticket) {
        ticketQueue.offer(ticket);
    }

    public T processTicket() {
        return ticketQueue.poll();
    }
}

class BookingTask implements Runnable {
    private TicketBooking<Ticket> ticketBooking;
    private String passengerName;
    private Country destination;
    private String flightNumber;

    public BookingTask(TicketBooking<Ticket> ticketBooking, String passengerName, Country destination, String flightNumber) {
        this.ticketBooking = ticketBooking;
        this.passengerName = passengerName;
        this.destination = destination;
        this.flightNumber = flightNumber;
    }

    @Override
    public void run() {
        Ticket ticket = new Ticket(passengerName, destination, flightNumber);
        ticketBooking.bookTicket(ticket);
        System.out.println(Thread.currentThread().getName() + " booked " + ticket);
    }
}

public class Airlinessimulation {

    private static final String FLIGHT_REGEX = "^[A-Z]{2}\\d{3,4}$";

    public static void main(String[] args) {
        TicketBooking<Ticket> ticketBooking = new TicketBooking<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter passenger name:");
            String name = scanner.nextLine();

            System.out.println("Choose destination from the following list:");
            for (Country country : Country.values()) {
                System.out.println(country);
            }

            String countryInput = scanner.nextLine().toUpperCase();
            Country destination;
            try {
                destination = Country.valueOf(countryInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid country.");
                i--;
                continue;
            }

            System.out.println("Enter flight number (e.g., AA1234):");
            String flightNumber = scanner.nextLine();
            if (!isValidFlightNumber(flightNumber)) {
                System.out.println("Invalid flight number format.");
                i--;
                continue;
            }

            executor.execute(new BookingTask(ticketBooking, name, destination, flightNumber));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tickets booked. Processing tickets...");
        Ticket ticket;
        while ((ticket = ticketBooking.processTicket()) != null) {
            System.out.println("Processing " + ticket);
        }
    }

    private static boolean isValidFlightNumber(String flightNumber) {
        return Pattern.matches(FLIGHT_REGEX, flightNumber);
    }
}

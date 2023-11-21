import java.util.Scanner;

class TicketBookingSystem {
    private int availableTickets;

    public TicketBookingSystem(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    // Method to book tickets
    public synchronized void bookTicket(String passengerName, int numTickets) {
        if (numTickets > 0 && numTickets <= availableTickets) {
            System.out.println(passengerName + " booked " + numTickets + " ticket(s).");
            availableTickets -= numTickets;
            System.out.println("Available tickets: " + availableTickets);
        } else {
            System.out.println("Sorry, " + passengerName + ". Not enough tickets available.");
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem bookingSystem;
    private String passengerName;
    private int numTickets;

    public BookingThread(TicketBookingSystem bookingSystem, String passengerName, int numTickets) {
        this.bookingSystem = bookingSystem;
        this.passengerName = passengerName;
        this.numTickets = numTickets;
    }

    @Override
    public void run() {
        bookingSystem.bookTicket(passengerName, numTickets);
    }
}

public class TicketBookingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of tickets: ");
        int totalTickets = scanner.nextInt();

        TicketBookingSystem bookingSystem = new TicketBookingSystem(totalTickets);

        System.out.print("Enter the number of tickets for Passenger 1: ");
        int ticketsPassenger1 = scanner.nextInt();

        System.out.print("Enter the number of tickets for Passenger 2: ");
        int ticketsPassenger2 = scanner.nextInt();

        System.out.print("Enter the number of tickets for Passenger 3: ");
        int ticketsPassenger3 = scanner.nextInt();

        BookingThread passenger1 = new BookingThread(bookingSystem, "Passenger 1", ticketsPassenger1);
        BookingThread passenger2 = new BookingThread(bookingSystem, "Passenger 2", ticketsPassenger2);
        BookingThread passenger3 = new BookingThread(bookingSystem, "Passenger 3", ticketsPassenger3);

        // Start the booking threads
        passenger1.start();
        passenger2.start();
        passenger3.start();

        // Wait for all threads to finish
        try {
            passenger1.join();
            passenger2.join();
            passenger3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All passengers have booked their tickets.");

        // Close the scanner
        scanner.close();
    }
}
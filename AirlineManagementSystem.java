
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String destination;
    private int seatsAvailable;

    public Flight(String flightNumber, String destination, int seatsAvailable) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public boolean bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Destination: " + destination + ", Seats Available: " + seatsAvailable;
    }
}

class AirlineManagementSystem {
    private List<Flight> flights;

    public AirlineManagementSystem() {
        flights = new ArrayList<>();
    }

    public boolean isFlightExists(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return true;
            }
        }
        return false;
    }

    public void addFlight(String flightNumber, String destination, int seatsAvailable) {
        if (isFlightExists(flightNumber)) {
            System.out.println("Flight with this number already exists.");
        } else {
            flights.add(new Flight(flightNumber, destination, seatsAvailable));
            System.out.println("Flight added successfully.");
        }
    }

    public void displayFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    public void bookTicket(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                if (flight.bookSeat()) {
                    System.out.println("Ticket booked for flight: " + flightNumber);
                } else {
                    System.out.println("No seats available on this flight.");
                }
                return;
            }
        }
        System.out.println("Flight not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        AirlineManagementSystem airlineSystem = new AirlineManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Flight");
            System.out.println("2. Display Flights");
            System.out.println("3. Book Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter number of seats available: ");
                    int seatsAvailable = scanner.nextInt();
                    if (seatsAvailable <= 0) {
                        System.out.println("Seats should be greater than 0.");
                        break;
                    }
                    airlineSystem.addFlight(flightNumber, destination, seatsAvailable);
                    break;
                case 2:
                    airlineSystem.displayFlights();
                    break;
                case 3:
                    System.out.print("Enter flight number to book: ");
                    String flightToBook = scanner.nextLine();
                    airlineSystem.bookTicket(flightToBook);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

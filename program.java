import java.util.ArrayList;
import java.util.List;

class Flight {
    String flightNumber;
    String origin;
    String destination;
    int availableSeats;

    public Flight(String flightNumber, String origin, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination + " | Seats available: " + availableSeats;
    }
}

class FlightBookingSystem {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(String flightNumber, String origin, String destination, int seats) {
        flights.add(new Flight(flightNumber, origin, destination, seats));
    }

    public Flight searchFlight(String origin, String destination) {
        for (Flight flight : flights) {
            if (flight.origin.equalsIgnoreCase(origin) && flight.destination.equalsIgnoreCase(destination)) {
                return flight;
            }
        }
        return null;
    }

    public boolean bookFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.flightNumber.equals(flightNumber)) {
                return flight.bookSeat();
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        FlightBookingSystem system = new FlightBookingSystem();

        system.addFlight("F123", "New York", "Los Angeles", 10);
        system.addFlight("F456", "Chicago", "Miami", 5);

        Flight flight = system.searchFlight("New York", "Los Angeles");
        if (flight != null) {
            System.out.println("Flight found: " + flight);
        } else {
            System.out.println("No flights found.");
        }

        boolean booked = system.bookFlight("F123");
        if (booked) {
            System.out.println("Flight booked successfully.");
        } else {
            System.out.println("Booking failed. No available seats.");
        }
    }
}
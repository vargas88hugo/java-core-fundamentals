package com.comparablecomparator;

import java.util.*;

/**
 * This class represents the Theater. It is composed by an array list of seat
 * objects and is implemented comparable and comparator.
 * @author Hugo Vargas
 *
 */
public class Theatre {
	private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    /**
     * This method is to use the sort method to order the list by the given
     * parameter. The other way to apply this is by classes.     
     */
    static final Comparator<Seat> PRICE_ORDER =  new Comparator<Theatre.Seat>() {
		
		@Override
		public int compare(Seat seat1, Seat seat2) {
			 if (seat1.getPrice() < seat2.getPrice()) {
                 return -1;
             } else if (seat1.getPrice() > seat2.getPrice()) {
                 return 1;
             } else {
                 return 0;
             }
		}
	};

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1); // Calculates the last letter of the row
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if((row < 'D') && (seatNum >=4 && seatNum <=9)) {
                    price = 14.00;
                } else if((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    // the reserve() method is used in the inner class Seat
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    // for testing
    public Collection<Seat> getSeats() {
        return seats;
    }

    /**
     * The inner class that represents the objects in the list of the
     * outer class. This class implements the Comparable interface to
     * use the binarySearch, min, max, etc.
     * @author Hugo Vargas
     *
     */
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        /**
         * This method compare the strings lexicographically and we can implement
         * another logic 
         */
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        // method to reserve a seat
        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        // method to cancel the reservation of a seat
        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }

}

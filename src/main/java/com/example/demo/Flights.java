package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Flights {

    private Date departs;
    private List<Ticket> tickets;

    //@JsonProperty("Tickets")
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    //@JsonProperty("Departs")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getDeparts() {
        return departs;
    }

    public void setDeparts(Date departs) {
        this.departs = departs;
    }


    static class Ticket {
        private Passenger passenger;
        private int price;

       // @JsonProperty("Price")
        public int getPrice() {
            return price;
        }


        public void setPrice(int price) {
            this.price = price;
        }

       // @JsonProperty("Passenger")
        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }




        static class Passenger {
            private String firstName;
            private String lastName;

            //@JsonProperty("FirstName")
            public String getFirstname() {
                return firstName;
            }

            public void setFirstname(String firstName) {
                this.firstName = firstName;
            }

            //@JsonProperty("LastName")
            public String getLastname() {
                return lastName;
            }

            public void setLastname(String lastName) {
                this.lastName = lastName;
            }


        }
    }
}

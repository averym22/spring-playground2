package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Flights {

    private Date departs;
    private List<Ticket> tickets;

    @JsonProperty("Tickets")
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @JsonProperty("Departs")
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

        @JsonProperty("Price")
        public int getPrice() {
            return price;
        }


        public void setPrice(int price) {
            this.price = price;
        }

        @JsonProperty("Passenger")
        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }




        static class Passenger {
            private String firstname;
            private String lastname;

            @JsonProperty("FirstName")
            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            @JsonProperty("LastName")
            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }


        }
    }
}

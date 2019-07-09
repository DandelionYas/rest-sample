package com.ws.sample.demo.authenticate;

public class TicketContainer {
    private static ThreadLocal<String> tickets = new ThreadLocal<>();

    public static String getTicket() {
        return tickets.get();
    }

    public static void setTicket(String tikcet) {
        tickets.set(tikcet);
    }
}

package com.example.object.ticketSellingV1;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;
    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    // Bag은 초대장을 소유하거나, 티켓을 소유하거나 둘 중 하나만 가질 수 있다.
    public Bag(Long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }
}

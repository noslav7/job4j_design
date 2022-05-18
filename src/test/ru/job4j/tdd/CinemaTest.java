package ru.job4j.tdd;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void whenPutToAccount() {
        Account account = new AccountCinema();

    }

    @Test
    public void whenWithdrawFromAccount() {
        Account account = new AccountCinema();
    }

    @Test
    public void whenEnjoySession() {
        Cinema cinema = new Cinema3D();
        Session3D session3D = new Session3D();
    }

    @Test
    public void obtainTicketFromAnywhere() {
        Ticket3D ticket3D = new Ticket3D();
    }

    @Test
    public void whenJustUseTicket() {
        Ticket3D ticket3D = new Ticket3D();
        Session3D session3D = new Session3D();
    }

    @Test
    public void sellTicket() {
        Ticket3D ticket3D = new Ticket3D();
    }
}
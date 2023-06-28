import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","KNS", 17_000, 10, 16);
        Ticket ticket2 = new Ticket("SPB","Madrid", 90_000, 8, 18);
        Ticket ticket3 = new Ticket("MSK","Turkey", 45_000, 13, 19);
        Ticket ticket4 = new Ticket("MSK","KNS", 10_000, 5, 11);
        Ticket ticket5 = new Ticket("London","MSK", 55_000, 14, 20);
        Ticket ticket6 = new Ticket("MSK","KNS", 10_000, 16, 21);
        Ticket ticket7 = new Ticket("MSK","KNS", 19_000, 12, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket4, ticket6, ticket1, ticket7};
        Ticket[] actual = manager.search("MSK", "KNS");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","KNS", 17_000, 10, 16);
        Ticket ticket2 = new Ticket("SPB","Madrid", 90_000, 8, 18);
        Ticket ticket3 = new Ticket("MSK","Turkey", 45_000, 13, 19);
        Ticket ticket4 = new Ticket("MSK","KNS", 10_000, 5, 11);
        Ticket ticket5 = new Ticket("London","MSK", 55_000, 14, 20);
        Ticket ticket6 = new Ticket("MSK","KNS", 10_000, 16, 21);
        Ticket ticket7 = new Ticket("MSK","KNS", 19_000, 12, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.search("SPB", "Madrid");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNoneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","KNS", 17_000, 10, 16);
        Ticket ticket2 = new Ticket("SPB","Madrid", 90_000, 8, 18);
        Ticket ticket3 = new Ticket("MSK","Turkey", 45_000, 13, 19);
        Ticket ticket4 = new Ticket("MSK","KNS", 10_000, 5, 11);
        Ticket ticket5 = new Ticket("London","MSK", 55_000, 14, 20);
        Ticket ticket6 = new Ticket("MSK","KNS", 10_000, 16, 21);
        Ticket ticket7 = new Ticket("MSK","KNS", 19_000, 12, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SPB", "Berlin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","KNS", 17_000, 10, 16);    // 6
        Ticket ticket2 = new Ticket("SPB","Madrid", 90_000, 8, 18);
        Ticket ticket3 = new Ticket("MSK","Turkey", 45_000, 13, 19);
        Ticket ticket4 = new Ticket("MSK","KNS", 10_000, 5, 8);     // 3
        Ticket ticket5 = new Ticket("London","MSK", 55_000, 14, 20);
        Ticket ticket6 = new Ticket("MSK","KNS", 10_000, 16, 20);    // 4
        Ticket ticket7 = new Ticket("MSK","KNS", 19_000, 12, 14);    // 2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7, ticket4, ticket6, ticket1};
        Ticket[] actual = manager.search("MSK", "KNS", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNoneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","KNS", 17_000, 10, 16);    // 6
        Ticket ticket2 = new Ticket("SPB","Madrid", 90_000, 8, 18);
        Ticket ticket3 = new Ticket("MSK","Turkey", 45_000, 13, 19);
        Ticket ticket4 = new Ticket("MSK","KNS", 10_000, 5, 8);     // 3
        Ticket ticket5 = new Ticket("London","MSK", 55_000, 14, 20);
        Ticket ticket6 = new Ticket("MSK","KNS", 10_000, 16, 20);    // 4
        Ticket ticket7 = new Ticket("MSK","KNS", 19_000, 12, 14);    // 2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("UFA", "KNS", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","KNS", 17_000, 10, 16);    // 6
        Ticket ticket2 = new Ticket("SPB","Madrid", 90_000, 8, 18);
        Ticket ticket3 = new Ticket("MSK","Turkey", 45_000, 13, 19);
        Ticket ticket4 = new Ticket("MSK","KNS", 10_000, 5, 8);     // 3
        Ticket ticket5 = new Ticket("London","MSK", 55_000, 14, 20);
        Ticket ticket6 = new Ticket("MSK","KNS", 10_000, 16, 20);    // 4
        Ticket ticket7 = new Ticket("MSK","KNS", 19_000, 12, 14);    // 2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("London", "MSK", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}

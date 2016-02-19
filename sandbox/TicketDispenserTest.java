import org.junit.*;
import static org.junit.Assert.*;

public class TicketDispenserTest {

    @Test
    public void should() {
        assertEquals(1, 1);
    }

    @Test
    public void a_new_ticket_should_have_turn_number_subsequent_to_previous_one() {
        TicketDispenser ticketDispenser = new TicketDispenser();

        int previousTicketTurnNumber = ticketDispenser.getTurnTicket().getTurnNumber();     
        int newTicketTurnNumber = ticketDispenser.getTurnTicket().getTurnNumber();

        assertEquals(1, newTicketTurnNumber - previousTicketTurnNumber);
    }

    @Test
    public void a_new_ticket_from_another_ticket_dispenser_should_have_turn_number_subsequent_to_previous_one(){

        assertEquals(1,newTicketFromAnotherDispenser-previousTicketFromDispenser)       
    }
    //TODO a_new_ticket_from_another_ticket_dispenser_should_have_turn_number_subsequent_to_previous_one
    //TODO a_new_ticket_should_have_the_given_turn_number

    //TODO vip_ticket_turn_numbers_should_begin_from_1001
    //TODO normal_ticket_turn_numbers_should_begin_from_2001

}
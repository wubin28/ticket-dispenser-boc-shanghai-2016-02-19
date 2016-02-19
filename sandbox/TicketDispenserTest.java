import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TicketDispenserTest {

    @Test
    public void should() {
        assertEquals(1, 1);
    }

    @Test
    public void a_new_ticket_should_have_turn_number_subsequent_to_previous_one() {
        TicketDispenser ticketDispenser = new TicketDispenser();

        int previousTicketTurnNumber = ticketDispenser.getTurnTicket().getTurnNumber();     
        int ticketTurnNumber = ticketDispenser.getTurnTicket().getTurnNumber();

        assertEquals(1, ticketTurnNumber - previousTicketTurnNumber);
    }

    @Test
    public void a_new_ticket_from_another_ticket_dispenser_should_have_turn_number_subsequent_to_previous_one(){
        TurnNumberSequence sequence = new TurnNumberSequence();
        TicketDispenser ticketDispenser = new TicketDispenser(sequence);
        TicketDispenser anotherTicketDispenser = new TicketDispenser(sequence);

        int turnNumberOfPreviousTicketFromDispenser = 
            ticketDispenser.getTurnTicket().getTurnNumber();
        int turnNumberOfTicketFromAnotherDispenser = 
            anotherTicketDispenser.getTurnTicket().getTurnNumber();

        assertEquals(1, turnNumberOfTicketFromAnotherDispenser - 
            turnNumberOfPreviousTicketFromDispenser);       
    }

    @Test
    public void a_new_ticket_should_have_the_given_turn_number(){
        MockTurnNumberSequence mockSequence = new MockTurnNumberSequence();
        mockSequence.arrangeNextTurnNumber(59);
        TicketDispenser dispenser = new TicketDispenser(mockSequence);

        int turnNumber = dispenser.getTurnTicket().getTurnNumber();

        assertEquals(59, turnNumber); 
        mockSequence.verifyMethodGetNextTurnNumberCalledOnce();
    }

    @Test
    public void a_new_ticket_should_have_the_given_turn_number_using_mockito(){
        TurnNumberSequence mockSequence = mock(TurnNumberSequence.class);
        when(mockSequence.getNextTurnNumber()).thenReturn(59);
        TicketDispenser dispenser = new TicketDispenser(mockSequence);

        int turnNumber = dispenser.getTurnTicket().getTurnNumber();

        assertEquals(59, turnNumber); 
        verify(mockSequence).getNextTurnNumber();
    }
    @Test
    public void vip_ticket_turn_numbers_should_begin_from_1001() {
        TurnNumberSequence turnNumberSequence = new TurnNumberSequence(1001);
        TicketDispenser vipTicketDispenser = new TicketDispenser(turnNumberSequence);    

        int firstVipTicketTurnNumber = vipTicketDispenser.getTurnTicket().getTurnNumber();

        assertEquals(1001, firstVipTicketTurnNumber);
    }
    
    @Test
    public void normal_ticket_turn_numbers_should_begin_from_2001() {
        TicketDispenser normalTicketDispenser = 
            new TicketDispenser(new TurnNumberSequence(2001));    

        int firstNormalTicketTurnNumber =
            normalTicketDispenser.getTurnTicket().getTurnNumber();

        assertEquals(2001, firstNormalTicketTurnNumber);
    }

}
public class TurnNumberSequence {
    private int turnNumber = 0;

    public int getNextTurnNumber()
    {
        return turnNumber++;
    }
}

public class TurnNumberSequence {
    private int turnNumber = 0;
    
    public TurnNumberSequence() {
        this(0);
    }

    public TurnNumberSequence(int nextTurnNumber) {
        this.turnNumber = nextTurnNumber;
    }

    public int getNextTurnNumber()
    {
        return turnNumber++;
    }
}
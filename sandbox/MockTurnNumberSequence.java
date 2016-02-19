public class MockTurnNumberSequence extends TurnNumberSequence {
    private int nextTurnNumber;
    private int count;

    public void arrangeNextTurnNumber(int nextTurnNumber) {
        this.nextTurnNumber = nextTurnNumber;
    }

    @Override
    public int getNextTurnNumber()
    {
        count++;
        return nextTurnNumber;
    }
    
    public void verifyMethodGetNextTurnNumberCalledOnce() {
        assert(count == 1);
    }
}
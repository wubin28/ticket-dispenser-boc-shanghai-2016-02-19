public class MockTurnNumberSequence extends TurnNumberSequence {
    private int nextTurnNumber;
    private int count;

    public void arrangeNextTurnNumber(int nextTurnNumber) {
        this.nextTurnNumber = nextTurnNumber;
        this.count = 2;
    }

    @Override
    public int getNextTurnNumber()
    {
        count++;
        return nextTurnNumber;
    }
    
    public void verifyMethodGetNextTurnNumberCalledOnce() {
        if(count != 1) {
            throw new IllegalStateException("method getNextTurnNumber() should be called once");
        }
    }
}
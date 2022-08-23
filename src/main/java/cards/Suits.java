package cards;


public enum Suits {
    CLUBS (0),
    DIAMONDS (13),
    HEARTS (26),
    SPADES (39);
    private int suitsPower;

    public int getSuitsPower() {
        return suitsPower;
    }

    Suits(int suitsPower) {
        this.suitsPower = suitsPower;
    }
}

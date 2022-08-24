package JediGalaxy;

public class Galaxy {
    private BattleField field;

    public Galaxy(BattleField field) {
        this.field = field;
    }

    public void moveEvil(int evilRow, int evilCol) {
        Evil.moveEvil(this.field, evilRow, evilCol);
    }

    public long moveJedi(int jediRow, int jediCol) {
        return Jedi.moveJedi(this.field, jediRow, jediCol);
    }
}

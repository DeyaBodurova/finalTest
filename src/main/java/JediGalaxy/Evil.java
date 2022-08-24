package JediGalaxy;

public class Evil {
    public static void moveEvil(BattleField field, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (field.isInBounds(evilRow, evilCol)) {
                field.setValue(evilRow, evilCol, 0);
            }
            evilRow--;
            evilCol--;
        }
    }

}

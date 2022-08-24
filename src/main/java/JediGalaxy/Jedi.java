package JediGalaxy;

public class Jedi {

    public static long moveJedi(BattleField field, int jediRow, int jediCol) {
        long jediSum = 0;
        while (jediRow >= 0 && jediCol < field.getColLength()) {
            if (field.isInBounds(jediRow, jediCol)) {
                jediSum += field.getValue(jediRow, jediCol);
            }
            jediRow--;
            jediCol++;
        }
        return jediSum;
    }
}

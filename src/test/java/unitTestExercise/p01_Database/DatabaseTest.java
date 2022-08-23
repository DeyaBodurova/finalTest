package unitTestExercise.p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

class DatabaseTest {

    @Test
    public void createDatabase() throws OperationNotSupportedException {
        Integer [] numbers = {-1, 0, 5, 42, 69, 7};
        Database database = new Database(numbers);
        Integer[] dbElements = database.getElements();
        assertEquals(numbers.length, dbElements.length);

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(numbers[i],dbElements[i]);
        }
        // assertEquals(numbers,dbElements);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void createDatabaseConstructorWithLessThanOneElements() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorWithMoreThan16Elements() throws OperationNotSupportedException {
        new Database(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
    }

}
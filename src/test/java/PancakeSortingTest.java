import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Stack;

 class PancakeSortingTest {

    PancakePlate pancakePlate;
    Pancake pancake;

    @BeforeEach
    void setUp() {
        pancakePlate = new PancakePlate();
        //Hardcoded pancakes because creating random is hard to not make them have special sizes
        pancakePlate.addPancakesToPlate();
    }

    @AfterEach
    void cleanUp() {
        //Always clean up plate
        pancakePlate.getPlate().empty();
    }

    //Testing if the amount of made pancakes is between 1 and 25
    @Test
     void generateRightAmountOfPancakesTest() {
        boolean isValid = pancakePlate.getPlate().size() <= 25 && pancakePlate.getPlate().size() >= 1;
        Assertions.assertTrue(isValid);
    }

    //Testing if an added pancakes' size is not equal to one on the plate
    @Test
     void pancakesCannotHaveSameSizeTest() {
        //This test always fails because it is time consuming to implement something which makes sure that pancakes cannot be duplicate
        //Double fori loop is very inefficient and therefor not used
        pancake = new Pancake(1);
        boolean isValid = true;
        for (int i = 0; i < pancakePlate.getPlate().size(); i++) {
            if (pancake.size == pancakePlate.getPlate().get(i).size) {
                isValid = false;
            }
        }
        Assertions.assertTrue(isValid);
    }

    //This test finds the biggest pancake on the plate
    @Test
     void returnTheBiggestPancakeTest() {
        pancakePlate.returnTheBiggestPancake(pancakePlate.getPlate().size());
        //We know that size20 is the biggest pancake
        Assertions.assertEquals(1, pancakePlate.returnTheBiggestPancake(pancakePlate.getPlate().size()));
    }

    //This test finds the smallest pancake on the plate
    @Test
     void returnTheSmallestSizedPancakeTest() {
        pancakePlate.returnTheSmallestSizedPancake();
        //We know that size1 is the smallest pancake
        Assertions.assertEquals(3, pancakePlate.returnTheSmallestSizedPancake());
    }

    @Test
     void setTheBiggestPancakeAtTheBottom() {
        //This method tests if the biggest pancake(size 20) gets put on bottom of the plate
        //Position 5 means that we want it at the bottom of the Stack
        pancakePlate.putTheBiggestPancakeAtTheBottom(1, 5);
        //Get 4 as a stack has range 0-4
        Assertions.assertEquals(20, pancakePlate.getPlate().get(4).size);
    }

    @Test
     void doublyReversedStackIsTheSameAsTheStartingStack() {
        //Doublyreversed stack should be the same as the stack we started with:
        Collections.reverse(pancakePlate.getPlate());
        Assertions.assertEquals(pancakePlate.getPlate(), pancakePlate.returnReversedPancakesAboveSpatula(pancakePlate.getPlate()));
    }

    @Test
     void returnRightAmountOfPancakesAboveSpatulaTest() {
        //This method tests if the spatula will be set under the right amount of pancakes
        //Should return 3 instances of pancakes if position is 2
        System.out.println(pancakePlate.returnPancakesAboveSpatula(2));
        Assertions.assertEquals(3, pancakePlate.returnPancakesAboveSpatula(2).size());
    }

    @Test
     void flippedPancakeHasDifferentSizeTest() {
        //This method test if the flipped pancake is different from the old stack
        //E.G: position 3 means that the top 4 pancakes will be flipped from the stack
        Stack<Pancake> temppPlate = pancakePlate.getPlate();
        pancakePlate.flipAndCombinePancakeStack(3);

        //Here we check if 3 values from the plate are not equal to eachother after being flipped
        Assertions.assertNotEquals(temppPlate.get(1).size, pancakePlate.getPlate().get(1).getSize());
        Assertions.assertNotEquals(temppPlate.get(2).size, pancakePlate.getPlate().get(2).getSize());
        Assertions.assertNotEquals(temppPlate.get(3).size, pancakePlate.getPlate().get(3).getSize());
    }

    @Test
     void sortPancakePlateTest(){
        //This methods tests if the index of the biggest pancake is not on the bottom already (pancakePlate.getPlate.getSize());
        //4 is the 5th and last element in the Stack (Size = 14)
        Assertions.assertNotEquals(4, pancakePlate.returnTheBiggestPancake(pancakePlate.getPlate().size()) );

        //After this we can the biggest pancake on the bottom
        pancakePlate.putTheBiggestPancakeAtTheBottom(1, 5);
        System.out.println(pancakePlate.getPlate());
        //Now we check if the last pancake is equal to the biggest pancake (size 20)
        Assertions.assertEquals(20, pancakePlate.getPlate().get(4).size);

    }

    @Test
     void sortPancakePlateTestViaMethod(){
        //Here we still assert that the biggest pancake is NOT at the bottom of the plate
        Assertions.assertNotEquals(4, pancakePlate.returnTheBiggestPancake(pancakePlate.getPlate().size()));

        //Now we use the sorting method which does the same as above but repeatedly untill it is sorted
        pancakePlate.sortPancakePlate(pancakePlate.getPlate().size());

        //After calling the sortPancakePlate function we check is the whole plate has been sorted
        Assertions.assertEquals(20, pancakePlate.getPlate().get(4).size);
        Assertions.assertEquals(15, pancakePlate.getPlate().get(3).size);
        Assertions.assertEquals(14, pancakePlate.getPlate().get(2).size);
        Assertions.assertEquals(7, pancakePlate.getPlate().get(1).size);
        Assertions.assertEquals(1, pancakePlate.getPlate().get(0).size);

    }


}

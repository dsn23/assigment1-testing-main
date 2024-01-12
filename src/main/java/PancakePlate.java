import java.util.Collections;
import java.util.Stack;

public class PancakePlate extends Stack<Pancake> {

    transient Stack<Pancake> plate;

    PancakePlate() {
        this.plate = new Stack<>();
    }

    void addPancakesToPlate() {
        plate.push(new Pancake(15));
        plate.push(new Pancake(20));
        plate.push(new Pancake(7));
        plate.push(new Pancake(1));
        plate.push(new Pancake(14));
    }

    int returnTheBiggestPancake(int position) {
        int temporaryBiggestIndex = 0;

        //Position is 5 thus equal to platesize
        for (int i = 0; i < position; i++) {
            //Check if temporaryBiggestIndexPancakeSize is bigger than the one we are going to check
            if (plate.get(temporaryBiggestIndex).size < getPlate().get(i).size) {
                //Returns 1 as size 1 = the second place
                temporaryBiggestIndex = i;
            }
        }
        //Returns 1 as size = 1 equals second place
        return temporaryBiggestIndex;
    }

    void sortPancakePlate(int position) {
        //Checks if the position is not the top
        if (position != 0) {
            //Return the index of the biggest pancake
            int biggestPancakeIndex = returnTheBiggestPancake(position);
            if (biggestPancakeIndex != position) {
                //Put the biggest pancake at the current lowest position
                putTheBiggestPancakeAtTheBottom(biggestPancakeIndex, position);
            }
            //Make the stack smaller by decreasing position and repeating process untill the top is reached
            sortPancakePlate(position - 1);
        }
    }

    void putTheBiggestPancakeAtTheBottom(int max, int position) {
        //Checks if the biggest pancake is not on top already
        if (max != 0) {
            //If it is not on top
            flipAndCombinePancakeStack(max);
        }
        //Make the stack smaller
        flipAndCombinePancakeStack(position - 1);
    }

    void flipAndCombinePancakeStack(int position) {
        //Stacks for the methods below:
        //Everything under the spatula
        Stack<Pancake> under = returnPancakesUnderSpatula(position);
        //Every pancake above the spatula
        Stack<Pancake> above = returnPancakesAboveSpatula(position);
        //Every pancake above the spatula but flipped using Collections.reverse
        Stack<Pancake> flipped = returnReversedPancakesAboveSpatula(above);

        //Because we 'split' the stack into 2 parts, we need to combine them again
        Stack<Pancake> combinedStack = new Stack<>();

        //For this we combine the ABOVE stack (which we turn into the flipped stack using the Collections.reverse method) and the UNDER stack together
        combinedStack.addAll(flipped);
        combinedStack.addAll(under);
        setPlate(combinedStack);
    }

    Stack<Pancake> returnPancakesAboveSpatula(int position) {
        Stack<Pancake> above = new Stack<>();
        //Every pancake from spatula to top
        for (int i = 0; i <= position; i++) {
            //Push every pancake above the spatula into the new Stack
            above.push(getPlate().get(i));
        }
        return above;
    }

    Stack<Pancake> returnPancakesUnderSpatula(int position) {
        //New stack of pancakes which holds all the pancakes under the spatula
        Stack<Pancake> underSpatula = new Stack<>();
        //+1 at pos because we want everything under the spatula and not the one at the spatula
        for (int i = position + 1; i < getPlate().size(); i++) {
            underSpatula.push(getPlate().get(i));
        }
        return underSpatula;
    }

    Stack<Pancake> returnReversedPancakesAboveSpatula(Stack<Pancake> above) {
        //Collections does the reverse for us!
        Collections.reverse(above);
        return above;
    }

    int returnTheSmallestSizedPancake() {
        int temporarySmallestIndex = 4;
        //Does the same as the returnBiggestPancake method but reversed and without position as we dont use this in our algorithm
        for (int i = 0; i < getPlate().size(); i++) {
            if (plate.get(temporarySmallestIndex).size > getPlate().get(i).size) {
                temporarySmallestIndex = i;
            }
        }
        return temporarySmallestIndex;
    }


    Stack<Pancake> getPlate() {
        return plate;
    }

    void setPlate(Stack<Pancake> plate) {
        this.plate = plate;
    }


//Override added because of Sonarqube
    @Override
    public synchronized boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public synchronized int hashCode() {
        return super.hashCode();
    }
}

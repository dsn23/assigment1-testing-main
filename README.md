## Student Information

First Name: Danny

Last Name: Nansink

Student number: 500821004

## Assignment 1

### 1. Git log

```
e57cf73x 2022-09-09     cleaned some smelly code according to Sonarqube
87a53e1x 2022-09-09     Sonarqube setup, test cleaning according to Sonarqube and plate is now transient
485febex 2022-09-09     sorting method added and the test sortPancakePlateTestViaMethodTest added
ca09a74x 2022-09-09     added a test to sortPancakePlateTest as a setup idea for the sorting
dd92dcax 2022-09-09     Test for returnBiggestSizedPancakeTest
9bfac6ax 2022-09-09     added tests for flippedpancakes and above spatula, sorting almost done
176ab2dx 2022-09-08     logic for reversing the pancakes above and under spatula
bce1ff8x 2022-09-08     changed returnedBiggestPancake for algoritm and added flipping logic
6191b67x 2022-09-08     returnBiggestPancakeTest method now uses the method from PancakePlate class after refactoring
9377be3x 2022-09-08     Pancakes are now added via Class rather than the testClass
5f77422x 2022-09-08     findTheBiggestSizedPancakeTest working
7f441c2x 2022-09-07     Added working test and methods for: pancakesCannotHaveSameSizeTest
4b2cea0x 2022-09-07     first test: generateRightAmountOfPancakesTest succeeded
ec0848ex 2022-09-07     first test: generateRightAmountOfPancakesTest failed
ee5cf2ex 2022-09-07     Initial commit

```

### 2. Sonarqube

A dated screenshot of the overview of the following  quality gates(https://docs.sonarqube.org/latest/user-guide/quality-gates/): Reliability, Security,Maintainability, Coverage and Duplications. Provide a short discussion of the results.

![](/images/SonarQube.png)  

Short discussion:
The reason why Maintainability is graded with a B is because I have 16 code smells. 14 of them are:
'Replace the synchronized class "Stack" by an unsynchronized one such as "Deque" '. I don't think i have to switch the stack
to a Deque and the other 2 code smells are 'Move this file to a named package'. 
The reason why I have not done that is because I have tried making a new package called 'classes' 
but IntelliJ told me that a lot of functions would not be accessible anymore and that is was not very smart to change it.
For the next time I will make a package first so that I can avoid that problem.

### 3. Test Driven Development

Your best test class code snippets with a rationale why the unit tests are “good” tests.  Provide a link to the Test class and the class under test in Git.

```java
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
```
For the first snippet I would like to say that it is a good test because for exmaple it only test 1 functionality. What could have been better is the hardcoded values when asserting. This was more of a way to show that after the flip, the pancakes and their sizes are not teh same as they were before. It could defenitely improve in terms of repeatability.

For the second snippet I would like to say that I was testing and implementing the rough idea of what the not-yet-existing method was going to look like. So first I make sure that the biggest pancake is not on the bottom already. Then we call another method which puts the pancake at the bottom by flipping. And because the data is hardcoded we know that the size of the biggest pancake is 20. This is a part of the later implemented method which does the sorting for the pancakes. Looking back at this snippet and knowing that some values are hardcoded, I could have atleast made a couple of values e.g: for the biggest sized pancake and the pancake at the first of last place for example. The reason for that is because it wouldd make it easier for me to make the code more repeatable.
```java
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

```

[PancakePlate.java](/src/main/java/PancakePlate.java)

[PancakeSortingTest.java](/src/test/java/PancakeSortingTest.java)

### 4. Code Reviews

Screenshots of the code reviews you have performed on code of another student as comments in Gitlab: Provide a link to the comments in Gitlab.

![](/images/snippet4-assignment1.png) 

[Link-to-comment](https://gitlab.fdmci.hva.nl/se-specialization-2022-1/ivse2/daniel-kumankumah/assignment_1/-/commit/e120ba8666a31454c6737905c2ee294e7f9fa49f#note_276740)

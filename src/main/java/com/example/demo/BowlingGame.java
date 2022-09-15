package com.example.demo;

public class BowlingGame {

    public static int[] getResult(int[] rolls) throws IllegalArgumentException
    {

        if (rolls.length!=21)
        {
            throw new IllegalArgumentException("Wrong rolls array size. Must be 21.");
        }

        int[] result = new int[10];
        for (int i=0; i<19; i+=2)
        {
            int firstRoll = rolls[i];
            int secondRoll = rolls[i+1];


            if (i != 18) {
                // Check rules
                if (firstRoll>10 || firstRoll<0 || secondRoll>10 || secondRoll<0 ||
                        (firstRoll == 10 && secondRoll !=0) ||
                        (firstRoll + secondRoll >10 ) )
                {
                    throw new IllegalArgumentException("Wrong rolls data. Please check the game rules");
                }
                // Normal Frame
                if (firstRoll == 10) {
                    result[i / 2] = rolls[i] + ((rolls[i + 2] < 10 )? (rolls[i + 2] + rolls[i + 3]) : (rolls[i + 2] + rolls[i + 4]));
                } else if (firstRoll + secondRoll == 10) {
                    result[i / 2] = rolls[i] + rolls[i + 1] + rolls[i + 2];
                } else {
                    result[i / 2] = rolls[i] + rolls[i + 1];
                }

                // Add result from previus step
                if (i!=0)
                {
                    result[i / 2] += result[(i / 2)-1];
                }
            }
            else {
                // Last Frame
                // Check rules
                int thridRoll = rolls[i+2];

                if (firstRoll>10 || firstRoll<0 || secondRoll>10 || secondRoll<0 || thridRoll>10 || thridRoll<0 ||
                        (firstRoll<10 && (firstRoll +  secondRoll) > 10) )
                {
                    throw new IllegalArgumentException("Wrong rolls data. Please check game rules");
                }
                    result[i / 2] = rolls[i] + rolls[i + 1] + rolls[i + 2] + result[(i / 2)-1];
               }
        }
        return result;
    }
}

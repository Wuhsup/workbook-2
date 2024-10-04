package com.pluralsight.highscore;

import java.util.Scanner;

public class Winner {

    public static void main(String[] args) {
        String alBrown;
        String concord;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter tonight's score for A.L. Brown");
        alBrown = userInput.nextLine();
        System.out.println("Please enter tonight's score for Concord High");
        concord = userInput.nextLine();

        int alBrownScore = Integer.parseInt(alBrown);
        int concordScore = Integer.parseInt(concord);

        if (alBrownScore > concordScore)
            System.out.println("A.L. Brown Won!");
        if (concordScore > alBrownScore)
            System.out.println("Concord Won!");
        if (alBrownScore == concordScore)
            System.out.println("TIE!");
    }

}

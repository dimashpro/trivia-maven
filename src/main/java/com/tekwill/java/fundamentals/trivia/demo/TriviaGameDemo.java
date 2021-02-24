package com.tekwill.java.fundamentals.trivia.demo;


import com.tekwill.java.fundamentals.trivia.engine.TriviaAdmin;
import com.tekwill.java.fundamentals.trivia.engine.TriviaGame;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class TriviaGameDemo {
    public static void main(String[] args) {
        log.info("Game is loading up...");
        Scanner scanner = new Scanner(System.in);
        boolean gameMenuRunning = true;
        do {
            System.out.println("Enter [START] to start the game or [EXIT] to quit...");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("START")) {
                new TriviaGame().startGame();
            } else if (response.equalsIgnoreCase("ADMIN")) {
                new TriviaAdmin().start();
            } else if (response.equalsIgnoreCase("EXIT")) {
                System.out.println("Bye, bye!");
                gameMenuRunning = false;
            } else {
                System.out.println("Enter [START] to start the game or [EXIT] to quit...");
            }

        } while (gameMenuRunning);
        log.info("Game shutdown...");

    }
}

package ru.artempugachev.jokes;

import java.util.Random;

public class JokeGenerator {
    private String[] jokes = {"Can a kangaroo jump higher than a house? \n" +
            "-\n" +
            "Of course, a house doesn’t jump at all.\n",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "What is the difference between a snowman and a snowwoman?\n" +
                    "-\n" +
                    "Snowballs.\n"
            };
    public String getJoke() {
        int jokesSize = jokes.length;
        int jokeIndex = new Random().nextInt(jokesSize);
        return jokes[jokeIndex];
    }
}

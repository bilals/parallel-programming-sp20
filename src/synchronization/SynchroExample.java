/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronization;

/**
 *
 * @author Bilal
 */
public class SynchroExample {

    private void launch() throws InterruptedException {
        final ScoreKeeper scoreKeeper = new ScoreKeeper();
        ScoreIncrementer[] scoreIncrementers = new ScoreIncrementer[2];
        for (int i = 0; i < scoreIncrementers.length; i++) {
            scoreIncrementers[i] = new ScoreIncrementer(scoreKeeper);
            scoreIncrementers[i].start();
        }

        for (ScoreIncrementer scoreIncrementer : scoreIncrementers) {
            scoreIncrementer.join();
        }
        System.out.println("Score is: " + scoreKeeper.getScore());
    }

    private class ScoreKeeper {

        int _score = 0;

        void score(int v) {
            System.out.println("Before adding, score = " + _score);
            int tmp = _score;
            System.out.println("Adding v = " + v + " to score = " + _score);
            tmp += v;
            _score = tmp;
            System.out.println("After adding, score = " + _score);
        }

        int getScore() {
            return _score;
        }
    }

    private class ScoreIncrementer extends Thread {

        private final ScoreKeeper scoreKeeper;

        private ScoreIncrementer(ScoreKeeper scoreKeeper) {
            this.scoreKeeper = scoreKeeper;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                scoreKeeper.score(1);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new SynchroExample().launch();
    }

}

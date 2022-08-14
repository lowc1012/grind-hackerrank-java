// java-comparator (https://www.hackerrank.com/challenges/java-comparator/problem)

// Comparators are used to compare two objects. In this challenge, you'll create
// a comparator and use it to sort an array.

// The Player class is provided for you in your editor. It has fields: a String and a integer.
// Given an array of  Player objects, write a comparator that sorts them in order of decreasing
// score; if or more players have the same score, sort those players alphabetically by name. 
// To do this, you must create a Checker class that implements the Comparator interface, then write
// an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.

import java.util.*;

// Write your Checker class here

/**
 * Checker class implementin Comparatoer interface
 */
class Checker implements Comparator<Player> {

    // Compares its two arguments for order.
    // Returns a negative integer, zero, or a positive integer
    // as the first argument is less than, equal to, or greater
    // than the second.
    public int compare(Player a, Player b) {
        if (b.score == a.score) {
            return a.name.compareTo(b.name);
        }

        return (b.score - a.score);
    }

}

class Player {
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class JavaComparatorSolution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
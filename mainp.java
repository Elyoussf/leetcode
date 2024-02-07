import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character, Integer> frequency = new HashMap<>();
        Queue<Pair> arranged = new PriorityQueue<>(Comparator.comparingInt(Pair::getSecond).reversed());
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        for (char c : frequency.keySet()) {
            Pair t = new Pair(c, frequency.get(c));
            arranged.offer(t);
        }

        StringBuilder afterTr = new StringBuilder();
        while (!arranged.isEmpty()) {
            Pair pair = arranged.poll();
            afterTr.append(writeItdown(pair.getFirst(), pair.getSecond()));
        }
        return afterTr.toString();
    }

    public static String writeItdown(char c, int i) {
        StringBuilder q = new StringBuilder();
        while (i != 0) {
            q.append(c);
            i--;
        }
        return q.toString();
    }
}

class Pair {
    private char first;
    private int second;

    public Pair(char first, int second) {
        this.first = first;
        this.second = second;
    }

    public char getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }
}

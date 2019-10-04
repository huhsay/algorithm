package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> map = new HashMap<>();
        String temp;
        for (int i = 0; i < genres.length; i++) {
            temp = genres[i];
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + plays[i]);
            } else {
                map.put(temp, plays[i]);
            }
        }

        PriorityQueue<Genres> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        Iterator<String> iterator = map.keySet().iterator();

        String key;
        while(iterator.hasNext()) {
            key = iterator.next();
            queue.add(new Genres(key, map.get(key)));
        }

        Genres genres1;
        PriorityQueue<Music> musicQueue = new PriorityQueue<>(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                if( o2.playCount - o1.playCount > 0) { return 1; }
                else if( o2.playCount == o1.playCount) { return  o1.number - o2.number;}
                else { return -1;}
            }
        });
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            genres1 = queue.poll();
            temp = genres1.genres;

            for (int i = 0; i < genres.length; i++) {
                if( genres[i].equals(temp) ) {
                    musicQueue.add(new Music(i, plays[i]));
                }
            }

            int count = 0;
            while (!musicQueue.isEmpty()) {
                if(count > 1) {
                    musicQueue.clear();
                    break;
                }
                list.add(musicQueue.poll().number);
                count++;
            }
        }

        return listToArray(list);
    }

    private int[] listToArray(List<Integer> list){
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "t"};
        int[] plays = {1, 600, 1, 1, 2500, 1};
        BestAlbum bestAlbum = new BestAlbum();

        int[] answer = bestAlbum.solution(genres, plays);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}

class Genres {
    String genres;
    int count;

    public Genres(String genres, int count) {
        this.genres = genres;
        this.count = count;
    }
}

class Music {
    int number;
    int playCount;

    public Music(int number, int palyCount) {
        this.number = number;
        this.playCount = palyCount;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int numberOfSongs = Integer.parseInt(sc.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] data = sc.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song(type, name, time);
            songs.add(song);
        }

        String typeList = sc.nextLine();

        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(typeList)) {
                    System.out.println(song.getName());
                }
            }
        }

        List<Song> filterSong = songs.stream().filter(e -> e.getTypeList().equals(typeList)).collect(Collectors.toList());

        for (Song song : filterSong) {
            System.out.println(song.getName());
        }
    }
}
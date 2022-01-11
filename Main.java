import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\t\t\t\t*****Symphony*****");
        System.out.println("\t\t\t\tbring music to life...");
        //linked list for various albums/playlist in the MusicPlayer
        LinkedList<Album> albums=new LinkedList<>();
        ALbumInfo ai=new ALbumInfo();
        
        albums.add(new Album("Podcasts",1));
        albums.get(0).s.add(new Song("The Ranveer Show", 60, "Ranveer Allahbadia", 1));
        albums.get(0).s.add(new Song("On purpose with Jay Shetty", 30, "Jay Shetty", 2));
        albums.get(0).s.add(new Song("On cup Confidence", 70, "RJ Sha", 3));
        albums.get(0).s.add(new Song("Woice with Warikoo", 90, "Ankur Warikoo", 4));

        albums.add(new Album("New Releases",2));
        albums.get(1).s.add(new Song("Skylight", 4, "Gabrielle Aplin", 1));
        albums.get(1).s.add(new Song("Happy Christmas", 3, "Stu Larsen", 2));
        albums.get(1).s.add(new Song("Dreams come true", 5, "aespa", 3));
        albums.get(1).s.add(new Song("vivienne", 3, "tiffi", 4));

        albums.add(new Album("Devotional",3));
        albums.get(2).s.add(new Song("Gayatri Mantra", 8, "Jagjit Singh", 1));
        albums.get(2).s.add(new Song("Aham Brahmasmi", 11, "By Meditative Mind", 2));
        albums.get(2).s.add(new Song("Tilak Mantra", 2, "Ravindra Sathe",3));
        albums.get(2).s.add(new Song("Kar Darshanam", 1, "Sadhana Sargam", 4));
        
        albums.add(new Album("Party Songs",4));
        albums.get(3).s.add(new Song("NightLight", 5, "Loren Gray", 1));
        albums.get(3).s.add(new Song("Life goes on", 4, "Alex Hosking", 2));
        albums.get(3).s.add(new Song("U.", 3, "Coco & Breezy", 3));
        albums.get(3).s.add(new Song("We're Still Young", 4, "Olivia Penalva", 4));
        System.out.println("\nAll genres Playlists: ");
        System.out.println("1. Podcasts\t\t2. New Releases\t\t3. Devotional\t\t4. Party Songs\n");
        do{
           
            System.out.println("\n------------------------MENU-----------------------");
            System.out.println("\n\t\t1- Create new Playlist for you\n\t\t2- Display all Playlists\n\t\t3- Add songs to the playlist\n\t\t4- Play the playlist\n\t\t5- Delete Song\n\t\t6- Delete Playlist");
            System.out.println("Enter your choice: ");
            switch (sc.nextInt()){
                case 1:{
                	//create playlist
                    ai.createAlbum(albums);
                   
                    break;
                }
                case 2:{
                	//display albums/playlist created by the user
                    ai.diplayalbumName(albums);
                    break;
                }
                case 3:{
                	//add song in the playlist
                	  ai.addSong(albums);
                      break;
                   
                }
                case 4:{
                	//play songs in the playlist/album
                	 ai.albumplay(albums);
                     break;
                }
                case 5:{
                	//delete songs in the playlist/album
                	 ai.deleteSong(albums);
                     break;
                }
                case 6:{
                	//delete plSaylist/album
                	 ai.diplayalbumName(albums);
                	 ai.deleteAlbum(albums);
                     break;
                }
            }
            System.out.println("Do you want to continue your music therapy?\nif yes press 1 :) else press 0 :(");
        }while (sc.nextInt()==1);
        System.out.println("SEE YOU AGAIN!\nHere to change your mood anytime you want!");
    }
}

package com.Music_Player_Project;


import java.util.*;

public class Main_class {
    //creating a list of albums
    public static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args){
        printMenu(); //printing available option for user
      //creating object of Album class
        Album album = new Album("Album1","One Direction");
        //adding song to the album1
        album.addSong(" Steal my girl ",2.5);
        album.addSong(" Highway to hell ",3.5);
        album.addSong(" Beautiful ",4.5);
        album.addSong(" Night changes ",2.0);
        album.addSong(" Forever ",3.0);
        //adding the album1 to the list
        albums.add(album);

        // creating another album
        album = new Album("Album2","Arijit Singh") ;
        album.addSong("Agar tum saath ho " , 3.0);
        album.addSong("Tum hi ho" , 4.0);
        album.addSong(" Suraj duba h" , 3.0);
        album.addSong(" Uska hi banana " , 2.0);
        //adding album2 to the the list
        albums.add(album);

        //creating a linked list of playlist that will consist the song from these albums to keep track of the songs suffle
        LinkedList<Song> playlist_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Highway to hell" ,playlist_1);   //albums.get(0)--> it's albums1 songs
        albums.get(0).addToPlayList("Suraj duba h " ,playlist_1);
        albums.get(1).addToPlayList("Tum hi ho " ,playlist_1);      //albums.get(1)--> it's album2 songs
        albums.get(1).addToPlayList("Agar tum saath ho  " ,playlist_1);
        play(playlist_1);
    }
    //creating play method for playing the playlist
    public static void play(LinkedList<Song> playList)  {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size()==0){  //checking for playlist is empty or not if not then print the current song
            System.out.println("Playlist has no songs ");
        }
        else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){  // if user havn't quit yet perform these operation
            int action = sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0 : // instantly quit
                    System.out.println("PlayList complete ");
                    quit = true;
                    break;
                case 1 : //play next song
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();  //calling next() method created earlier
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }
                    else{
                        System.out.println("We are at end of the list");  //if list iterator has no next
                        forward=false;
                    }
                    break;

                case 2 : //play previous song
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){ //printing the previous song
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }
                    else{
                        System.out.println("there is no previous song  we are at the first song"); //if the listIterator is at first position so there is no previous song
                        forward = false;
                    }
                    break;

                case 3: //replay the current song
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing" + listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing" + listIterator.next().toString());
                            forward=true;
                        }
                        else{
                            System.out.println("we have reached to the end of the list");
                        }
                    }
                    break;

                case 4 : //list all song for this i have already created a method so just calling it
                    printList(playList);
                    break;

                case 5 : //print all the available option for user (created a method for this just calling it )
                      printMenu();
                      break;

                case 6 : //remove the current song which is being played
                    if(playList.size()>0){  //checking if playlist size is greater then only we can delete the song
                        listIterator.remove(); //removing the current song and in addition to that we to play the next song

                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }
                    }
                    break;
            }

        }

    }

    //User Interaction
    public static void printMenu(){
        System.out.println("Available options for you :)");
        System.out.println("0---> to quit \n" +
                "1---> to play next song \n" +
                "2---> to play previous song \n" +
                "3--->to replay current song \n " +
                "4---> list all the songs \n "+
                "5--->print all available options \n" +
                "6--->delete current song ");
    }
    //method to print the list
    public static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();  // it iterate over the playlist
        System.out.println("-----------------------------------------------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------------------------------------------");


    }

}

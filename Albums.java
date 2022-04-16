package com.Music_Player_Project;
import java.util.ArrayList;
import java.util.LinkedList;
public class Album {
    private String name ; //album name
    private String artist;
    private ArrayList<Song>  songs;  //list of songs the album consist

    //constructor
    public Album(String name , String artist ){
        this.name = name ;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    //empty constructor
    public Album(){ }

    //Functionalities of album

    //checking if the song already exist in the album before adding it to album or not
    public Song findSong(String title){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    //1- add song to album
    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            songs.add(new Song(title,duration));
          //  System.out.println(title + "successfully added to the list ");
            return true ;
        }
        else{
         //   System.out.println("Song with name " + title + "already exist" );
            return false;
        }
    }
    //2-add song to playlist(this song must be present in our list so that we can add it to playlist)
    //track number to keep the count of the song trackNumber starts from 1 but index start form 0 so we need
    //to do track number-1;
    //Linked list is used to keep the track of songs in playlist
    public boolean addToPlayList(int trackNumber,LinkedList<Song> PlayList){
        int index = trackNumber-1;
        if(index>0 && index<=this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
     //   System.out.println("Album does not have song with trackNumber" + trackNumber);
        return false;
    }
    //Functionality -3
    //giving option to add song to playlist with the title of song
    public boolean addToPlayList(String title , LinkedList<Song> PlayList){
        //checking if the song exist in album or not
        for(Song checkedSong:this.songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
       // System.out.println(title + " there is no such song in album ");
        return false;
    }
}

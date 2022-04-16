package com.Music_Player_Project;

public class Song {
    String title;       //music name
    double duration;    //music duration

    //constructor
    public Song(String title , double duration){
        this.title = title ;
        this.duration = duration;
    }
    //empty constructor
    public Song(){
    }
    //getter method
    public String getTitle(){

        return title;
    }
    public double getDuration(){

        return duration;
    }
 //to string method (used to return the property of class)
    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}

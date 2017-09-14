package com.spring.aop;

import java.util.List;

public class BlankDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public String getTitle() {
        return this.title;
    }

    public void setTitle( final String title ) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist( final String artist ) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return this.tracks;
    }

    public void setTracks( final List<String> tracks ) {
        this.tracks = tracks;
    }

    public void play() {
        System.out.println( "Playing " + this.title + " by " + this.artist );
        for ( final String track : this.tracks ) {
            System.out.println( "-Track: " + track );
        }
    }
}

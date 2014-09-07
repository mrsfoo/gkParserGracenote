package com.zwb.geekology.parser.gracenote.junit;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import radams.gracenote.webapi.GracenoteException;
import radams.gracenote.webapi.GracenoteMetadata;
import radams.gracenote.webapi.GracenoteWebAPI;

public class APITest extends TestCase
{
	public void testAPI()
	{
        try
        {
        	String clientID = "16564480";
        	String clientTag = "802AFC41FA868FC02C110C0D4CF0BE88";
            GracenoteWebAPI api = new GracenoteWebAPI(clientID, clientTag); // If you have a userID, you can specify it as the third parameter to constructor.
            String userID = api.register();
            System.out.println("UserID = " + userID);

            Set<String> keys = new HashSet<>();
            
            // Once you have the userID, you can search for tracks, artists or albums easily.
            System.out.println("Search Track:");
            GracenoteMetadata results = api.searchTrack("Moby", "Play", "Porcelin");
            for(int i=0; i<results.getAlbums().size(); i++)
            {
        	System.out.println("* album: "+results.getAlbum(i));
        	keys.addAll(results.getAlbum(i).keySet());
            }
//            results.print();

            System.out.println("Search Artist:");
            results = api.searchArtist("Moby");
            for(int i=0; i<results.getAlbums().size(); i++)
            {
        	System.out.println("* album: "+results.getAlbum(i));
        	keys.addAll(results.getAlbum(i).keySet());
            }
//            results.print();

            System.out.println("Search Album:");
            results = api.searchAlbum("Moby", "Play");
            for(int i=0; i<results.getAlbums().size(); i++)
            {
        	System.out.println("* album: "+results.getAlbum(i));
        	keys.addAll(results.getAlbum(i).keySet());
            }
//            results.print();

            System.out.println("Fetch Album:");
            results = api.fetchAlbum("97474325-8C600076B380712C6D1C5DC5DC5674F1");
            for(int i=0; i<results.getAlbums().size(); i++)
            {
        	System.out.println("* album: "+results.getAlbum(i));
        	keys.addAll(results.getAlbum(i).keySet());
            }
//            results.print();
            
            System.out.println("KEYS:");
            for(String k: keys)
            {
        	System.out.println("public static final String "+k.toUpperCase()+" = "+k);
            }
        }
        catch (GracenoteException e)
        {
            e.printStackTrace();
        }

	}

}

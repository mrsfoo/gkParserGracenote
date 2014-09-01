package com.zwb.geekology.parser.gracenote.junit;

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

            // Once you have the userID, you can search for tracks, artists or albums easily.
            System.out.println("Search Track:");
            GracenoteMetadata results = api.searchTrack("Moby", "Play", "Porcelin");
            results.print();

            System.out.println("Search Artist:");
            results = api.searchArtist("Moby");
            results.print();

            System.out.println("Search Album:");
            results = api.searchAlbum("Moby", "Play");
            results.print();

            System.out.println("Fetch Album:");
            results = api.fetchAlbum("97474325-8C600076B380712C6D1C5DC5DC5674F1");
            results.print();
        }
        catch (GracenoteException e)
        {
            e.printStackTrace();
        }

	}

}

package com.zwb.geekology.parser.gracenote.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;
import radams.gracenote.webapi.GracenoteException;
import radams.gracenote.webapi.GracenoteMetadata;
import radams.gracenote.webapi.GracenoteWebAPI;

import com.zwb.geekology.parser.gracenote.impl.util.GracenoteKeys;
import com.zwb.geekology.parser.gracenote.impl.util.MetadataList;
import com.zwb.tab.Tab;

public class APITest extends TestCase
{
    GracenoteWebAPI api;
    
    public void setUp() throws GracenoteException
    {
	String clientID = "16564480";
	String clientTag = "802AFC41FA868FC02C110C0D4CF0BE88";
	api = new GracenoteWebAPI(clientID, clientTag);
	
	String userID = api.register();
	System.out.println("UserID = " + userID);
    }
    
    public void collectKeys()
    {
	Set<String> keys = new HashSet<>();
	
	// Once you have the userID, you can search for tracks, artists or
	// albums easily.
	GracenoteMetadata results = api.searchTrack("Moby", "Play", "Porcelin");
	for (int i = 0; i < results.getAlbums().size(); i++)
	{
	    keys.addAll(results.getAlbum(i).keySet());
	}
	
	results = api.searchArtist("Moby");
	for (int i = 0; i < results.getAlbums().size(); i++)
	{
	    keys.addAll(results.getAlbum(i).keySet());
	}
	
	results = api.searchAlbum("Moby", "Play");
	for (int i = 0; i < results.getAlbums().size(); i++)
	{
	    keys.addAll(results.getAlbum(i).keySet());
	}
	
	results = api.fetchAlbum("97474325-8C600076B380712C6D1C5DC5DC5674F1");
	for (int i = 0; i < results.getAlbums().size(); i++)
	{
	    keys.addAll(results.getAlbum(i).keySet());
	}
	
	List<String> keyList = new ArrayList<>(keys);
	Collections.sort(keyList);
	for (String k : keyList)
	{
	    System.out.println("public static final String " + k.toUpperCase() + " = \"" + k + "\";");
	}
	System.out.println("public static final List<String> ALL = Arrays.asList(" + keyList.toString().toUpperCase() + ")");
    }
    
//    public void testAPI01()
//    {
//	System.out.println("Search Track:");
//	GracenoteMetadata results = api.searchTrack("Moby", "Play", "Porcelin");
//	results.print();
//	
//	System.out.println("Search Artist:");
//	results = api.searchArtist("Moby");
//	results.print();
//	
//	System.out.println("Search Album:");
//	results = api.searchAlbum("Moby", "Play");
//	results.print();
//	
//	System.out.println("Fetch Album:");
//	results = api.fetchAlbum("97474325-8C600076B380712C6D1C5DC5DC5674F1");
//	results.print();
//    }
//    
//    public void testAPI02()
//    {
//	System.out.println("Search Track:");
//	GracenoteMetadata results = api.searchTrack("Moby", "Play", "Porcelin");
//	printResults("Track: Moby,Play,Porcelin", results);
//	
//	System.out.println("Search Artist:");
//	results = api.searchArtist("Moby");
//	printResults("Artist: Moby", results);
//	
//	System.out.println("Search Album:");
//	results = api.searchAlbum("Moby", "Play");
//	printResults("Album: Moby,Play", results);
//	
//	System.out.println("Fetch Album:");
//	results = api.fetchAlbum("97474325-8C600076B380712C6D1C5DC5DC5674F1");
//	printResults("Fetch Album", results);
//    }
//    
//    public void testAPI03()
//    {
//	System.out.println("Search Track:");
//	GracenoteMetadata results = api.searchArtist("Moby");
//	Object o = results.getAlbumData(0, GracenoteKeys.MOOD);
//	System.out.println(o.getClass());
//	List<GracenoteMetadataOET> oetL = (List<GracenoteMetadataOET>) o;
//	for (GracenoteMetadataOET oet : oetL)
//	{
//	    System.out.println(oet.getID() + " -> " + oet.getText());
//	}
//    }
    
    private void printResults(String query, GracenoteMetadata results)
    {
	Tab tab = new Tab("results of query <" + query + ">", "result no.", "field", "key");
	for (int i = 0; i < results.getAlbums().size(); i++)
	{
	    String no = "" + i;
	    for (String key : GracenoteKeys.ALL)
	    {
		Object o = results.getAlbum(i).get(key);
		tab.addRow(no, key, GracenoteKeys.getStringValue(results.getAlbum(i), key));
		no = " ";
	    }
	}
	System.out.println(tab.printFormatted());
    }
    
    public void testAPI04()
    {
	List<String> rows = new ArrayList<>();
	rows.add("query");
	for (String s : GracenoteKeys.ALL)
	{
	    rows.add(s);
	}
	Tab tab = new Tab("", rows);
	
	String artist = "david bowie";
	List<String> albums = Arrays.asList("diamond dogs", "Alladin sane", "the rise and fall of ziggy staqrdust", "station to station", "low", "heroes");
	
	for (String a : albums)
	{
	    String query = "search for: "+artist+", "+a;
	    GracenoteMetadata gmd = api.searchAlbum(artist, a);
	    MetadataList results = new MetadataList(gmd);
	    gmd.print();
	    appendResult(tab, query, results);
	    
	}
	System.out.println(tab.printFormatted());
    }
    
    private Tab appendResult(Tab tab, String query, MetadataList m)
    {
	for (int i = 0; i < m.size(); i++)
	{
	    List<String> l = new ArrayList<>();
	    l.add("query_" + i);
	    for (String s : GracenoteKeys.ALL)
	    {
		l.add(m.get(i).getString(s));
	    }
	    tab.addRow(l);
	}
	return tab;
    }
}

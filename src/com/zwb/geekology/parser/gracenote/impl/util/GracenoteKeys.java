package com.zwb.geekology.parser.gracenote.impl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import radams.gracenote.webapi.GracenoteMetadataOET;

public class GracenoteKeys
{
    public static final String ALBUM_ARTIST_NAME = "album_artist_name";
    public static final String ALBUM_COVERART = "album_coverart";
    public static final String ALBUM_GNID = "album_gnid";
    public static final String ALBUM_TITLE = "album_title";
    public static final String ALBUM_YEAR = "album_year";
    public static final String ARTIST_BIO_URL = "artist_bio_url";
    public static final String ARTIST_ERA = "artist_era";
    public static final String ARTIST_IMAGE_URL = "artist_image_url";
    public static final String ARTIST_ORIGIN = "artist_origin";
    public static final String ARTIST_TYPE = "artist_type";
    public static final String GENRE = "genre";
    public static final String MOOD = "mood";
    public static final String REVIEW_URL = "review_url";
    public static final String TEMPO = "tempo";
    public static final String TRACK_ARTIST_NAME = "track_artist_name";
    public static final String TRACK_GN_ID = "track_gn_id";
    public static final String TRACK_NUMBER = "track_number";
    public static final String TRACK_TITLE = "track_title";
    
    // public static final List<String> ALL = Arrays.asList(ALBUM_ARTIST_NAME,
    // ALBUM_COVERART, ALBUM_GNID, ALBUM_TITLE, ALBUM_YEAR, ARTIST_BIO_URL,
    // ARTIST_ERA, ARTIST_IMAGE_URL, ARTIST_ORIGIN, ARTIST_TYPE, GENRE, MOOD,
    // REVIEW_URL, TEMPO, TRACK_ARTIST_NAME, TRACK_GN_ID, TRACK_NUMBER,
    // TRACK_TITLE);
    public static final List<String> ALL = Arrays.asList(ALBUM_ARTIST_NAME, TRACK_ARTIST_NAME, ARTIST_TYPE, ARTIST_ORIGIN, ARTIST_ERA, GENRE, MOOD, TEMPO, ALBUM_TITLE, ALBUM_YEAR, TRACK_NUMBER, TRACK_TITLE, ARTIST_BIO_URL, REVIEW_URL, ALBUM_GNID, TRACK_GN_ID, ALBUM_COVERART, ARTIST_IMAGE_URL);
    
    public static String getStringValue(Map<String, Object> dataItem, String key)
    {
	Object o = dataItem.get(key);
	if (o == null)
	{
	    return "";
	}
	else if (o.getClass().equals(String.class))
	{
	    return o.toString();
	}
	else if (o.getClass().equals(ArrayList.class))
	{
	    List<GracenoteMetadataOET> oetL = (List<GracenoteMetadataOET>) o;
	    List<String> l = new ArrayList<>();
	    for(GracenoteMetadataOET oet: oetL)
	    {
		l.add(oet.getText());
	    }
	    return l.toString();
	}
	else
	{
	    return "unknown class: " + o.getClass() + " -> " + o.toString();
	}
    }
}

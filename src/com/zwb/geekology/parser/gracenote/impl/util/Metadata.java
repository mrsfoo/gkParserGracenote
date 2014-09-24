package com.zwb.geekology.parser.gracenote.impl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import radams.gracenote.webapi.GracenoteMetadataOET;

import com.zwb.geekology.parser.api.exception.GkParserExceptionDataFormat;

public class Metadata
{
    Map<String, Object> data;
    
    public Metadata(Map<String, Object> data)
    {
	this.data = data;
    }
    
    public String getString(String key)
    {
	Object o = data.get(key);
	if (o == null)
	{
	    return null;
	}
	if (o.getClass().equals(ArrayList.class))
	{
	    return getStringList(key).toString();
	}
	return o.toString();
    }
    
    public List<String> getStringList(String key)
    {
	Object o = data.get(key);
	if (o == null)
	{
	    return null;
	}
	if (!o.getClass().equals(ArrayList.class))
	{
	    throw new GkParserExceptionDataFormat(null, "List<String> is illegal format for key: <" + key + ">");
	}
	List<GracenoteMetadataOET> oetL = (List<GracenoteMetadataOET>) o;
	List<String> l = new ArrayList<>();
	for (GracenoteMetadataOET oet : oetL)
	{
	    l.add(oet.getText());
	}
	return l;
    }
    
    public Map<String,String> getStringMap(String key)
    {
	Object o = data.get(key);
	if (o == null)
	{
	    return null;
	}
	if (!o.getClass().equals(ArrayList.class))
	{
	    throw new GkParserExceptionDataFormat(null, "Map<String,String> is illegal format for key: <" + key + ">");
	}
	List<GracenoteMetadataOET> oetL = (List<GracenoteMetadataOET>) o;
	Map<String,String> m = new HashMap<>();
	for (GracenoteMetadataOET oet : oetL)
	{
	    m.put(oet.getID(), oet.getText());
	}
	return m;
    }
    
}

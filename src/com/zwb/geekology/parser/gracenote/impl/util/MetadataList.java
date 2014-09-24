package com.zwb.geekology.parser.gracenote.impl.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import com.zwb.geekology.parser.gracenote.impl.util.Metadata;

import radams.gracenote.webapi.GracenoteMetadata;

public class MetadataList extends ArrayList<Metadata>
{
    private List<Metadata> delegate = new ArrayList<>();
    
    public MetadataList(GracenoteMetadata metaData)
    {
	ArrayList<Map<String, Object>> albums = metaData.getAlbums();
	for (Map<String, Object> m : albums)
	{
	    Metadata md = new Metadata(m);
	    this.delegate.add(md);
	}
    }
    
    public boolean add(Metadata e)
    {
	return this.delegate.add(e);
    }
    
    public void add(int index, Metadata element)
    {
	this.delegate.add(index, element);
    }
    
    public boolean addAll(Collection<? extends Metadata> c)
    {
	return this.delegate.addAll(c);
    }
    
    public boolean addAll(int index, Collection<? extends Metadata> c)
    {
	return this.delegate.addAll(index, c);
    }
    
    public void clear()
    {
	this.delegate.clear();
    }
    
    public boolean contains(Object o)
    {
	return this.delegate.contains(o);
    }
    
    public boolean containsAll(Collection<?> c)
    {
	return this.delegate.containsAll(c);
    }
    
    public Metadata get(int index)
    {
	return this.delegate.get(index);
    }
    
    public int indexOf(Object o)
    {
	return this.delegate.indexOf(o);
    }
    
    public boolean isEmpty()
    {
	return this.delegate.isEmpty();
    }
    
    public Iterator<Metadata> iterator()
    {
	return this.delegate.iterator();
    }
    
    public int lastIndexOf(Object o)
    {
	return this.delegate.lastIndexOf(o);
    }
    
    public ListIterator<Metadata> listIterator()
    {
	return this.delegate.listIterator();
    }
    
    public ListIterator<Metadata> listIterator(int index)
    {
	return this.delegate.listIterator(index);
    }
    
    public boolean remove(Object o)
    {
	return this.delegate.remove(o);
    }
    
    public Metadata remove(int index)
    {
	return this.delegate.remove(index);
    }
    
    public boolean removeAll(Collection<?> c)
    {
	return this.delegate.removeAll(c);
    }
    
    public boolean retainAll(Collection<?> c)
    {
	return this.delegate.retainAll(c);
    }
    
    public Metadata set(int index, Metadata element)
    {
	return this.delegate.set(index, element);
    }
    
    public int size()
    {
	return this.delegate.size();
    }
    
    public List<Metadata> subList(int fromIndex, int toIndex)
    {
	return this.delegate.subList(fromIndex, toIndex);
    }
    
    public Object[] toArray()
    {
	return this.delegate.toArray();
    }
    
    public <T> T[] toArray(T[] a)
    {
	return this.delegate.toArray(a);
    }
    
}

package com.oaktreeair.ffprogram;

import java.util.ArrayList;

public class Flier
{
	private String flierName;
	private Long flierID;

	private ContactInfo contactInfo;
	private AddressInfo homeAddress;

	public enum Level
	{
		Member, Gold, Platinum
	};

	private Level level;

	private ArrayList<Segment> segments = new ArrayList<Segment>();

	public AddressInfo getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(AddressInfo homeAddress)
	{
		this.homeAddress = homeAddress;
	}

	public void addSegment(Segment seg)
	{
		segments.add(seg);
	}

	public Level getLevel()
	{
		return level;
	}

	public void setLevel(Level level)
	{
		this.level = level;
	}

	public ArrayList<Segment> getSegments()
	{
		return segments;
	}

	public String getFlierName()
	{
		return flierName;
	}

	public void setFlierName(String flierName)
	{
		this.flierName = flierName;
	}

	public Long getFlierID()
	{
		return flierID;
	}

	public void setFlierID(Long flierID)
	{
		this.flierID = flierID;
	}

	public ContactInfo getContactInfo()
	{
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo)
	{
		this.contactInfo = contactInfo;
	}

}

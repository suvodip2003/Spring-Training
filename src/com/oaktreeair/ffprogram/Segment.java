package com.oaktreeair.ffprogram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Segment implements TempFileAware
{
	private Long segmentNumber;
	private Date segmentDate;
	private int flightNumber;
	private String originatingCity;
	private int miles;

	private File tempFile;
	private DocumentBuilder parser;

	@PostConstruct
	public void init()
	{
		try
		{
			Random rand = new Random();
			long randID = rand.nextLong();
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(
					tempFile));
			dos.writeLong(randID);
			dos.close();

			System.out.println("Parsing flights.xml");
			Document doc = parser.parse("flights.xml");
			StringBuilder sb = new StringBuilder();
			sb.append("/flights/flight[@flightNumber='");
			sb.append(flightNumber);
			sb.append("']/segments/segment[@startCity='");
			sb.append(originatingCity);
			sb.append("']/miles");
			String xpathStr = sb.toString();

			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xpath.compile(xpathStr);

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			Node node = nodes.item(0);
			miles = Integer.parseInt(node.getTextContent());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@PreDestroy
	public void destroy()
	{
		System.out.println("In destroy() method");
		tempFile.delete();
	}

	@Override
	public void setTempFile(File temp)
	{
		tempFile = temp;
	}

	public Long getSegmentNumber()
	{
		Long segNum = null;
		try
		{
			DataInputStream dis = new DataInputStream(new FileInputStream(
					tempFile));
			long val = dis.readLong();
			segNum = val;
			dis.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return segNum;
	}

	public void setSegmentNumber(Long segmentNumber)
	{
		this.segmentNumber = segmentNumber;
	}

	public DocumentBuilder getParser()
	{
		return parser;
	}

	public void setParser(DocumentBuilder parser)
	{
		this.parser = parser;
	}

	public Date getSegmentDate()
	{
		return segmentDate;
	}

	public void setSegmentDate(Date segmentDate)
	{
		this.segmentDate = segmentDate;
	}

	public int getFlightNumber()
	{
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber)
	{
		this.flightNumber = flightNumber;
	}

	public String getOriginatingCity()
	{
		return originatingCity;
	}

	public void setOriginatingCity(String originatingCity)
	{
		this.originatingCity = originatingCity;
	}

	public int getMiles()
	{
		return miles;
	}

	public void setMiles(int miles)
	{
		this.miles = miles;
	}

	@Override
	public String toString()
	{
		return "Segment [segmentNumber=" + segmentNumber + ", segmentDate="
				+ segmentDate + ", flightNumber=" + flightNumber
				+ ", originatingCity=" + originatingCity + ", miles=" + miles
				+ "]";
	}

}

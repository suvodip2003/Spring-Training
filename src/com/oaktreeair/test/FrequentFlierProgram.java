package com.oaktreeair.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oaktreeair.ffprogram.AddressInfo;
import com.oaktreeair.ffprogram.BonusCalc;
import com.oaktreeair.ffprogram.ContactInfo;
import com.oaktreeair.ffprogram.Flier;
import com.oaktreeair.ffprogram.Segment;

public class FrequentFlierProgram
{

    public static void main(String[] args)
    {
    	String[] files = {"src/spring.xml", "src/spring2.xml"};
        AbstractApplicationContext ctx = 
                new FileSystemXmlApplicationContext(files);
        
        Flier flier01 = (Flier)ctx.getBean("flier01");
        System.out.println(flier01.getFlierName());
        System.out.println(flier01.getFlierID());
        
        ContactInfo inf = flier01.getContactInfo();
        System.out.println(inf.getEmailAddress());

        flier01.setLevel(Flier.Level.Gold);
        Segment seg01 = (Segment)ctx.getBean("seg01");
        System.out.println(seg01.getMiles());
        System.out.println("Segment number: " + seg01.getSegmentNumber());
        System.out.println("Segment miles: " + seg01.getMiles());
        
        flier01.addSegment(seg01);
        
        BonusCalc bc = (BonusCalc)ctx.getBean("calcBonus");
        int bonus = bc.calcBonus(flier01, seg01);
        System.out.println(bonus);

        AddressInfo ai = flier01.getHomeAddress();
        System.out.println(ai);
        
        ctx.close();
    }

}

package com.oaktreeair.ffprogram;

import java.util.Collection;

public class BonusCalcImpl implements BonusCalc
{

    @Override
    public int calcBonus(Flier flier, Segment seg)
    {
        double bonus = 0;
        
        switch(flier.getLevel())
        {
            case Member:
                bonus = seg.getMiles() * 0.10;
                break;
            case Gold:
                bonus = seg.getMiles() * 0.25;
                break;
            case Platinum:
                bonus = seg.getMiles() * 0.50;
                break;
        }
        
        return (int)bonus;
    }

    @Override
    public int calcBonus(Flier flier, Collection<Segment> segments)
    {
        double bonus = 0;        
        Flier.Level level = flier.getLevel();
        
        for(Segment seg : segments)
        {
            switch(level)
            {
                case Member:
                    bonus += seg.getMiles() * 0.10;
                    break;
                case Gold:
                    bonus += seg.getMiles() * 0.25;
                    break;
                case Platinum:
                    bonus += seg.getMiles() * 0.50;
                    break;
            }            
        }
        
        return (int)bonus;
    }

}

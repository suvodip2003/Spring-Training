package com.oaktreeair.ffprogram;

import java.util.Collection;

public interface BonusCalc
{
    public int calcBonus(Flier flier, Segment seg);
    public int calcBonus(Flier flier, Collection<Segment> segments);
}

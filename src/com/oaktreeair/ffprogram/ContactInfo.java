package com.oaktreeair.ffprogram;



public class ContactInfo
{
    private String emailAddress;
    private String homePhone;
    private String mobilePhone;
    private String smsNumber;

    public String getEmailAddress()
    {
        return emailAddress;
    }

//    @Required
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getHomePhone()
    {
        return homePhone;
    }

//    @Required
    public void setHomePhone(String homePhone)
    {
        this.homePhone = homePhone;
    }

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }

    public String getSmsNumber()
    {
        return smsNumber;
    }

    public void setSmsNumber(String smsNumber)
    {
        this.smsNumber = smsNumber;
    }

    @Override
    public String toString()
    {
        return "ContactInfo [emailAddress=" + emailAddress + ", homePhone="
                + homePhone + ", mobilePhone=" + mobilePhone + ", smsNumber="
                + smsNumber + "]";
    }

}

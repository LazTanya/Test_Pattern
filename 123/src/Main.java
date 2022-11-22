class DesignCompany{
    public static AbstractDesignCompany createStudia(String designType)
    {
        switch (designType)
        {
            case "Flat":
                return new FlatMake();
            case "Office":
                return new OfficeMake();
            default:
                return null;
        }
    }
}

interface AbstractDesignCompany
{
    Design makeDesign(String typeD, String style, int price);
}

class FlatMake implements AbstractDesignCompany
{
    @Override
    public Design makeDesign(String typeD, String style, int price)
    {
        Flat newFlat;
        switch (typeD)
        {
            case "Livingroom":
                newFlat = new Livingroom(style, price);
                break;
            case "Bedroom":
                newFlat = new Bedroom(style, price);
                break;
            default:
                newFlat = null;
        }
        if(newFlat != null)
            newFlat.canBeFinishedInOneMonth = true;

        return newFlat;
    }
}

class OfficeMake implements AbstractDesignCompany
{
    @Override
    public Design makeDesign(String type, String style, int price)
    {
        Office newOffice;
        switch (type)
        {
            case "Big Office":
                newOffice = new BigOffice(style, price);
                break;
            case "Small Office":
                newOffice = new SmallOffice(style, price);
                break;
            default:
                newOffice = null;
        }
        if(newOffice != null)
            newOffice.canBeFinishedInOneMonth = false;

        return newOffice;
    }
}

abstract class Design
{
    protected String style;
    protected int price;
    protected Boolean canBeFinishedInOneMonth;

    public Design(String style, int price)
    {
        this.style = style;
        this.price = price;
    }
    public abstract void plandesign();
}

abstract class Flat extends Design
{
    public Flat(String style, int price)
    {
        super(style, price);
        System.out.println("making flat");
    }
}


abstract class Office extends Design
{
    public Office(String style, int price)
    {
        super(style, price);
        System.out.println("making office");
    }
}

class Bedroom extends Flat
{
    public Bedroom(String style, int price)
    {
        super(style, price);
    }
    @Override
    public void plandesign()
    {
        System.out.println("Making " + style + " flat");
    }
}

class Livingroom extends Flat
{
    public Livingroom(String style, int price)
    {
        super(style, price);
    }
    @Override
    public void plandesign()
    {
        System.out.println("Making " + style + " flat");
    }
}

class BigOffice extends Office
{
    public BigOffice(String style, int price)
    {
        super(style, price);
    }
    @Override
    public void plandesign()
    {
        System.out.println("Making " + style + " office");
    }
}

class SmallOffice extends Office
{
    public SmallOffice(String style, int price)
    {
        super(style, price);
    }
    @Override
    public void plandesign()
    {
        System.out.println("Making " + style + " office");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        AbstractDesignCompany makeDesignn = DesignCompany.createStudia("Flat");
        if(makeDesignn != null)
        {
            Design newLivingroom = makeDesignn.makeDesign("Livingroom", "modern", 3500);
            newLivingroom.plandesign();
        }
    }
}
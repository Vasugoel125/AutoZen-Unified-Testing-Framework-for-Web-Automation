package Properties;

import org.aeonbits.owner.ConfigFactory;

public class PropertyReaderWithOwner
{
    public static void main(String[] args)
    {
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
        System.out.println(config.username());
        System.out.println(config.password());
        //System.out.println(config.tools());
        System.out.println(config.timeout()+50);
    }
}

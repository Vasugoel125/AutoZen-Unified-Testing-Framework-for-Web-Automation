package Properties;

import org.aeonbits.owner.Config;

//@Config.Sources(value ="file:/Users/vgoel/IdeaProjects/Vasu_Goel_Maven/config.properties")
@Config.Sources(value = "file:${user.dir}/config.properties")
public interface FrameworkConfig extends Config
{
    String username();
    String password();
    int timeout();
    String[] tools();
}

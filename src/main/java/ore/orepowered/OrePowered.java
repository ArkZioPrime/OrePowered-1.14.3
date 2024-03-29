package ore.orepowered;

import net.minecraftforge.fml.relauncher.ServerLaunchWrapper;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class OrePowered implements Runnable{

    public static Logger LOGGER;
    public static ResourceBundle rb;
    private static String[] args;
    private static final String NAME = "OrePowered";
    private static final String VERSION = "0.0.1";
    private static final String NATIVE_VERSON = "v1_14_R1";
    private static final String NMS_PREFIX = "net/minecraft/server/";

    public static String getName(){
        return NAME;
    }

    public static String getVersion(){
        return VERSION;
    }

    public static String getNativeVersion() {
        return NATIVE_VERSON;
    }

    public static String getNmsPrefix()
    {
        return NMS_PREFIX;
    }

    public static void main(String[] args){
        /*
        File f = new File("orepowered.yml");
        YamlConfiguration y;
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        y = YamlConfiguration.loadConfiguration(f);
        if(y.getString("locale") == null){
            y.set("locale","Default");
            try {
                y.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            y = YamlConfiguration.loadConfiguration(f);
        }
        switch (y.getString("locale")){
            default:
                rb = ResourceBundle.getBundle("assets.orepowered.lang.message", Locale.getDefault(), new UTF8Control());
            case "Default":
                rb = ResourceBundle.getBundle("assets.orepowered.lang.message", new Locale(y.getString("locale")), new UTF8Control());
            case "default":
                rb = ResourceBundle.getBundle("assets.orepowered.lang.message", new Locale(y.getString("locale")), new UTF8Control());
        }
        */
        OrePowered.args = args;
        Thread t = new Thread(new OrePowered(),"OrePowered");
        t.start();
    }

    @Override
    public void run() {
        new ServerLaunchWrapper().run(args);
    }

}

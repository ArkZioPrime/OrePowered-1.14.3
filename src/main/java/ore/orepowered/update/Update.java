package ore.orepowered.update;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ore.orepowered.OrePowered;
import ore.orepowered.down.Download;
import ore.orepowered.i18n.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Update implements Runnable{

    private static String pre = Message.getString(Message.OrePowered_update_program);

    public static boolean getUpdate(){
        JSONObject json = getJson();
        String version = json.getString("name");
        if(!version.equals(OrePowered.getVersion())) {
			OrePowered.LOGGER.info(pre + Message.getFormatString(Message.OrePowered_update_program_check_hasupdate,new Object[] {version,OrePowered.getVersion()}));
            //OrePowered.LOGGER.info(pre + "发现更新,最新版本号为: §7(§e" + version + "§7) §b目前版本为: §7(§e" + OrePowered.getVersion() + "§7)");
            return true;
        }
		OrePowered.LOGGER.info(pre + Message.getFormatString(Message.OrePowered_update_program_check_noupdate,new Object[] {version,OrePowered.getVersion()}));
        //OrePowered.LOGGER.info(pre + "没有发现更新,最新版本号为: §7(§e" + version + "§7) §b目前版本为: §7(§e" + OrePowered.getVersion() + "§7)");
        OrePowered.LOGGER.info(pre + Message.getString(Message.OrePowered_update_program_tips_stopautoget));
        return false;
    }

    public static void downloadUpdate() {
        JSONObject json = getJson();

        String version = json.getString("name");
        String releasesPeople = json.getJSONObject("author").getString("login");

        JSONArray ja = json.getJSONArray("assets");
        int size = ja.size();
        String releasesDate = json.getString("created_at").replaceAll("T","T ");
        String releasesMsg = json.getString("body");
        OrePowered.LOGGER.info(pre + "Total §e" + size + "§b Files");
        for (int i = 0;i < size;i++){
            OrePowered.LOGGER.info(pre + Message.getString(Message.Dw_Start));
            new Download(ja.getJSONObject(i).getString("browser_download_url"),"OrePowered-update.jar",true);
            OrePowered.LOGGER.info(pre + Message.getFormatString(Message.OrePowered_update_message,new Object[] {releasesMsg}));
            OrePowered.LOGGER.info(pre + Message.getFormatString(Message.OrePowered_update_date,new Object[] {releasesDate}));
        }


    }

    private static JSONObject getJson(){
        URL url = null;
        HttpURLConnection httpConn = null;
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try{
            url = new URL("https://api.github.com/repos/orecraft/OrePowered/releases/latest");
            in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8") );
            String str = null;
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            try{
                if(in!=null) {
                    in.close(); 
                }
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        String jsonText =sb.toString();
        return JSON.parseObject(jsonText);
    }

    @Override
    public void run() {
		/*
        if(OrePoweredConfig.config.getBoolean("update.autoget")){
            if(Update.getUpdate()){
                //OrePowered.LOGGER.info(pre + "将为您在后台下载更新...");
                if(!new File("OrePowered-update.jar").exists()){
                    Update.downloadUpdate();
                }
                OrePowered.LOGGER.info(pre + Message.getString(Message.OrePowered_update_program_tips_done));
            }
        }else
            OrePowered.LOGGER.info(pre + Message.getString(Message.OrePowered_update_program_tips_false));
		*/
    }
}

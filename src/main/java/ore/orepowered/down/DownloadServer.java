package ore.orepowered.down;

import ore.orepowered.i18n.Message;

import java.util.Locale;

public class DownloadServer implements Runnable {

    @Override
    public void run() {
        String url = "https://launcher.mojang.com/v1/objects/d0d0fe2b1dc6ab4c65554cb734270872b72dadd6/server.jar";
        //String url = "https://launcher.mojang.com/v1/objects/d0d0fe2b1dc6ab4c65554cb734270872b72dadd6/server.jar";
        Locale locale = Locale.getDefault();
        if (locale.getCountry().equals("zh_CN") || locale.getCountry().equals("CN") || locale.getCountry().equals("zh_TW") || locale.getCountry().equals("TW")) {
            url = "https://bmclapi2.bangbang93.com/version/1.14.3/server";
        }
        new Download(url,"minecraft_server.1.14.3.jar");
        System.out.println(Message.getFormatString(Message.Dw_Ok,new Object[] {"minecraft_server.1.14.3.jar"}));
        /*
        String url = "https://launcher.mojang.com/v1/objects/d0d0fe2b1dc6ab4c65554cb734270872b72dadd6/server.jar";
        String fileName = "minecraft_server.1.14.3.jar";
        Locale locale = Locale.getDefault();
        Object[] o1 = {fileName};
        System.out.println(Message.getFormatString(Message.Dw_File,o1));
        BufferedOutputStream bos = null;
        InputStream is = null;
        try {
            byte[] buff = new byte[8192];
            if (locale.getCountry().equals("CN")) {
                url = "https://bmclapi2.bangbang93.com/version/1.14.3/server";
            }
            is = new URL(url).openStream();
            File file = new File(".", fileName);
            file.getParentFile().mkdirs();
            bos = new BufferedOutputStream(new FileOutputStream(file));
            HttpURLConnection urlcon=(HttpURLConnection)new URL(url).openConnection();
            long l = urlcon.getContentLengthLong();
            urlcon.disconnect();
            int count = 0;
            System.out.println(Message.getString(Message.Dw_Start));
            while ( (count = is.read(buff)) != -1) {
                Object[] o = {fileName,file.length(),l};
                System.out.println(Message.getFormatString(Message.Dw_Now,o));
                bos.write(buff, 0, count);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        */

    }
}

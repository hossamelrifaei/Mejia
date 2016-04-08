package utlis;

/**
 * Created by Hossam on 4/6/2016.
 */
public class VimeoUrlEditor {
    public static String addVimeoPlayer(String url) {

        StringBuffer stringBuffer = new StringBuffer(url);
        if (!url.contains("player")) {
            stringBuffer.insert(8, "player.");
        }
        if (!url.contains("video")) {
            int index = stringBuffer.toString().lastIndexOf("com/");
            stringBuffer.insert(index + 4, "video/");
        }
        return stringBuffer.toString();
    }
}

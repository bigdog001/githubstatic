import javax.naming.NamingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.mycomm.YesHttp.core.HttpMethod;
import com.mycomm.YesHttp.core.JsonRequest;
import com.mycomm.YesHttp.core.Request;
import com.mycomm.YesHttp.core.Response;
import com.mycomm.YesHttp.core.StringRequest;
import com.mycomm.YesHttp.core.TextBaseResponseListener;
import com.mycomm.YesHttp.core.YesHttpEngine;
import com.mycomm.YesHttp.core.YesHttpError;


public class Main {
    public static void main(String[] args) throws NamingException {
        String textmsg = """
            <div class="audio-status">
            <audio id="audio-player-element" autoplay="autoplay" controls controlsList="nodownload">
                                            <source
                src="https://stream.biblegateway.com/bibles/32/niv-mclean/Gen.8.7dd98ef6fec3d9d5720d4bd76a5a02b3.mp3">
                          </audio>
            <div class="audio-status-timeline-wrapper">
              <div class="audio-status-time">0:00</div>
              <input type="range" id="slider" class="slider" name="slider"
        min="0" value="0" />
              <div class="audio-status-duration">0:00</div>
            </div>
          </div>
          """;
        Pattern p = Pattern.compile("src=\"(https://stream\\.biblegateway\\.com/bibles/\\d+/niv-mclean/[A-Za-z0-9._-]+\\.mp3)\"");
        Matcher m = p.matcher(textmsg);
        if (m.find()) {
            System.out.println("Matched URL: " + m.group(1));
        }
    }
}

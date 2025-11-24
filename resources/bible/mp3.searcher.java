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

 /** String mp3_1_url = "https://www.biblegateway.com/audio/mclean/niv/Gen.1-50";
         *  String mp3_2_url = "https://www.biblegateway.com/audio/mclean/niv/Exod.1-40";
         *  String mp3_3_url = "https://www.biblegateway.com/audio/mclean/niv/Lev.1-27";
         *  String mp3_4_url = "https://www.biblegateway.com/audio/mclean/niv/Num.1-36" ;
         *  String mp3_5_url = "https://www.biblegateway.com/audio/mclean/niv/Deut.1-34" ;
         *  String mp3_6_url = "https://www.biblegateway.com/audio/mclean/niv/Josh.1-24" ;
         *  String mp3_7_url = "https://www.biblegateway.com/audio/mclean/niv/Judg.1-21" ;
         *  String mp3_8_url = "https://www.biblegateway.com/audio/mclean/niv/Ruth.1-4" ;
         *  String mp3_9_url = "https://www.biblegateway.com/audio/mclean/niv/1Sam.1-31" ;
         *  String mp3_10_url = "https://www.biblegateway.com/audio/mclean/niv/2Sam.1-24" ;
         *  String mp3_11_url = "https://www.biblegateway.com/audio/mclean/niv/1Kgs.1-22" ;
         *  String mp3_12_url = "https://www.biblegateway.com/audio/mclean/niv/2Kgs.1-25" ;
         *  String mp3_13_url = "https://www.biblegateway.com/audio/mclean/niv/1Chr.1-29" ;
         *  String mp3_14_url = "https://www.biblegateway.com/audio/mclean/niv/2Chr.1-36" ;
         *  String mp3_15_url = "https://www.biblegateway.com/audio/mclean/niv/Ezra.1-10" ;
         *  String mp3_16_url = "https://www.biblegateway.com/audio/mclean/niv/Neh.1-13" ;
         *  String mp3_17_url = "https://www.biblegateway.com/audio/mclean/niv/Esth.1-10" ;
         *  String mp3_18_url = "https://www.biblegateway.com/audio/mclean/niv/Job.1-42" ;
         *  String mp3_19_url = "https://www.biblegateway.com/audio/mclean/niv/Ps.1-150" ;
         *  String mp3_20_url = "https://www.biblegateway.com/audio/mclean/niv/Prov.1-31" ;
         *  String mp3_21_url = "https://www.biblegateway.com/audio/mclean/niv/Eccl.1-12" ;
         *  String mp3_22_url = "https://www.biblegateway.com/audio/mclean/niv/Song.1-8" ;
         *  String mp3_23_url = "https://www.biblegateway.com/audio/mclean/niv/Isa.1-66" ;
         *  String mp3_24_url = "https://www.biblegateway.com/audio/mclean/niv/Jer.1-52" ;
         *  String mp3_25_url = "https://www.biblegateway.com/audio/mclean/niv/Lam.1-5" ;
         *  String mp3_26_url = "https://www.biblegateway.com/audio/mclean/niv/Ezek.1-48" ;
         *  String mp3_27_url = "https://www.biblegateway.com/audio/mclean/niv/Dan.1-12" ;
         *  String mp3_28_url = "https://www.biblegateway.com/audio/mclean/niv/Hos.1-14" ;
         *  String mp3_29_url = "https://www.biblegateway.com/audio/mclean/niv/Joel.1-3" ;
         *  String mp3_30_url = "https://www.biblegateway.com/audio/mclean/niv/Amos.1-9" ;
         *  String mp3_31_url = "https://www.biblegateway.com/audio/mclean/niv/Obad.1" ;
         *  String mp3_32_url = "https://www.biblegateway.com/audio/mclean/niv/Jonah.1-4" ;
         *  String mp3_33_url = "https://www.biblegateway.com/audio/mclean/niv/Mic.1-7" ;
         *  String mp3_34_url = "https://www.biblegateway.com/audio/mclean/niv/Nah.1-3" ;
         *  String mp3_35_url = "https://www.biblegateway.com/audio/mclean/niv/Hab.1-3" ;
         *  String mp3_36_url = "https://www.biblegateway.com/audio/mclean/niv/Zeph.1-3" ;
         *  String mp3_37_url = "https://www.biblegateway.com/audio/mclean/niv/Hag.1-2" ;
         *  String mp3_38_url = "https://www.biblegateway.com/audio/mclean/niv/Zech.1-14" ;
         *  String mp3_39_url = "https://www.biblegateway.com/audio/mclean/niv/Mal.1-4" ;
         *  String mp3_40_url = "https://www.biblegateway.com/audio/mclean/niv/Matt.1-28" ;
         *  String mp3_41_url = "https://www.biblegateway.com/audio/mclean/niv/Mark.1-16" ;
         *  String mp3_42_url = "https://www.biblegateway.com/audio/mclean/niv/Luke.1-24" ;
         *  String mp3_43_url = "https://www.biblegateway.com/audio/mclean/niv/John.1-21" ;
         *  String mp3_44_url = "https://www.biblegateway.com/audio/mclean/niv/Acts.1-28" ;
         *  String mp3_45_url = "https://www.biblegateway.com/audio/mclean/niv/Rom.1-16" ;
         *  String mp3_46_url = "https://www.biblegateway.com/audio/mclean/niv/1Cor.1-16" ;
         *  String mp3_47_url = "https://www.biblegateway.com/audio/mclean/niv/2Cor.1-13" ;
         *  String mp3_48_url = "https://www.biblegateway.com/audio/mclean/niv/Gal.1-6" ;
         *  String mp3_49_url = "https://www.biblegateway.com/audio/mclean/niv/Eph.1-6" ;
         *  String mp3_50_url = "https://www.biblegateway.com/audio/mclean/niv/Phil.1-4" ;
         *  String mp3_51_url = "https://www.biblegateway.com/audio/mclean/niv/Col.1-4" ;
         *  String mp3_52_url = "https://www.biblegateway.com/audio/mclean/niv/1Thess.1-5" ;
         *  String mp3_53_url = "https://www.biblegateway.com/audio/mclean/niv/2Thess.1-3" ;
         *  String mp3_54_url = "https://www.biblegateway.com/audio/mclean/niv/1Tim.1-6" ;
         *  String mp3_55_url = "https://www.biblegateway.com/audio/mclean/niv/2Tim.1-4" ;
         *  String mp3_56_url = "https://www.biblegateway.com/audio/mclean/niv/Titus.1-3" ;
         *  String mp3_57_url = "https://www.biblegateway.com/audio/mclean/niv/Phlm.1" ;
         *  String mp3_58_url = "https://www.biblegateway.com/audio/mclean/niv/Heb.1-13" ;
         *  String mp3_59_url = "https://www.biblegateway.com/audio/mclean/niv/Jas.1-5" ;
         *  String mp3_60_url = "https://www.biblegateway.com/audio/mclean/niv/1Pet.1-5" ;
         *  String mp3_61_url = "https://www.biblegateway.com/audio/mclean/niv/2Pet.1-3" ;
         *  String mp3_62_url = "https://www.biblegateway.com/audio/mclean/niv/1John.1-5" ;
         *  String mp3_63_url = "https://www.biblegateway.com/audio/mclean/niv/2John.1" ;
         *  String mp3_64_url = "https://www.biblegateway.com/audio/mclean/niv/3John.1" ;
         *  String mp3_65_url = "https://www.biblegateway.com/audio/mclean/niv/Jude.1" ;
         *  String mp3_66_url = "https://www.biblegateway.com/audio/mclean/niv/Rev.1-22"; ;
         */
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

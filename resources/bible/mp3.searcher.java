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
/**  
<dependency>
            <groupId>com.hadoopz</groupId>
            <artifactId>YesHttp</artifactId>
            <version>1.0.53</version>
        </dependency>
**/
public class Main {
    
    String flag = "purevoice/niv";   // mclean dramatized purevoice(George W.Saris)
    Mp3Item [] mp3Items_suchet = new Mp3Item[]{
            new Mp3Item(1,"https://www.biblegateway.com/audio/"+flag+"/Gen.",50),
            new Mp3Item(2, "https://www.biblegateway.com/audio/"+flag+"/Exod.",40 ),
            new Mp3Item(3, "https://www.biblegateway.com/audio/"+flag+"/Lev.",27 ),
            new Mp3Item(4, "https://www.biblegateway.com/audio/"+flag+"/Num." ,36 ),
            new Mp3Item(5, "https://www.biblegateway.com/audio/"+flag+"/Deut." ,34 ),
            new Mp3Item(6, "https://www.biblegateway.com/audio/"+flag+"/Josh." ,24 ),
            new Mp3Item(7,"https://www.biblegateway.com/audio/"+flag+"/Judg."  ,21 ),
            new Mp3Item(8, "https://www.biblegateway.com/audio/"+flag+"/Ruth.", 4),
            new Mp3Item(9, "https://www.biblegateway.com/audio/"+flag+"/1Sam." ,31 ),
            new Mp3Item(10,"https://www.biblegateway.com/audio/"+flag+"/2Sam."  ,24 ),
            new Mp3Item(11, "https://www.biblegateway.com/audio/"+flag+"/1Kgs.",22 ),
            new Mp3Item(12,"https://www.biblegateway.com/audio/"+flag+"/2Kgs.",25),
            new Mp3Item(13,"https://www.biblegateway.com/audio/"+flag+"/1Chr.",29),
            new Mp3Item(14,"https://www.biblegateway.com/audio/"+flag+"/2Chr.",36),
            new Mp3Item(15,"https://www.biblegateway.com/audio/"+flag+"/Ezra.",10),
            new Mp3Item(16,"https://www.biblegateway.com/audio/"+flag+"/Neh.",13),
            new Mp3Item(17,"https://www.biblegateway.com/audio/"+flag+"/Esth.",10),
            new Mp3Item(18,"https://www.biblegateway.com/audio/"+flag+"/Job." ,42),
            new Mp3Item(19,"https://www.biblegateway.com/audio/"+flag+"/Ps.",150),
            new Mp3Item(20,"https://www.biblegateway.com/audio/"+flag+"/Prov.",31),
            new Mp3Item(21,"https://www.biblegateway.com/audio/"+flag+"/Eccl.",12),
            new Mp3Item(22,"https://www.biblegateway.com/audio/"+flag+"/Song.",8),
            new Mp3Item(23,"https://www.biblegateway.com/audio/"+flag+"/Isa.",66),
            new Mp3Item(24,"https://www.biblegateway.com/audio/"+flag+"/Jer." ,52),
            new Mp3Item(25,"https://www.biblegateway.com/audio/"+flag+"/Lam.",5),
            new Mp3Item(26,"https://www.biblegateway.com/audio/"+flag+"/Ezek.",48),
            new Mp3Item(27,"https://www.biblegateway.com/audio/"+flag+"/Dan." ,12),
            new Mp3Item(28,"https://www.biblegateway.com/audio/"+flag+"/Hos.",14),
            new Mp3Item(29,"https://www.biblegateway.com/audio/"+flag+"/Joel.",3),
            new Mp3Item(30,"https://www.biblegateway.com/audio/"+flag+"/Amos.",9),
            new Mp3Item(31,"https://www.biblegateway.com/audio/"+flag+"/Obad.",1),
            new Mp3Item(32,"https://www.biblegateway.com/audio/"+flag+"/Jonah.",4),
            new Mp3Item(33,"https://www.biblegateway.com/audio/"+flag+"/Mic.",7),
            new Mp3Item(34,"https://www.biblegateway.com/audio/"+flag+"/Nah.",3),
            new Mp3Item(35,"https://www.biblegateway.com/audio/"+flag+"/Hab.",3),
            new Mp3Item(36,"https://www.biblegateway.com/audio/"+flag+"/Zeph." ,3),
            new Mp3Item(37,"https://www.biblegateway.com/audio/"+flag+"/Hag.",2),
            new Mp3Item(38,"https://www.biblegateway.com/audio/"+flag+"/Zech.",14),
            new Mp3Item(39,"https://www.biblegateway.com/audio/"+flag+"/Mal.",4),
            new Mp3Item(40,"https://www.biblegateway.com/audio/"+flag+"/Matt.",28),
            new Mp3Item(41,"https://www.biblegateway.com/audio/"+flag+"/Mark." ,16),
            new Mp3Item(42,"https://www.biblegateway.com/audio/"+flag+"/Luke." ,24),
            new Mp3Item(43,"https://www.biblegateway.com/audio/"+flag+"/John.",21),
            new Mp3Item(44,"https://www.biblegateway.com/audio/"+flag+"/Acts.",28),
            new Mp3Item(45,"https://www.biblegateway.com/audio/"+flag+"/Rom.",16),
            new Mp3Item(46,"https://www.biblegateway.com/audio/"+flag+"/1Cor.",16),
            new Mp3Item(47,"https://www.biblegateway.com/audio/"+flag+"/2Cor." ,13),
            new Mp3Item(48,"https://www.biblegateway.com/audio/"+flag+"/Gal.",6),
            new Mp3Item(49,"https://www.biblegateway.com/audio/"+flag+"/Eph.",6),
            new Mp3Item(50, "https://www.biblegateway.com/audio/"+flag+"/Phil.",4),
            new Mp3Item(51,"https://www.biblegateway.com/audio/"+flag+"/Col.",4),
            new Mp3Item(52,"https://www.biblegateway.com/audio/"+flag+"/1Thess." ,5),
            new Mp3Item(53,"https://www.biblegateway.com/audio/"+flag+"/2Thess.",3),
            new Mp3Item(54,"https://www.biblegateway.com/audio/"+flag+"/1Tim.",6),
            new Mp3Item(55,"https://www.biblegateway.com/audio/"+flag+"/2Tim.",4),
            new Mp3Item(56,"https://www.biblegateway.com/audio/"+flag+"/Titus.",3),
            new Mp3Item(57,"https://www.biblegateway.com/audio/"+flag+"/Phlm.",1),
            new Mp3Item(58,"https://www.biblegateway.com/audio/"+flag+"/Heb." ,13),
            new Mp3Item(59,"https://www.biblegateway.com/audio/"+flag+"/Jas.",5),
            new Mp3Item(60,"https://www.biblegateway.com/audio/"+flag+"/1Pet.",5),
            new Mp3Item(61,"https://www.biblegateway.com/audio/"+flag+"/2Pet.",3),
            new Mp3Item(62,"https://www.biblegateway.com/audio/"+flag+"/1John.",5),
            new Mp3Item(63,"https://www.biblegateway.com/audio/"+flag+"/2John.",1),
            new Mp3Item(64,"https://www.biblegateway.com/audio/"+flag+"/3John.",1),
            new Mp3Item(65,"https://www.biblegateway.com/audio/"+flag+"/Jude.",1),
            new Mp3Item(66,"https://www.biblegateway.com/audio/"+flag+"/Rev.",22),
    };


    // mvn clean -DskipTests=false test -Dtest=JCloudServerApplicationTests#buildMp3Test
    @Test
    void buildMp3Test() {
        System.out.println();
        for(int i=0;i<mp3Items_suchet.length;i++){
            printChapterMp3(mp3Items_suchet[i]);
        }
        System.out.println();
    }

    private void printChapterMp3(Mp3Item item){
        if(item == null){
            return;
        }
        System.out.print("const en_GeorgeWSarris_mp3_urls_"+item.getId()+"=[");
        for(int i = 1;i<=item.getSize();i++){
            Request request = new StringRequest(HttpMethod.GET, item.getBaseUrl()+i, new TextBaseResponseListener() {
                @Override
                public void responseMe(final String msg) {
//                    System.out.println("the response of success:" + msg);
                    Pattern p = Pattern.compile("src=\"(https://stream\\.biblegateway\\.com/bibles/\\d+/niv-purevoice/[A-Za-z0-9._-]+\\.mp3)\"");
                    Matcher m = p.matcher(msg);
                    if (m.find()) {
                        System.out.println("\"" + m.group(1)+"\",");
                    }else {

                    }

                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(final YesHttpError error
                        ) {
                            System.out.println("this is the response of error:" + error.getMessage());

                        }
                    }, null,Request.Protocol.HTTPS_IGNORE_CERT
            ) ;
            YesHttpEngine.getYesHttpEngine().send(request);


        }
        System.out.println("];");
    }

}

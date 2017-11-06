import com.app.jfinal.service.workorder.model.Wosafetylink;
import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;

import java.util.Map;

/**
 **/
public class TestCanDel {

    public static void main(String[] ages){
        String json="{ \"a\": \"asus\", \"b\": 123 }" ;
        Map map= new CaseInsensitiveMap<String,String>();
        map.put("Asus","sdf");
        map.put("AsUs","aasdf");
        map.put("liNux","SDF");
        for (Object key: map.keySet()) {
            System.out.println("key="+key);
            System.out.println("value="+map.get(key));
        }

        String pid=java.lang.management.ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        System.out.println("pid="+pid);
        BaseModel.Companion.loadSnowfieldMap();

        Wosafetylink wosafe=new Wosafetylink();
        wosafe.putMaxUniqueIDValue(2L);

    }


}

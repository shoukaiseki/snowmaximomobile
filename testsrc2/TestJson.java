import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;
import com.app.jfinal.service.workflow.model.WorkflowResponse;
import com.app.jfinal.service.workflow.model.WorkflowResponseAction;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import model.TestModel;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 **/
public class TestJson {



    public static void main(String[] args) {
        String json="{\"data\":{\"WorkflowResponse\":{\"active\":true,\"assignid\":196036,\"assignmentDescription\":\"【工单】请您验收由 邵永吉 发起的 描述为 清水河第一风电场110kV 盾一风线、清二风线线路巡视 的工单\",\"error\":false,\"lhm\":{\"验收通过，关闭工单\":{\"actionid\":10,\"instruction\":\"验收通过，关闭工单\",\"ispositive\":1},\"验收不通过，请工作负责人组织返修\":{\"actionid\":24,\"instruction\":\"验收不通过，请工作负责人组织返修\",\"ispositive\":0}},\"maxdialog\":\"completewf\",\"wfsessionid\":\"8acca3a4-d91f-471f-80de-f6c8974944a8\"}},\"errorcode\":0,\"errorinfo\":\"NONE\",\"parameters\":{},\"status\":\"success\"}";
        jsonToObject(json);
        asus();
        gsonToJson();
        gsonToObject();

    }

    public static final Gson getGson(){
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(java.util.Date.class, new JsonSerializer(){
            @Override
            public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
                return new JsonPrimitive(((Date)o).getTime());
            }
        }).setDateFormat(DateFormat.LONG);
        gb.registerTypeAdapter(java.util.Date.class, new JsonDeserializer(){

            @Override
            public Object deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return new java.util.Date(json.getAsJsonPrimitive().getAsLong());
            }

        }).setDateFormat(DateFormat.LONG);
        Gson gson = gb.create();
        return gson;
    }

    private static void gsonToObject() {
        String json="{\"date\":1502263121207,\"integer\":10,\"string\":\"字符串\"}";
        TestModel jm= JSONObject.parseObject(json, TestModel.class);
        System.out.println("fastjson.jm="+jm.toString());
        Gson gson=getGson();
        jm = gson.fromJson(json, TestModel.class);
        System.out.println("gson.jm="+jm.toString());
    }

    public static final void gsonToJson(){
        TestModel tm=new TestModel();
        tm.setDate(new Date());
        tm.setString("字符串");
        tm.setInteger(10);
        Gson gson=getGson();
        String result = gson.toJson(tm);
        System.out.println("gson="+result);
        result=JSONObject.toJSONString(tm);
        System.out.println("fastjson="+result);
    }

    public static final void jsonToObject(String json){

        JsonModel jm= JSONObject.parseObject(json, JsonModel.class);

        System.out.println("json="+json);
        System.out.println("jm="+ JSONObject.toJSONString(jm));

        String wrStr=jm.getData().get(0).toString();
        System.out.println("wr="+ wrStr);
        WorkflowResponse wr=JSON.parseObject(wrStr,WorkflowResponse.class);
        System.out.println("wr2="+JSONObject.toJSONString(wrStr));
        LinkedHashMap<String, WorkflowResponseAction> lhm = wr.getLhm();
        System.out.println("lhm="+JSONObject.toJSONString(lhm));

    }



    public static void asus(){

        WorkflowResponse wr=new WorkflowResponse();
        LinkedHashMap<String, WorkflowResponseAction> lhm=new LinkedHashMap<String,WorkflowResponseAction>( );
        WorkflowResponseAction wra=new WorkflowResponseAction();
        wra.setActionid(10);
        wra.setIspositive(1);
        wra.setInstruction("验收通过，关闭工单");
        lhm.put(wra.getInstruction(),wra);

        wra=new WorkflowResponseAction();
        wra.setActionid(24);
        wra.setIspositive(0);
        wra.setInstruction("验收不通过，请工作负责人组织返修");
        lhm.put(wra.getInstruction(),wra);
        wr.setLhm(lhm);
        String json= JSONObject.toJSONString(wr);
        System.out.println("jsonaaaa="+json);
        JsonModel jm=new JsonModel();
        jm.addDatas(JSONObject.toJSONString(wr));
        json= JSON.toJSONString(jm);
        System.out.println("jsonbbbb="+json);
        jsonToObject(json);
    }
}

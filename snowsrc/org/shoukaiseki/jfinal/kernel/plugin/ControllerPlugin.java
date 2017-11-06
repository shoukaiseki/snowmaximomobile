package org.shoukaiseki.jfinal.kernel.plugin;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.config.Routes;
import com.jfinal.core.Controller;
import com.jfinal.plugin.IPlugin;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.utils.FileUtils;


/**
 * org.shoukaiseki.jfinal.kernel.plugin.ControllerPlugin <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-21 16:35:43<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 * @Title: 扫描AbstractController的所走子类，得到定义静态参数TAG，绑定Controller和controllerKey
 * @Description: 利用类反射的原理，找到Controller的类，然后加载相应的上下文<code>TAG</code>，这样做到自动装载和配置
 **/

public class ControllerPlugin implements IPlugin {

    protected final static Logger log = Logger.getLogger(ControllerPlugin.class);

    private Routes me;

    public ControllerPlugin(Routes me) {
        this.me = me;
    }

    public boolean start() {
        Class<?> cl = AbstractController.class;
        List<Class<AbstractController>> cls = null;
        log.info("getAllAssignedClass start");
        try {
            cls = getAllAssignedClass(cl);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("", e);
            throw e;

        }
        log.info("getAllAssignedClass=" + cls.size());
        for (Class<AbstractController> ss : cls) {
            String tag = null;
            String viewPath = null;
            Field tagff = null;
            Field viewPathff = null;
            for (Field ff : ss.getFields()) {
                // System.out.println(ff.getName() + "|" + ff.get(ss));
                try {
                    if ("TAG".endsWith(ff.getName())) {
                        if (tagff != null) {
                            continue;
                        }
                        tagff = ff;
                        if (Modifier.isPrivate(ff.getModifiers())) {
                        } else {
                            if (ff.get(ss) != null) {
                                tag = ff.get(ss).toString();
                            }
                        }
                        log.debug("TAG=" + ff.get(ss) + "|class=" + ss);
                    } else if ("VIEWPATH".endsWith(ff.getName())) {
                        if (viewPathff != null) {
                            continue;
                        }
                        viewPathff = ff;
                        if (ff.get(ss) != null) {
                            viewPath = ff.get(ss).toString();
                        }
                        log.debug("VIEWPATH=" + ff.get(ss) + "|class=" + ss);
                    }
                } catch (Exception e) {
                    log.error(" FieldName=" + ff.getName() + "| className="
                            + ss.getName());
                    e.printStackTrace();
                }
            }
            if (viewPath != null) {
                me.add("/" + tag, ss, "/" + viewPath);
            } else {
                me.add("/" + tag, ss);
            }
        }
        return true;
    }

    /**
     * 获取Controller所有子类或接口实现类
     *
     * @param intf
     *
     * @return
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public static List<Class<AbstractController>> getAllAssignedClass(
            Class<?> cls) {
        List<Class<AbstractController>> classes = new ArrayList<Class<AbstractController>>();
        List<Class<?>> clazzList = FileUtils.loadControllerFile();
        log.debug("clazzList="+clazzList);
        for (Class<?> c :clazzList) {
            if (cls.isAssignableFrom(c) && !cls.equals(c)) {
                classes.add((Class<AbstractController>) c);
                log.debug("Controller =" + c.getName());
            }
        }
        return classes;
    }

    public boolean stop() {
        return true;
    }

    public static void main(String[] args) throws IllegalArgumentException,
            IllegalAccessException {
        Class<?> cl = Controller.class;
        List<Class<AbstractController>> cls;
        Map<String, Class<?>> map = new HashMap<String, Class<?>>();
        try {
            cls = getAllAssignedClass(cl);
            for (Class<AbstractController> ss : cls) {
                for (Field ff : ss.getFields()) {
                    System.out.println(ff.getName() + "|" + ff.get(ss));
                    if ("TAG".endsWith(ff.getName())) {
                        map.put("/" + ff.get(ss.getClass()), ss);
                        break;
                    }
                }
            }
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(map);
    }

}

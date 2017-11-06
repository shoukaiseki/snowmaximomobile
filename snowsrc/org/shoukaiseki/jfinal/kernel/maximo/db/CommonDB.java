package org.shoukaiseki.jfinal.kernel.maximo.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.maximo.model.DocFile;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;

public class CommonDB {

	public List<DocFile> findDocFile(Map map){
		String sql = SqlReadConfig.getSql("common.listdocfile",map);
		List<DocFile> lists = new ArrayList<DocFile>();
		List<Record> list = Db.find(sql);
		DocFile obj =null;
		for (Record record : list) {
			obj = DocFile.Companion.recordTo(record,DocFile.class);
			String urlname = obj.getUrlname();
			urlname=urlname.replaceAll("\\\\", "/");
			urlname=urlname.replaceAll("/DOCLINKS", PropKit.get("mxe.doclink.url"));
			urlname=urlname.replaceAll("//", "/");
			urlname=urlname.replaceAll("http:/", "http://");
			obj.setUrl(urlname);
			System.out.println(obj.getUrl());
			lists.add(obj);
		}
		return lists;
	}
}

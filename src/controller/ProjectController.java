package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanItem;
import model.BeanProject;
import serviceI.IProjectService;
import util.BaseException;

@Controller 
public class ProjectController {
	@Autowired
	private IProjectService IProjectService;
	
	/** 导出所有项目
	 * */
	@RequestMapping(value = "/loadAllProject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllItem() throws JSONException{
		List<BeanProject> prject = null;
		try {
			prject = IProjectService.loadAllProject();
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 		JSONArray json = new JSONArray();
		for(int i = 0; i < prject.size(); i++){
			JSONObject jo = new JSONObject();
			jo.put("projectId", prject.get(i).getProjectId());
			jo.put("projectName", prject.get(i).getProjectName());
			jo.put("userId", prject.get(i).getUserId());
			jo.put("projectType", prject.get(i).getProjectType());
			jo.put("projectTypeId", prject.get(i).getProjectTypeId());
			jo.put("field", prject.get(i).getField());
			jo.put("fieldId", prject.get(i).getFieldId());
			jo.put("source", prject.get(i).getSource());
			jo.put("sourceId", prject.get(i).getSourceId());
			String startTime=new SimpleDateFormat("yyyy-MM-dd").format(prject.get(i).getStartDate());
			jo.put("startData", startTime);
			String endTime=new SimpleDateFormat("yyyy-MM-dd").format(prject.get(i).getEndDate());
			jo.put("startData", startTime);
			jo.put("endData", endTime);
			json.put(jo);
		}
		return json.toString();
	}
}

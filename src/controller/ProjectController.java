package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
			jo.put("isBudget", prject.get(i).getIsBudget());
			json.put(jo);
		}
		return json.toString();
	}
	
	//删除项目
	@RequestMapping(value = "/deleteProject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String deleteItem(@RequestBody String params) throws JSONException{
		System.out.println(params);
		JSONObject json = new JSONObject(params);
		String projectId = (String) json.get("projectId");
    	JSONObject jo = new JSONObject();
    	try {
    		IProjectService.delProject(Integer.valueOf(projectId));
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
    	jo.put("msg", "succ");
		return jo.toString();  
	}
	
	//添加项目
	@RequestMapping(value = "/addProject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addProject(@RequestBody String project) throws JSONException, ParseException{
		System.out.println("123");
		JSONObject json = new JSONObject(project);
		BeanProject p = new BeanProject();
		p.setUserId((String) json.get("userId"));
		p.setProjectName((String) json.get("projectName"));
		p.setProjectType((String)json.get("projectType"));
		p.setProjectTypeId((String)json.get("projectTypeId"));
		p.setField((String)json.get("field"));
		p.setFieldId((String)json.get("fieldId"));
		p.setSource((String)json.get("source"));
		p.setSourceId((String)json.get("sourceId"));
		String startData = (String)json.get("startDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = sdf.parse(startData); 
	    p.setStartDate(date);
		String endData = (String)json.get("endDate");
		date = sdf.parse(endData); 
		p.setEndDate(date);
    	JSONObject jo = new JSONObject();
    	try {
    		IProjectService.addProject(p);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
    	jo.put("msg", "succ");
		return jo.toString();  
	}

	//添加项目
	@RequestMapping(value = "/updateProject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String updateProject(@RequestBody String project) throws JSONException, ParseException{
		JSONObject json = new JSONObject(project);
		BeanProject p = new BeanProject();
		p.setProjectId(Integer.valueOf((String) json.get("projectId")));
		p.setProjectName((String) json.get("projectName"));
		p.setProjectType((String)json.get("projectType"));
		p.setProjectTypeId((String)json.get("projectTypeId"));
		p.setField((String)json.get("field"));
		p.setFieldId((String)json.get("fieldId"));
		p.setSource((String)json.get("source"));
		p.setSourceId((String)json.get("sourceId"));
		String startData = (String)json.get("startDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = sdf.parse(startData); 
	    p.setStartDate(date);
		String endData = (String)json.get("endDate");
		date = sdf.parse(endData); 
		p.setEndDate(date);
		p.setIsBudget(0);
    	JSONObject jo = new JSONObject();
    	try {
    		IProjectService.modifryProject(p);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
    	jo.put("msg", "succ");
		return jo.toString();  
	}
		
	/** 查询项目
	 * */
	@RequestMapping(value = "/searchProject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchProject(@RequestBody String project) throws JSONException{
		JSONObject json = new JSONObject(project);
		String projectId = (String)json.get("projectId");
		BeanProject prject = null;
		try {
			prject = IProjectService.SearchProject(Integer.valueOf(projectId));
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		JSONObject jo = new JSONObject();
		jo.put("projectId", prject.getProjectId());
		jo.put("projectName", prject.getProjectName());
		jo.put("userId", prject.getUserId());
		jo.put("projectType", prject.getProjectType());
		jo.put("projectTypeId", prject.getProjectTypeId());
		jo.put("field", prject.getField());
		jo.put("fieldId", prject.getFieldId());
		jo.put("source", prject.getSource());
		jo.put("sourceId", prject.getSourceId());
		String startTime=new SimpleDateFormat("yyyy-MM-dd").format(prject.getStartDate());
		jo.put("startData", startTime);
		String endTime=new SimpleDateFormat("yyyy-MM-dd").format(prject.getEndDate());
		jo.put("startDate", startTime);
		jo.put("endDate", endTime);
		jo.put("isBudget", prject.getIsBudget());
		return jo.toString();
	}
	
	/** 导出需要填写与预算项目
	 * */
	@RequestMapping(value = "/searchBudgetProject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchBudgetProject() throws JSONException{
		List<BeanProject> prject = null;
		try {
			prject = IProjectService.searchBudgetProject();
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
			jo.put("isBudget", prject.get(i).getIsBudget());
			json.put(jo);
		}
		return json.toString();
	}
	
	/** 导出特定用户的项目
	 * */
	@RequestMapping(value = "/searchUserProject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchUserProject(@RequestBody String params) throws JSONException{
		JSONObject j = new JSONObject(params);
		String userId = (String)j.get("userId");
		List<BeanProject> prject = null;
		try {
			prject = IProjectService.searchUserProject(userId);
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
			if(prject.get(i).getStartDate()!= null){
				String startTime=new SimpleDateFormat("yyyy-MM-dd").format(prject.get(i).getStartDate());
				jo.put("startData", startTime);
			}
			if(prject.get(i).getEndDate() != null){
				String endTime=new SimpleDateFormat("yyyy-MM-dd").format(prject.get(i).getEndDate());
				jo.put("endData", endTime);
			}
			jo.put("isBudget", prject.get(i).getIsBudget());
			json.put(jo);
		}
		return json.toString();
	}
	
	//删除项目
	@RequestMapping(value = "/applySuccProject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String applySuccProject(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		String projectId = (String) json.get("projectId");
		int isBudget = (int)json.get("isBudget");
	    JSONObject jo = new JSONObject();
	    try {
	    	IProjectService.updateProjectStatus(Integer.valueOf(projectId), Integer.valueOf(isBudget));
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
	    jo.put("msg", "succ");
		return jo.toString();  
	}
}

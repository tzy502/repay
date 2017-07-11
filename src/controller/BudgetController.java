package controller;

import java.util.ArrayList;
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

import model.BeanBudget;
import model.BeanItemBudget;
import serviceI.IBudgetService;
import serviceI.IItemBudgetService;
import util.BaseException;

@Controller
public class BudgetController {
	@Autowired
	private IBudgetService BudgetService;
	@Autowired
	private IItemBudgetService ItemBudgetService;
	
	
	@RequestMapping(value = "/addBudget.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addBudget(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int projectId=-1;
		float independentFees=-1;
		float applyFees=-1;
		projectId =Integer.valueOf((String)json.get("projectId"));
		independentFees=Integer.valueOf((String)json.get("independentFees"));
		applyFees=Integer.valueOf((String)json.get("applyFees"));
		JSONArray jsonarrary = new JSONArray((String)json.getString("itemBudget"));
		float budgetSum=independentFees+applyFees;
		try {
			 BudgetService.addBudget(projectId, budgetSum, independentFees, applyFees);
			 int budgetId=BudgetService.SearchmaxId(projectId, budgetSum, independentFees, applyFees);
			 for(int i=0;i<json.length();i++){
				JSONObject jsonObj = jsonarrary.getJSONObject(i);
				ItemBudgetService.addItemBudget(budgetId, (String)jsonObj.get("itemName"), Integer.valueOf((String)jsonObj.getString("oItemId")), Float.parseFloat((String)jsonObj.get("itemBudgetCost")));
			}	 
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("msg", e);
			return json.toString();
		}
		
		return json.toString();
	}
	
	
	@RequestMapping(value = "/searchBudget.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchBudget(@RequestBody String params) throws JSONException{
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject(params);
		int budgetid =Integer.valueOf((String) jo.get("budgetId"));
		List<BeanItemBudget> result=null;		
		BeanBudget bb=new BeanBudget();
		try {
			bb=BudgetService.SearchBudget(budgetid);
			result=ItemBudgetService.SearchItemBudgetbybudgetid(budgetid);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jo.put("msg", e);
			return jo.toString();
		}
		jo.put("budgetId", bb.getBudgetId());
		jo.put("projectId", bb.getProjectId());
		jo.put("budgetSum", bb.getBudgetSum());
		jo.put("independentFees", bb.getIndependentFees());
		jo.put("applyFees", bb.getApplyFees());
		for(int i=0;i<result.size();i++){
			JSONObject jo1 = new JSONObject(params);
			jo1.put("itemBudgetId", result.get(i).getItemBudgetId());
			jo1.put("itemName", result.get(i).getItemName());
			jo1.put("itemBudgetCost", result.get(i).getItemBudgetCost());
			json.put(jo1);
		}
		jo.put("itemBudget", json);
		System.out.println(jo.toString());
		return jo.toString();
	}
	
	
	@RequestMapping(value = "/loadAllBudget.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllBudget() throws JSONException{
		System.out.println("123");
		JSONObject jo = new JSONObject();
		JSONArray json = new JSONArray();
		List<BeanBudget> bb=new  ArrayList<BeanBudget>();
		try {
			bb=BudgetService.LoadBudget();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jo.put("msg", e);
			return jo.toString();
		}
		for(int i=0;i<bb.size();i++){
			JSONObject jo1 = new JSONObject();
			jo1.put("budgetId", bb.get(i).getBudgetId());
			jo1.put("projectId", bb.get(i).getProjectId());
			jo1.put("budgetSum", bb.get(i).getBudgetSum());
			jo1.put("independentFees", bb.get(i).getIndependentFees());
			jo1.put("applyFees", bb.get(i).getApplyFees());
			json.put(jo1);
		}
		System.out.println(json.toString());
		return json.toString();
	}
	
	@RequestMapping(value = "/deleteBudget.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String deleteBudget(@RequestBody String params) throws JSONException{
		JSONObject jo = new JSONObject(params);
		int budgetid =Integer.valueOf((String) jo.get("budgetId"));	
		try {
			BudgetService.DelBudget(budgetid);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
	
	/**
	 * 修改预算
	 * */
	@RequestMapping(value = "/updateBudget.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String updateBudget(@RequestBody String params) throws JSONException, NumberFormatException, BaseException{
		JSONObject jo = new JSONObject(params);
		int budgetId =Integer.valueOf((String) jo.get("budgetId"));	
		float applyFees=Float.parseFloat((String)jo.get("applyFees"));
		float independentFees=Float.parseFloat((String)jo.get("independentFees"));
		float budgetSum = applyFees + independentFees;
		BudgetService.modifryBudget(budgetId, budgetSum, independentFees, applyFees);
		JSONArray json = new JSONArray((String)jo.getString("itemBudget"));
		for(int i=0;i<json.length();i++){
			 JSONObject jsonObj = json.getJSONObject(i);
			 ItemBudgetService.modifryItemBudget(Integer.valueOf((String) jsonObj.get("itemBudgetId")),Float.parseFloat((String)jsonObj.get("itemBudgetCost")));		 
		}
		return jo.toString();
	}
	
	/**
	 * 根据预算单编号找出所有报销项
	 * */
	@RequestMapping(value = "/loadItemBudget.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadItemBudget(@RequestBody String params) throws JSONException{
		JSONObject jo = new JSONObject(params);
		int budgetId =Integer.valueOf((String) jo.get("budgetId"));	
		
		List<BeanItemBudget> bb=new  ArrayList<BeanItemBudget>();
		try {
			bb=ItemBudgetService.SearchItemBudgetbybudgetid(budgetId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jo.put("msg", e);
			return jo.toString();
		}
		JSONArray json = new JSONArray();
		for(int i=0;i<bb.size();i++){
			JSONObject jo1 = new JSONObject();
			jo1.put("itemBudgetId", bb.get(i).getItemBudgetId());
			jo1.put("budgetId", bb.get(i).getBudgetId());
			jo1.put("itemName", bb.get(i).getItemName());
			jo1.put("itemBudgetCost", bb.get(i).getItemBudgetCost());
			json.put(jo1);
		}
		System.out.println(json.toString());
		return json.toString();
	}
	
	/**
	 * 根据项目编号查找预算单
	 * */
	@RequestMapping(value = "/searchBudgetByPId.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchBudgetByPId(@RequestBody String params) throws JSONException{
		JSONObject jo = new JSONObject(params);
		int projectId =Integer.valueOf((String) jo.get("projectId"));	
		BeanBudget bb=new BeanBudget();
		try {
			bb=BudgetService.searchBudgetByPId(projectId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jo.put("msg", e);
			return jo.toString();
		}
		jo.put("budgetId", bb.getBudgetId());
		jo.put("projectId", bb.getProjectId());
		jo.put("budgetSum", bb.getBudgetSum());
		jo.put("independentFees", bb.getIndependentFees());
		jo.put("applyFees", bb.getApplyFees());
		System.out.println(jo.toString());
		return jo.toString();
	}
		
}

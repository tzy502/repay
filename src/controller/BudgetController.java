package controller;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanBudget;
import model.BeanSchoolItem;
import serviceI.IBudgetService;
import serviceI.IItemBudgetService;
import util.BaseException;

public class BudgetController {
	@Autowired
	private IBudgetService BudgetService;
	private IItemBudgetService ItemBudgetService;
	@RequestMapping(value = "/addBudget.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addBudget(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int projectId=-1;
		
		float independentFees=-1;
		float applyFees=-1;
		float budgetSum=independentFees+applyFees;
		projectId =Integer.valueOf((String)json.get("projectId"));
		budgetSum=Integer.valueOf((String)json.get("budgetSum"));
		independentFees=Integer.valueOf((String)json.get("independentFees"));
		applyFees=Integer.valueOf((String)json.get("applyFees"));
		try {
			BudgetService.addBudget(projectId, budgetSum, independentFees, applyFees);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("msg", e);
			return json.toString();
		}
		return json.toString();
	}
	@RequestMapping(value = "/addBudget.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchBudget(@RequestBody String params) throws JSONException{
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		List<BeanBudget> result=null;
		try {
			result=BudgetService.LoadBudget();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			jo.put("schoolItemId", result.get(i));
			jo.put("itemId",result.get(i));
			jo.put("schoolItemName", result.get(i));
			json.put(jo);
		}
		return jo.toString();
	}
	

}

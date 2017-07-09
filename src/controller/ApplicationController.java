package controller;


import java.util.ArrayList;
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
import model.BeanItemCost;
import model.BeanUser;
import serviceI.IBudgetService;
import serviceI.*;
import util.BaseException;

@Controller  
public class ApplicationController {
	@Autowired
	private IBudgetService IBudgetService;
	
	@Autowired
	private IItemBudgetService IItemBudgetService;
	
	@Autowired
	private IItemCostService IItemCostService;
	
	//审核
	@RequestMapping(value = "/applicationSummary.do") 
	@ResponseBody
	public String applicationSummary(@RequestBody String params) throws JSONException{  
    	JSONObject js = new JSONObject(params);
    	String projectId = (String) js.get("projectId");
    	String summaryId = (String) js.get("summaryId");
    	JSONObject jo = new JSONObject();
    	BeanBudget budget;
		try {
			budget = IBudgetService.searchBudgetByPId(Integer.valueOf(projectId));
			List<BeanItemBudget> itemBudget = IItemBudgetService.SearchItemBudgetbybudgetid(budget.getBudgetId());
	    	List<BeanItemCost> itemCost = IItemCostService.searchItemCostBySId(Integer.valueOf(summaryId));
	    	
	    	
	    	JSONArray json = new JSONArray();
			for(int i=0;i<itemBudget.size();i++){
				JSONObject jo1 = new JSONObject();
				jo1.put("budgetId", itemBudget.get(i).getBudgetId());
				jo1.put("itemName", itemBudget.get(i).getItemName());
				jo1.put("itemBudgetCost", itemBudget.get(i).getItemBudgetCost());
				for(int j = 0; j < itemCost.size(); j++){
					if(itemCost.get(i).getSchoolItemId() == itemBudget.get(i).getItemId()){
						jo1.put("itemCost", "");	
					}
								
				}
				
				json.put(jo1);
			}
			
			
		} catch (NumberFormatException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return jo.toString(); 
    }
	
	
}

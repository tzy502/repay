
public interface json {

}
/*
 *
 * 17.7.8,14:14
 * 
 * budget:
	addBudget.do
	服务端接收： 
	json:{
		"projectId":
		"independentFees":
		"applyFees":
		"itemBudget":[
				{
					"itemId":
					"itemBudgetCost":
				},
				{
					"itemId":
					"itemBudgetCost":
				}
		]
	}
	independentFees+applyFees=budgetSum;
	
	searchBudget：
	服务端接收：
	json：{
		"budgetId":
	}
	服务端发送：
	json：{
		"budgetId":
		"projectId":
		"independentFees":
		"applyFees":
		"budgetSum":
		"itemBudget":[
				{
					"itemBudgetId":
					"itemId":
					"itemBudgetCost":
				},
				{
					"itemBudgetId":
					"itemId":
					"itemBudgetCost":
				}
		]
	}
	
	loadAllBudget:
	服务端发送：
	json：{
		"budgetId":
		"projectId":
		"independentFees":
		"applyFees":
		"budgetSum":
	}
	
	deleteBudget:
	服务端接收：
	json：{
		"budgetId":
	}
	
	updateBudget:
	服务端接收：
	json:{
		"budgetId":
		"independentFees":
		"applyFees":
		"itemBudget":[
				{
					"itemBudgetId":
					"itemBudgetCost":
				},
				{
					"itemBudgetId":
					"itemBudgetCost":
				}
		]
	}
	
	schoolitem：
	addSchoolItem.do
	json:{
		"itemId":
		"schoolItemName":
	}
	
	updateSchoolItem.do
	json:{
		"schoolItemId":
		"itemId":
		"schoolItemName":
	}
	
	deleteSchoolItem.do
	json:{
		"schoolItemId"：
	}
 * 
 * */
 
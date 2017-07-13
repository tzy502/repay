package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import serviceI.*;
import util.BaseException;
import model.*;

@Controller
public class RepayController {
	@Autowired
	private ITravelService TravelService;
	@Autowired
	private ITravelUserService TravelUserService;
	@Autowired
	private IRepayService RepayService;
	
	
	@RequestMapping( value = "/loadAllRepay.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllrepay() throws JSONException{	
		JSONArray json = new JSONArray();
		JSONArray jsarraybt = new JSONArray();
		JSONArray jsarraybtu = new JSONArray();
		List<BeanRepay> bb=new ArrayList<BeanRepay>();
		List<BeanTravel> bt=new ArrayList<BeanTravel>();
		List<BeanTravelUser> btu=new ArrayList<BeanTravelUser>();
		try {
			bb=RepayService.loadAllRepay();
			bt=TravelService.loadTravel();
			btu=TravelUserService.loadTravelUser();	
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0;i<bb.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("repayId", bb.get(i).getRepayId());
			jo.put("company", bb.get(i).getCompany());
			jo.put("projectId", bb.get(i).getProjectId());
			jo.put("reason", bb.get(i).getReason());
			jo.put("annex", bb.get(i).getAnnex());
			jo.put("annexPath", bb.get(i).getAnnexPath());
			jo.put("checkDays", bb.get(i).getCheckDays());
			jo.put("checkPlane", bb.get(i).getCheckPlane());
			jo.put("checkTrain", bb.get(i).getCheckTrain());
			jo.put("checkTOther", bb.get(i).getCheckTOther());
			jo.put("checkStay", bb.get(i).getCheckStay());
			jo.put("checkFood", bb.get(i).getCheckFood());
			jo.put("checkMi", bb.get(i).getCheckMi());
			jo.put("checkOther", bb.get(i).getCheckOther());
			jo.put("sum", bb.get(i).getSum());	
			jo.put("approvalId",bb.get(i).getApprovalId());
			jo.put("data", bb.get(i).getData());
			jo.put("applicationId", bb.get(i).getApplicationId());
			jo.put("workerId", bb.get(i).getWorkerId());
			jo.put("userName", bb.get(i).getUserName());
			jo.put("money", bb.get(i).getMoney());
			jo.put("cardNumber", bb.get(i).getCardNumber());
			jo.put("auditor", bb.get(i).getAuditor());
			for(int j=0;j<bt.size();j++){
				JSONObject jobt = new JSONObject();
				jobt.put("travelId", bt.get(j).getTravelId());
				jobt.put("repayId", bt.get(j).getRepayId());
				jobt.put("travelLocation", bt.get(j).getTravelLocation());
				jobt.put("travelProvince" , bt.get(j).getTravelProvince());
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
				String startData=sdf.format(bt.get(j).getStartData());
				jobt.put("startData",  startData);
				String endData=sdf.format(bt.get(j).getEndData());
				jobt.put("endData", endData);
				jobt.put("days", bt.get(j).getDays() );
				jobt.put("plane" , bt.get(j).getPlane() );
				jobt.put("train", bt.get(j).getTrain() );
				jobt.put("tasfficOther" , bt.get(j).getTasfficOther() );
				jobt.put("stayFees" , bt.get(j).getStayFees() );
				jobt.put("foodFees" , bt.get(j).getFoodFees() );
				jobt.put("miFess", bt.get(j).getMiFess() );
				jobt.put("other", bt.get(j).getOther() ); 
				jsarraybt.put(jobt);				 
			}
			jo.put("travel", jsarraybt);
			for(int k=0;k<btu.size();k++){
				JSONObject jobtu = new JSONObject();
				jobtu.put("travelUserId", btu.get(k).getTravelUserId() );
				jobtu.put("repayId", btu.get(k).getRepayId() );
				jobtu.put("userName", btu.get(k).getUserName() );
				jobtu.put("userJob", btu.get(k).getUserJob() );
				jsarraybtu.put(jobtu);
			}
			jo.put("traveluser", jsarraybtu);
			json.put(jo);
		}
		return json.toString();
	}
	
	//导出所有等待审核的报销单
	@RequestMapping( value = "/loadARepay.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadARepay() throws JSONException{	
		JSONArray json = new JSONArray();
		JSONArray jsarraybt = new JSONArray();
		JSONArray jsarraybtu = new JSONArray();
		List<BeanRepay> bb=new ArrayList<BeanRepay>();
		List<BeanTravel> bt=new ArrayList<BeanTravel>();
		List<BeanTravelUser> btu=new ArrayList<BeanTravelUser>();
		try {
			bb=RepayService.loadARepay();
			bt=TravelService.loadTravel();
			btu=TravelUserService.loadTravelUser();	
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0;i<bb.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("repayId", bb.get(i).getRepayId());
			jo.put("company", bb.get(i).getCompany());
			jo.put("projectId", bb.get(i).getProjectId());
			jo.put("reason", bb.get(i).getReason());
			jo.put("annex", bb.get(i).getAnnex());
			jo.put("annexPath", bb.get(i).getAnnexPath());
			jo.put("checkDays", bb.get(i).getCheckDays());
			jo.put("checkPlane", bb.get(i).getCheckPlane());
			jo.put("checkTrain", bb.get(i).getCheckTrain());
			jo.put("checkTOther", bb.get(i).getCheckTOther());
			jo.put("checkStay", bb.get(i).getCheckStay());
			jo.put("checkFood", bb.get(i).getCheckFood());
			jo.put("checkMi", bb.get(i).getCheckMi());
			jo.put("checkOther", bb.get(i).getCheckOther());
			jo.put("sum", bb.get(i).getSum());	
			jo.put("approvalId",bb.get(i).getApprovalId());
			jo.put("data", bb.get(i).getData());
			jo.put("applicationId", bb.get(i).getApplicationId());
			jo.put("workerId", bb.get(i).getWorkerId());
			jo.put("userName", bb.get(i).getUserName());
			jo.put("money", bb.get(i).getMoney());
			jo.put("cardNumber", bb.get(i).getCardNumber());
			jo.put("auditor", bb.get(i).getAuditor());
			for(int j=0;j<bt.size();j++){
				JSONObject jobt = new JSONObject();
				jobt.put("travelId", bt.get(j).getTravelId());
				jobt.put("repayId", bt.get(j).getRepayId());
				jobt.put("travelLocation", bt.get(j).getTravelLocation());
				jobt.put("travelProvince" , bt.get(j).getTravelProvince());
				jobt.put("startData", bt.get(j).getStartData() );
				jobt.put("endData", bt.get(j).getEndData() );
				jobt.put("days", bt.get(j).getDays() );
				jobt.put("plane" , bt.get(j).getPlane() );
				jobt.put("train", bt.get(j).getTrain() );
				jobt.put("tasfficOther" , bt.get(j).getTasfficOther() );
				jobt.put("stayFees" , bt.get(j).getStartData() );
				jobt.put("foodFees" , bt.get(j).getFoodFees() );
				jobt.put("miFess", bt.get(j).getMiFess() );
				jobt.put("other", bt.get(j).getOther() ); 
				jsarraybt.put(jobt);				 
			}
			jo.put("travel", jsarraybt);
			for(int k=0;k<btu.size();k++){
				JSONObject jobtu = new JSONObject();
				jobtu.put("travelUserId", btu.get(k).getTravelUserId() );
				jobtu.put("repayId", btu.get(k).getRepayId() );
				jobtu.put("userName", btu.get(k).getUserName() );
				jobtu.put("userJob", btu.get(k).getUserJob() );
				jsarraybtu.put(jobtu);
			}
			jo.put("traveluser", jsarraybtu);
			json.put(jo);
		}
		return json.toString();
	}
	
	
	@RequestMapping( value = "/searchRepay.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String Searchrepay(@RequestBody String params) throws JSONException{	
		JSONArray json = new JSONArray();
		JSONArray jsarraybt = new JSONArray();
		JSONArray jsarraybtu = new JSONArray();
		JSONObject jsonobject = new JSONObject(params);
		int repayid =Integer.valueOf((String)jsonobject.get("repayId"));
		BeanRepay bb=new BeanRepay();
		List<BeanTravel> bt=new ArrayList<BeanTravel>();
		List<BeanTravelUser> btu=new ArrayList<BeanTravelUser>();
		try {
			bb=RepayService.SearchRepay(repayid);
			bt=TravelService.searchTravelbyrepayid(repayid);
			btu=TravelUserService.searchTravelUserbyrepayid(repayid);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject jo = new JSONObject();
		jo.put("repayId", bb.getRepayId());
		jo.put("company", bb.getCompany());
		jo.put("projectId", bb.getProjectId());
		jo.put("reason", bb.getReason());
		jo.put("annex", bb.getAnnex());
		jo.put("annexPath", bb.getAnnexPath());
		jo.put("checkDays", bb.getCheckDays());
		jo.put("checkPlane", bb.getCheckPlane());
		jo.put("checkTrain", bb.getCheckTrain());
		jo.put("checkTOther", bb.getCheckTOther());
		jo.put("checkStay", bb.getCheckStay());
		jo.put("checkFood", bb.getCheckFood());
		jo.put("checkMi", bb.getCheckMi());
		jo.put("checkOther", bb.getCheckOther());
		jo.put("sum", bb.getSum());	
		jo.put("approvalId",bb.getApprovalId());
		jo.put("data", bb.getData());
		jo.put("applicationId", bb.getApplicationId());
		jo.put("workerId", bb.getWorkerId());
		jo.put("userName", bb.getUserName());
		jo.put("money", bb.getMoney());
		jo.put("cardNumber", bb.getCardNumber());
		jo.put("auditor", bb.getAuditor());
		for(int j=0;j<bt.size();j++){
			JSONObject jobt = new JSONObject();
			jobt.put("travelId", bt.get(j).getTravelId());
			jobt.put("repayId", bt.get(j).getRepayId());
			jobt.put("travelLocation", bt.get(j).getTravelLocation());
			jobt.put("travelProvince" , bt.get(j).getTravelProvince());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			String startData=sdf.format(bt.get(j).getStartData());
			jobt.put("startData",  startData);
			String endData=sdf.format(bt.get(j).getEndData());
			jobt.put("endData", endData);
			jobt.put("days", bt.get(j).getDays() );
			jobt.put("plane" , bt.get(j).getPlane() );
			jobt.put("train", bt.get(j).getTrain() );
			jobt.put("tasfficOther" , bt.get(j).getTasfficOther() );
			jobt.put("stayFees" , bt.get(j).getStayFees());
			jobt.put("foodFees" , bt.get(j).getFoodFees() );
			jobt.put("miFess", bt.get(j).getMiFess() );
			jobt.put("other", bt.get(j).getOther() ); 
			jsarraybt.put(jobt);				 
		}
		jo.put("travel", jsarraybt);
		
		for(int k=0;k<btu.size();k++){
			JSONObject jobtu = new JSONObject();
			jobtu.put("travelUserId", btu.get(k).getTravelUserId() );
			jobtu.put("repayId", btu.get(k).getRepayId() );
			jobtu.put("userName", btu.get(k).getUserName() );
			jobtu.put("userJob", btu.get(k).getUserJob() );
			jsarraybtu.put(jobtu);
		}
		jo.put("traveluser", jsarraybtu);
		System.out.println(jo.toString());
		return jo.toString();
	}
	
	
	
	@RequestMapping( value = "/updateRepay.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String updaterepay(@RequestBody String params) throws JSONException, ParseException{	
		JSONObject jsonobject = new JSONObject(params);
		JSONArray jsarraybt = jsonobject.getJSONArray("travel");
		JSONArray jsarraybtu = jsonobject.getJSONArray("traveluser");
		List<BeanTravel> btlist=new ArrayList<BeanTravel>();
		List<BeanTravelUser> btulist=new ArrayList<BeanTravelUser>();
		float checkDays = 0;
		float checkPlane = 0;
		float checkTrain = 0;
		float checkTOther = 0;
		float checkStay = 0;
		float checkFood = 0;
		float checkMi = 0;
		float checkOther = 0;
		float sum=0;
		for(int i=0;i<jsarraybt.length();i++){
			JSONObject jsonbt = jsarraybt.getJSONObject(i);
			BeanTravel bt=new BeanTravel();
			bt.setTravelId((Integer.valueOf(jsonobject.getString("travelId"))));	
			bt.setRepayId(Integer.valueOf(jsonobject.getString("repayId")));
			bt.setTravelLocation(jsonbt.getString("travelLocation"));
			bt.setTravelProvince(jsonbt.getString("travelProvince"));
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
			Date date=fmt.parse(jsonbt.getString("startData"));
			bt.setStartData(date);
			Date enddate=fmt.parse(jsonbt.getString("endData"));
			bt.setEndData(enddate);
			long start=date.getTime();
			long end=enddate.getTime();	
			int days=(int)((start-end)/(1000 * 60 * 60 * 24)); 
			bt.setDays(days);		
			bt.setPlane(Float.parseFloat(jsonbt.getString("plane")));
			bt.setTrain(Float.parseFloat(jsonbt.getString("train")));
			bt.setTasfficOther(Float.parseFloat(jsonbt.getString("tasfficOther")));
			bt.setStayFees(Float.parseFloat(jsonbt.getString("stayFees")));
			bt.setFoodFees(Float.parseFloat(jsonbt.getString("foodFees")));
			bt.setMiFess(Float.parseFloat(jsonbt.getString("miFess")));
			bt.setOther(Float.parseFloat(jsonbt.getString("other")));
			checkDays=checkDays+days;
			checkPlane=checkPlane+Float.parseFloat(jsonbt.getString("plane"));
			checkTrain=checkTrain+(Float.parseFloat(jsonbt.getString("train")));
			checkTOther=checkTOther+Float.parseFloat(jsonbt.getString("tasfficOther"));
			checkStay=checkStay+Float.parseFloat(jsonbt.getString("stayFees"));
			checkFood=checkFood+Float.parseFloat(jsonbt.getString("foodFees"));
			checkMi=checkMi+Float.parseFloat(jsonbt.getString("miFess"));
			checkOther=checkOther+Float.parseFloat(jsonbt.getString("other"));
			try {
				TravelService.modifryTravel(bt.getTravelId(),bt.getRepayId(), btlist.get(i).getTravelLocation(), btlist.get(i).getTravelProvince(),
						btlist.get(i).getStartData(), btlist.get(i).getEndData(), btlist.get(i).getDays(), btlist.get(i).getPlane(),
						btlist.get(i).getTrain(), btlist.get(i).getTasfficOther(), btlist.get(i).getStayFees(),
						btlist.get(i).getFoodFees(), btlist.get(i).getMiFess(), btlist.get(i).getOther());
			} catch (BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		sum=checkPlane+checkTrain+checkTOther+checkStay+checkFood+checkMi+checkOther;
		String company=jsonobject.getString("company");
		String projectId=jsonobject.getString("projectId");
		String reason=jsonobject.getString("reason");
		int annex=Integer.valueOf(jsonobject.getString("annex"));
		String annexPath=jsonobject.getString("annexPath");
		String approvalId=jsonobject.getString("approvalId");
		String data=fmt.format(jsonobject.getString("data"));
		String applicationId=jsonobject.getString("applicationId" );
		String workerId=jsonobject.getString("workerId" );
		String userName=jsonobject.getString("userName");
		float money=Float.parseFloat(jsonobject.getString("money" ));
		String cardNumber=jsonobject.getString("cardNumber" );
		String auditor=jsonobject.getString("auditor");
		int repayid=Integer.valueOf(jsonobject.getString("repayId"));
		try {
			RepayService.mordifyRepay(repayid, company, projectId, reason, annex, annexPath, checkDays, checkPlane, checkTrain, checkTOther, checkStay, checkFood, checkMi, checkOther, sum, approvalId, data, applicationId, workerId, userName, money, cardNumber, auditor);
		
		
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for(int i=0;i<jsarraybtu.length();i++){
				btulist=null;
				JSONObject jsonbtu = jsarraybt.getJSONObject(i);
				BeanTravelUser btu=new BeanTravelUser();
				TravelUserService.modifryTravelUser(Integer.valueOf(jsonbtu.getString("travelUserId")), repayid, jsonbtu.getString("userName"), jsonbtu.getString("userJob"));
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "ok";
	}
	
	
	@RequestMapping( value = "/addRepay.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addrepay(@RequestBody String params) throws JSONException, ParseException{	
		JSONObject jsonobject = new JSONObject(params);
		JSONArray jsarraybt = jsonobject.getJSONArray("travel");
		JSONArray jsarraybtu = jsonobject.getJSONArray("traveluser");
		List<BeanTravel> btlist=new ArrayList<BeanTravel>();

		float checkDays = 0;
		float checkPlane = 0;
		float checkTrain = 0;
		float checkTOther = 0;
		float checkStay = 0;
		float checkFood = 0;
		float checkMi = 0;
		float checkOther = 0;
		float sum=0;
		System.out.println(jsarraybt.length()+"form control");
		for(int i=0;i<jsarraybt.length();i++){
			JSONObject jsonbt = jsarraybt.getJSONObject(i);
			BeanTravel bt=new BeanTravel();
//			bt.setRepayId(Integer.valueOf((String)jsonbt.get("repayId")));
			bt.setTravelLocation(jsonbt.getString("travelLocation"));
			bt.setTravelProvince(jsonbt.getString("travelProvince"));
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
			Date date=fmt.parse(jsonbt.getString("startData"));
			bt.setStartData(date);
			Date enddate=fmt.parse(jsonbt.getString("endData"));
			bt.setEndData(enddate);
			long start=date.getTime();
			long end=enddate.getTime();	
			int days=(int)((end-start)/(1000 * 60 * 60 * 24)); 
			bt.setDays(days);		
			bt.setPlane(Float.parseFloat(jsonbt.getString("plane")));
			bt.setTrain(Float.parseFloat(jsonbt.getString("train")));
			bt.setTasfficOther(Float.parseFloat(jsonbt.getString("tasfficOther")));
			bt.setStayFees(Float.parseFloat(jsonbt.getString("stayFees")));
			bt.setFoodFees(Float.parseFloat(jsonbt.getString("foodFees")));
			bt.setMiFess(Float.parseFloat(jsonbt.getString("miFess")));
			bt.setOther(Float.parseFloat(jsonbt.getString("other")));
			checkDays=checkDays+days;
			checkPlane=checkPlane+Float.parseFloat(jsonbt.getString("plane"));
			checkTrain=checkTrain+(Float.parseFloat(jsonbt.getString("train")));
			checkTOther=checkTOther+Float.parseFloat(jsonbt.getString("tasfficOther"));
			checkStay=checkStay+Float.parseFloat(jsonbt.getString("stayFees"));
			checkFood=checkFood+Float.parseFloat(jsonbt.getString("foodFees"));
			checkMi=checkMi+Float.parseFloat(jsonbt.getString("miFess"));
			checkOther=checkOther+Float.parseFloat(jsonbt.getString("other"));
			btlist.add(bt);
			System.out.println(btlist.size()+"form control");
		}
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		sum=checkPlane+checkTrain+checkTOther+checkStay+checkFood+checkMi+checkOther;
		String company=jsonobject.getString("company");
		String projectId=jsonobject.getString("projectId");
		String reason=jsonobject.getString("reason");
		int annex=Integer.valueOf(jsonobject.getString("annex"));
		String annexPath=jsonobject.getString("annexPath");
		String approvalId=jsonobject.getString("approvalId");
		String applicationId=jsonobject.getString("applicationId" );
		String workerId=jsonobject.getString("workerId" );
		String userName=jsonobject.getString("userName");
		float money=Float.parseFloat(jsonobject.getString("money" ));
		String cardNumber=jsonobject.getString("cardNumber" );
		String auditor=jsonobject.getString("auditor");
		String data=fmt.format(new Date());
		try {
			RepayService.addRepay(company, projectId, reason, annex, annexPath, checkDays, checkPlane, checkTrain, checkTOther, checkStay, checkFood, checkMi, checkOther, sum, approvalId, data, applicationId, workerId, userName, money, cardNumber, auditor);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			int Repayid = RepayService.SearchRepaymax();
			
			for(int i=0;i<btlist.size();i++){
				TravelService.addTravel(Repayid, btlist.get(i).getTravelLocation(), btlist.get(i).getTravelProvince(),
						btlist.get(i).getStartData(), btlist.get(i).getEndData(), btlist.get(i).getDays(), btlist.get(i).getPlane(),
						btlist.get(i).getTrain(), btlist.get(i).getTasfficOther(), btlist.get(i).getStayFees(),
						btlist.get(i).getFoodFees(), btlist.get(i).getMiFess(), btlist.get(i).getOther());
			}
			for(int i=0;i<jsarraybtu.length();i++){
				JSONObject jsonbtu = jsarraybtu.getJSONObject(i);		
				TravelUserService.addTravelUser(Repayid, jsonbtu.getString("userName"), jsonbtu.getString("userJob"));
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "1";
	}
	
	@RequestMapping( value = "/deleteRepay.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String deleterepay(@RequestBody String params) throws JSONException{	
		JSONObject jsonobject = new JSONObject(params);
		int repayId =Integer.valueOf((String)jsonobject.get("repayId"));
		try {
			RepayService.delRepay(repayId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "1";
	}
	
	//审核
	@RequestMapping(value = "/repayApplication.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String repayApplication(@RequestBody String params) throws JSONException{  
    	JSONObject js = new JSONObject(params);
    	String repayId = (String) js.get("repayId");
    	String applicationId = (String) js.get("applicationId");
    	JSONObject json = new JSONObject();

		try {
			BeanRepay repay = RepayService.SearchRepay(Integer.valueOf(repayId));
			RepayService.mordifyRepay(Integer.valueOf(repayId), repay.getCompany(), repay.getProjectId(), repay.getReason(), 
					repay.getAnnex(), repay.getAnnexPath(), repay.getCheckDays(), repay.getCheckPlane(), repay.getCheckTrain(), 
					repay.getCheckTOther(), repay.getCheckStay(), repay.getCheckFood(), repay.getCheckMi(), repay.getCheckOther(), 
					repay.getSum(), repay.getApprovalId(), repay.getData(), applicationId, repay.getWorkerId(), repay.getUserName(), 
					repay.getMoney(), repay.getCardNumber(), repay.getAuditor());
			
		} catch (NumberFormatException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (BaseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		json.put("msg","succ");
		
		return json.toString(); 
    }
}

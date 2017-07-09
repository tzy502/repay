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
	@RequestMapping(value = "/loadAllrepay.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllrepay() throws JSONException{
		
		JSONArray json = new JSONArray();
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
			
		}

		String approvalId;
		String data;
		String applicationId;
		String workerId;
		String userName;
		float money;
		String cardNumber;
		String auditor;
		return null;
	}
}

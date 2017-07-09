package controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceI.*;

@Controller
public class RepayController {
	@Autowired
	private ITravelService TravelService;
	@Autowired
	private ITravelUserService TravelUserService;
	@Autowired
	private IRoleService RoleService;
	@RequestMapping(value = "/loadAllrepay.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllrepay() throws JSONException{
		int repayId;
		String company;
		String projectId;
		String reason;
		int annex;
		String annexPath;
		float checkDays;
		float checkPlane;
		float checkTrain;
		float checkTOther;
		float checkStay;
		float checkFood;
		float checkMi;
		float checkOther;
		float sum;
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

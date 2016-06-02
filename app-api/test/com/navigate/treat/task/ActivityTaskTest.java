package com.navigate.treat.task;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.navigate.treat.api.IActivitysServiceFront;
import com.navigate.treat.beans.basic.ActivitySign;
import com.navigate.treat.beans.basic.ActivitySignQueryHelper;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.beans.basic.ActivitysReg;
import com.navigate.treat.beans.basic.ActivitysRegQueryHelper;
import com.navigate.treat.beans.basic.RecordOrder;
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.helper.UsersHelper;
import com.navigate.treat.io.activity.request.ActivitysReq;
import com.navigate.treat.io.pay.helper.FundsHelper.OrderType;
import com.navigate.treat.io.pay.helper.FundsHelper.PayStatus;
import com.navigate.treat.io.user.requeset.UsersReq;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ActRegStatus;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ERole;
import com.navigate.treat.rest.control.BaseJunit4Test;
import com.navigate.treat.service.basic.IActivitySignService;
import com.navigate.treat.service.basic.IActivitysRegService;
import com.navigate.treat.service.basic.IActivitysService;
import com.navigate.treat.service.basic.IRecordOrderService;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.BigDecimalUtil;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ActivityTaskTest extends BaseJunit4Test {
	MockMvc mockMvc;
	@Resource
	IUsersService usersService;
	@Resource
	IActivitysService activitysService;
	@Resource
	IRecordOrderService recordOrderService;
	@Resource
	IActivitysRegService activitysRegService;
	@Resource
	IActivitySignService activitySignService;
	@Resource
	IActivitysServiceFront activitysServiceFront;
	Users master = null;
	Users follower = null;
	Activitys activitys = null;
	RecordOrder secOrder = null;
	RecordOrder subOrder = null;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		session = new MockHttpSession();
		request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		master = new Users();
		follower = new Users();
		activitys = new Activitys();
		secOrder = new RecordOrder();
		subOrder = new RecordOrder();
		master.setBirthday(new Date());
		master.setUserId(JedisUtil.incr(UsersHelper.REDISS_USER_KEY));
		master.setNickName("发起者");
		master.setSex(1);
		master.setMobile(getTel());
		master.setBalance(BigDecimal.ZERO);
		master.setLastLoginTime(new Date());
		master.setHeadIcon("def/a2341a21");
		master.setCtime(new Date());
		master.setStatus(UsersHelper.EStatus.Normal.ordinal());
		master.setTreamNum(master.getMobile());
		master.setUserSource("junit");
		follower.setBirthday(new Date());
		follower.setUserId(JedisUtil.incr(UsersHelper.REDISS_USER_KEY));
		follower.setNickName("发起者");
		follower.setSex(1);
		follower.setMobile(getTel());
		follower.setBalance(BigDecimal.ZERO);
		follower.setLastLoginTime(new Date());
		follower.setHeadIcon("def/a2341a21");
		follower.setCtime(new Date());
		follower.setStatus(UsersHelper.EStatus.Normal.ordinal());
		follower.setTreamNum(follower.getMobile());
		follower.setUserSource("junit");
		usersService.insertSelective(master);
		usersService.insertSelective(follower);
		// 创建一个活动
		activitys.setActTime(new Date());
		activitys.setActStatus(ActivityHelper.ActStatus.ONGOING.ordinal());
		activitys.setBizAddr("西湖区天目山路160号国际花园东栋101室");
		activitys.setBizAvg("50");
		activitys.setBizCategory("酒吧");
		activitys.setBizIcon(
				"http://qcloud.dpfile.com/pc/eUgiI94SyUOhHTrbbp2ZR_B2_hC8TRfd8OKEAC0jnFs9hOIUwAaO4NoJ_ttgPDwPTYGVDmosZWTLal1WbWRW3A.jpg");
		activitys.setBizId(62831431L);
		activitys.setBizLng(DEF_LNG);
		activitys.setBizLat(DEF_LAT);
		activitys.setBizName("回韵酒吧");
		activitys.setBizRate("3.5");
		activitys.setBriefDesc("单元测试");
		activitys.setBrowseNum(0L);
		activitys.setCtime(new Date());
		activitys.setSubsidies(new BigDecimal("100"));
		activitys.setAmountSecured(new BigDecimal("100"));
		activitys.setTheme("定时任务单元测试");
		activitys.setTreatWay(1);
		activitys.setUserLat(DEF_LAT);
		activitys.setUserLng(DEF_LNG);
		activitys.setUserId(master.getUserId());
		activitysService.insert(activitys);
		// 支付担保金，补贴
		String orderNum = new StringBuilder().append(Constants.TREAT_OFF_LINE).append("-").append(activitys.getId())
				.append("-").append(DateUtil.getSysTime()).toString();
		activitys.setOrderNum(orderNum);
		secOrder.setAmount(activitys.getAmountSecured());
		secOrder.setDistributeAmount(BigDecimal.ZERO);
		secOrder.setMtime(new Date());
		secOrder.setPayStatus(PayStatus.PAY.ordinal());
		secOrder.setOrderNum(orderNum);
		secOrder.setType(OrderType.DEPOSIT.ordinal());
		secOrder.setUserId(master.getUserId());
		secOrder.setCtime(new Date());
		recordOrderService.insertSelective(secOrder);
		subOrder.setAmount(activitys.getSubsidies());
		subOrder.setDistributeAmount(BigDecimal.ZERO);
		subOrder.setMtime(new Date());
		subOrder.setPayStatus(PayStatus.PAY.ordinal());
		subOrder.setOrderNum(orderNum);
		subOrder.setType(OrderType.SUBSIDY.ordinal());
		subOrder.setUserId(master.getUserId());
		subOrder.setCtime(new Date());
		recordOrderService.insertSelective(subOrder);
		// 发起者报名
		Thread.sleep(100);
		// 参与者报名 选中
		ActivitysReg reg = new ActivitysReg();
		reg = new ActivitysReg();
		reg.setActId(activitys.getId());
		reg.setActTime(activitys.getActTime());
		reg.setCtime(new Date());
		orderNum = new StringBuilder().append(Constants.TREAT_OFF_LINE).append("-").append(activitys.getId())
				.append("-").append(DateUtil.getSysTime()).toString();
		reg.setOrderNum(orderNum);
		reg.setRegStatus(ActRegStatus.CHECKED.ordinal());
		reg.setUserId(follower.getUserId());
		activitysRegService.insertSelective(reg);
		subOrder = new RecordOrder();
		subOrder.setAmount(activitys.getSubsidies());
		subOrder.setDistributeAmount(BigDecimal.ZERO);
		subOrder.setMtime(new Date());
		subOrder.setPayStatus(PayStatus.PAY.ordinal());
		subOrder.setOrderNum(orderNum);
		subOrder.setType(OrderType.SUBSIDY.ordinal());
		subOrder.setUserId(follower.getUserId());
		subOrder.setCtime(new Date());
		recordOrderService.insertSelective(subOrder);
		// 报名都定单
		// 签到记录
		ActivitySign t = new ActivitySign();
		t.setActivityId(activitys.getId());
		t.setActivityTime(activitys.getActTime());
		t.setCtime(new Date());
		t.setRole(ERole.MASTER.ordinal());
		t.setUserId(master.getUserId());
		activitySignService.insertSelective(t);
		t = new ActivitySign();
		t.setActivityId(activitys.getId());
		t.setActivityTime(activitys.getActTime());
		t.setCtime(new Date());
		t.setRole(ERole.FOLLOWER.ordinal());
		t.setUserId(follower.getUserId());
		activitySignService.insertSelective(t);
	}
	/**
	 * 签到
	 * @throws Exception
	 */
	@Test
	public void testSign() throws Exception {
		// 登录
		// ############################################################
		UsersReq usersReq = new UsersReq();
		// 验证码
		String captcha = RandomStringUtils.randomNumeric(4);
		JedisUtil.save(master.getMobile() + Constants.SMS_CODE_KEY, 300, captcha);// 保存验证码，过期时间5分钟
		String body = JSON.toJSONString(usersReq);
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		MvcResult result = mockMvc
				.perform(get("/users").contentType(MediaType.APPLICATION_JSON).param("mobile", master.getMobile())
						.param("captcha", captcha).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		JSONObject obj = JSON.parseObject(reponseBody);
		SID = obj.get("sid").toString();
		UsersLoginRes usersLoginRes = JSON.parseObject(obj.get("data").toString(), UsersLoginRes.class);
		// 验证登录的session
		UsersLoginRes sessionUser = JedisUtil.getObject(SID, UsersLoginRes.class);
		Assert.assertTrue(sessionUser != null);
		Assert.assertEquals(sessionUser.getUserId(), usersLoginRes.getUserId());
		// 签到
		// ############################################################
		ActivitysReq latlnt = new ActivitysReq();
		latlnt.setUserLat(String.valueOf(DEF_LAT));
		latlnt.setUserLng(String.valueOf(DEF_LNG));
		body = JSON.toJSONString(latlnt);
		httpHeaders = this.getHttpHeader(SID, body);
		result = mockMvc
				.perform(get("/common/sign").contentType(MediaType.APPLICATION_JSON)
						.param("userLat", String.valueOf(latlnt.getUserLat()))
						.param("userLng", String.valueOf(latlnt.getUserLng())).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
	}
	/**
	 * 活动自然结束
	 * 双方都未签到
	 */
	@Test
	public void actNaturalEndAllFail() {
		// 更新时间为结束时间
		Date endDate = DateUtils.addHours(new Date(), -5);
		Activitys t = new Activitys();
		t.setId(activitys.getId());
		t.setActTime(endDate);
		int row = activitysService.updateByPrimaryKeySelective(t);
		Assert.assertEquals(row, 1);
		
		ActivitySign sign = new ActivitySign();
		sign.setActivityTime(endDate);
		ActivitySignQueryHelper e = new ActivitySignQueryHelper();
		e.createCriteria().andActivityIdEqualTo(activitys.getId());
		row = activitySignService.updateByExampleSelective(sign, e);
		Assert.assertEquals(row, 2);
		
		ActivitysReg reg = new ActivitysReg();
		reg.setActTime(endDate);
		ActivitysRegQueryHelper exp=new ActivitysRegQueryHelper();
		exp.createCriteria().andActIdEqualTo(activitys.getId());
		row = activitysRegService.updateByExampleSelective(reg,exp);
		Assert.assertEquals(row, 1);
		
		// 双方都未签到 自然结束
		activitysServiceFront.doCleaning();
		// 活动状态==结束
		t = activitysService.selectByPrimaryKey(t);
		Assert.assertEquals(t.getActStatus().intValue(), ActivityHelper.ActStatus.ENDED.ordinal());
		// 订单状态
		// 发者账户金额==补贴＋担保金
		master = usersService.selectByPrimaryKey(master);
		Assert.assertEquals(master.getBalance().longValue(),
				BigDecimalUtil.add(activitys.getAmountSecured(), activitys.getSubsidies()).longValue());
		// 参与者账户金额==担保金
		follower = usersService.selectByPrimaryKey(follower);
		Assert.assertEquals(follower.getBalance().longValue(), activitys.getAmountSecured().longValue());
	}
	/**
	 * 双方签到成功
	 */
	@Test
	public void actNaturalEndAllSuccess() {
		// 更新时间为结束时间
		Date endDate = DateUtils.addHours(new Date(), -5);
		Activitys t = new Activitys();
		t.setId(activitys.getId());
		t.setActTime(endDate);
		int row = activitysService.updateByPrimaryKeySelective(t);
		Assert.assertEquals(row, 1);
		
		ActivitySign sign = new ActivitySign();
		sign.setActivityTime(endDate);
		 sign.setSignin(ActivityHelper.EInteractionSignin.COMPLETE.ordinal());
		ActivitySignQueryHelper e = new ActivitySignQueryHelper();
		e.createCriteria().andActivityIdEqualTo(activitys.getId());
		row = activitySignService.updateByExampleSelective(sign, e);
		Assert.assertEquals(row, 2);
		
		ActivitysReg reg = new ActivitysReg();
		reg.setActTime(endDate);
		ActivitysRegQueryHelper exp=new ActivitysRegQueryHelper();
		exp.createCriteria().andActIdEqualTo(activitys.getId());
		row = activitysRegService.updateByExampleSelective(reg,exp);
		Assert.assertEquals(row, 1);
		
		// 双方都签到成功, 自然结束
		activitysServiceFront.doCleaning();
		// 活动状态==结束
		t = activitysService.selectByPrimaryKey(t);
		Assert.assertEquals(t.getActStatus().intValue(), ActivityHelper.ActStatus.ENDED.ordinal());
		// 订单状态
		// 发者账户金额==担保金
		master = usersService.selectByPrimaryKey(master);
		Assert.assertEquals(master.getBalance().longValue(),activitys.getAmountSecured().longValue());
		// 参与者账户金额==担保金+补贴
		follower = usersService.selectByPrimaryKey(follower);
		Assert.assertEquals(follower.getBalance().longValue(),
				BigDecimalUtil.add(activitys.getAmountSecured(), activitys.getSubsidies()).longValue());
	}
	/**
	 * 发起者签到成功
	 */
	@Test
	public void actNaturalEndMasterSuccess() {
		// 更新时间为结束时间
		Date endDate = DateUtils.addHours(new Date(), -5);
		Activitys t = new Activitys();
		t.setId(activitys.getId());
		t.setActTime(endDate);
		int row = activitysService.updateByPrimaryKeySelective(t);
		Assert.assertEquals(row, 1);
		
		ActivitySign sign = new ActivitySign();
		sign.setActivityTime(endDate);
		ActivitySignQueryHelper e = new ActivitySignQueryHelper();
		e.createCriteria().andActivityIdEqualTo(activitys.getId());
		row = activitySignService.updateByExampleSelective(sign, e);
		Assert.assertEquals(row, 2);
		
		
		 sign = new ActivitySign();
		 sign.setSignin(ActivityHelper.EInteractionSignin.COMPLETE.ordinal());
		 e.clear(); 
		 e.createCriteria().andActivityIdEqualTo(activitys.getId()).andUserIdEqualTo(master.getUserId());
		 row = activitySignService.updateByExampleSelective(sign, e);
	 	 Assert.assertEquals(row, 1);
			
		ActivitysReg reg = new ActivitysReg();
		reg.setActTime(endDate);
		ActivitysRegQueryHelper exp=new ActivitysRegQueryHelper();
		exp.createCriteria().andActIdEqualTo(activitys.getId());
		row = activitysRegService.updateByExampleSelective(reg,exp);
		Assert.assertEquals(row, 1);
		
		// 双方都未签到 自然结束
		activitysServiceFront.doCleaning();
		// 活动状态==结束
		t = activitysService.selectByPrimaryKey(t);
		Assert.assertEquals(t.getActStatus().intValue(), ActivityHelper.ActStatus.ENDED.ordinal());
		// 订单状态
		
		// 发者账户金额==补贴＋担保金+参与者担保金
		master = usersService.selectByPrimaryKey(master);
		Assert.assertEquals(master.getBalance().longValue(),
				BigDecimalUtil.add(activitys.getAmountSecured(), activitys.getSubsidies(),activitys.getAmountSecured()).longValue());
		// 参与者账户金额==担保金
		follower = usersService.selectByPrimaryKey(follower);
		Assert.assertEquals(follower.getBalance().longValue(),0);
	}
	/**
	 * 参与者签到成功
	 */
	@Test
	public void actNaturalEndFollowerSuccess() {
		// 更新时间为结束时间
		Date endDate = DateUtils.addHours(new Date(), -5);
		Activitys t = new Activitys();
		t.setId(activitys.getId());
		t.setActTime(endDate);
		int row = activitysService.updateByPrimaryKeySelective(t);
		Assert.assertEquals(row, 1);
		
		ActivitySign sign = new ActivitySign();
		sign.setActivityTime(endDate);
		ActivitySignQueryHelper e = new ActivitySignQueryHelper();
		e.createCriteria().andActivityIdEqualTo(activitys.getId());
		row = activitySignService.updateByExampleSelective(sign, e);
		Assert.assertEquals(row, 2);
		
		 sign = new ActivitySign();
		 sign.setSignin(ActivityHelper.EInteractionSignin.COMPLETE.ordinal());
		 e.clear(); 
		 e.createCriteria().andActivityIdEqualTo(activitys.getId()).andUserIdEqualTo(follower.getUserId());
		 row = activitySignService.updateByExampleSelective(sign, e);
	 	 Assert.assertEquals(row, 1);
	 	 
		ActivitysReg reg = new ActivitysReg();
		reg.setActTime(endDate);
		ActivitysRegQueryHelper exp=new ActivitysRegQueryHelper();
		exp.createCriteria().andActIdEqualTo(activitys.getId());
		row = activitysRegService.updateByExampleSelective(reg,exp);
		Assert.assertEquals(row, 1);
		
		// 参与者签到成功
		activitysServiceFront.doCleaning();
		// 活动状态==结束
		t = activitysService.selectByPrimaryKey(t);
		Assert.assertEquals(t.getActStatus().intValue(), ActivityHelper.ActStatus.ENDED.ordinal());
		// 订单状态
		//参与者账户金额==担保金-发起者违约担保金
		follower = usersService.selectByPrimaryKey(follower);
		Assert.assertEquals(follower.getBalance().longValue(),
				BigDecimalUtil.add(activitys.getAmountSecured(),activitys.getAmountSecured()).longValue());
		// 参与者账户金额=退补贴
		master = usersService.selectByPrimaryKey(master);
		Assert.assertEquals(master.getBalance().longValue(), activitys.getSubsidies().longValue());
	}
}

package rongyun;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import rongyun.io.rong.ApiHttpClient;
import rongyun.io.rong.models.FormatType;
import rongyun.io.rong.models.SdkHttpResult;
import rongyun.io.rong.models.TxtMessage;

public class Example {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String key = "k51hidwq1bhvb";
		String secret = "Pov4sbSnu68c";

		SdkHttpResult result = null;
		//获取token测试
		String userId = "402880ef4a";
		String userName = null;
		String portraitUri = null;
		result = ApiHttpClient.getToken(key, secret, userId, userName,
				portraitUri, FormatType.json);
		System.out.println("gettoken=" + result);
		System.out.println(result.getHttpCode());
		System.out.println(result.getResult());
		JSONObject json = JSONObject.parseObject(result.getResult());
		System.out.println("code:" + json.getString("code"));
		System.out.println("userId:" + json.getString("userId"));
		System.out.println("token:" + json.getString("token"));
		
		String toId = "123456";
		List<String> toIds = new ArrayList<String>();
		toIds.add("10303");
//		toIds.add("id2");
//		toIds.add("id3");
		
		Integer iconType = 1;
		String notice = "这是通知栏通知！";
		String title = "这是标题！";
		String content = "这是消息内容";
		String headIcon = "http://himg.bdimg.com/sys/portrait/item/14452020.jpg";
		BigDecimal rich = new BigDecimal("1");
		Integer operateType = 1;
		String operateUrl = "123456";
		Integer targetType = 1;
		String targetUrl = "http://f.picphotos.baidu.com/album/s%3D900%3Bq%3D90/sign=7cb2c1ef9e82d158bf8255b1b03168e5/4d086e061d950a7bafb309c508d162d9f2d3c929.jpg";
		
		/**
		 * 自定义一对一系统消息
		 */
//		result = ApiHttpClient.publishSingleMessage("1", "10303", new SystemMessage(iconType, notice, title, content, headIcon, rich, operateType, operateUrl, targetType, targetUrl));
//		System.out.println("自定义一对一系统消息publishSingleMessage=" + result);
//		/**
//		 * 自定义一对多系统消息
//		 */
//		result = ApiHttpClient.publishMassMessage("1", toIds, new SystemMessage(iconType, notice, title, content, headIcon, rich, operateType, operateUrl, targetType, targetUrl));
//		System.out.println("自定义一对多系统消息publishSingleMessage=" + result);
//		
//		
//		/**
//		 * 自定义一对一系统消息,客户端拼接content
//		 */
//		result = ApiHttpClient.publishSingleMessage("1", toId, new SystemMessage(iconType, notice, title, activity, headIcon, rich, operateType, operateUrl, targetType, targetUrl));
//		System.out.println("自定义一对一系统消息publishSingleMessage=" + result);
//		/**
//		 * 自定义一对多系统消息,客户端拼接content
//		 */
//		result = ApiHttpClient.publishMassMessage("1", toIds, new SystemMessage(iconType, notice, title, activity, headIcon, rich, operateType, operateUrl, targetType, targetUrl));
//		System.out.println("自定义一对多系统消息publishSingleMessage=" + result);
//		
//		
//		result = ApiHttpClient.publishGroupInfoNtfMessage("1", "123456", new InfoNtfMessage("这是小灰条消息"));
//		System.out.println("小灰条消息publishGroupInfoNtfMessage=" + result);
//		
//		
		//文字消息
		result = ApiHttpClient.publishMessage(key, secret, "111", toIds,
				new TxtMessage("我是风清扬。", "==============这是我的附带消息。================="), FormatType.json);
		System.out.println(new TxtMessage("我是风清扬。", "==============这是我的附带消息。=================").toString());
		System.out.println("文字消息publishMessage=" + result);
//		//语音消息
//		result = ApiHttpClient.publishMessage(key, secret, "1", toIds,
//				new VoiceMessage("txtMessagehaha", 100L), FormatType.json);
//		System.out.println("语音消息publishMessage=" + result);
//		//图片消息
//		result = ApiHttpClient.publishMessage(key, secret, "1", toIds,
//				new ImgMessage("txtMessagehaha", "http://aa.com/a.png"),
//				FormatType.json);
//		System.out.println("图片消息publishMessage=" + result);
//		//自定义push文字消息
//		result = ApiHttpClient.publishMessage(key, secret, "1", toIds,
//				new TxtMessage("txtMessagehaha"), "pushContent", "pushData",
//				FormatType.json);
//		System.out.println("publishMessageAddpush=" + result);
//		//自定义push系统消息
//		result = ApiHttpClient.publishSystemMessage(key, secret, "1",
//				toIds, new TxtMessage("txtMessagehaha"), "pushContent",
//				"pushData", FormatType.json);
//		System.out.println("publishSystemMessage=" + result);
//
//		result = ApiHttpClient.publishSystemMessage(key, secret, "1",
//				toIds, new TxtMessage("txtMessagehaha"), "pushContent",
//				"pushData", FormatType.json);
//		System.out.println("publishSystemMessage=" + result);
//		/**
//		 * 聊天室部分
//		 */
//		List<ChatroomInfo> chats = new ArrayList<ChatroomInfo>();
//		chats.add(new ChatroomInfo("idtest", "name"));
//		chats.add(new ChatroomInfo("id%s+-{}{#[]", "name12312"));
//		
//		//创建聊天室消息
//		result = ApiHttpClient.createChatroom(key, secret, chats,
//				FormatType.json);
//		System.out.println("createchatroom=" + result);
//		List<String> chatIds = new ArrayList<String>();
//		chatIds.add("id");
//		chatIds.add("id%+-:{}{#[]");
//		//查询聊天室信息
//		result = ApiHttpClient.queryChatroom(key, secret, chatIds,
//				FormatType.json);
//		System.out.println("queryChatroom=" + result);
//		// 发送聊天室消息
//		result = ApiHttpClient.publishChatroomMessage(key, secret,
//				"1", chatIds, new TxtMessage("txtMessagehaha"),
//				FormatType.json);
//		System.out.println("publishChatroomMessage=" + result);
//		// 销毁聊天室
//		result = ApiHttpClient.destroyChatroom(key, secret, chatIds,
//				FormatType.json);
//		System.out.println("destroyChatroom=" + result);
//		List<GroupInfo> groups = new ArrayList<GroupInfo>();
//		groups.add(new GroupInfo("id1", "name1"));
//		groups.add(new GroupInfo("id2", "name2"));
//		groups.add(new GroupInfo("id3", "name3"));
//		// 同步用户群信息
//		result = ApiHttpClient.syncGroup(key, secret, "userId1", groups,
//				FormatType.json);
//		System.out.println("syncGroup=" + result);
//		result = ApiHttpClient.joinGroup(key, secret, "userId2", "id1",
//				"name1", FormatType.json);
//		System.out.println("joinGroup=" + result);
//		List<String> list = new ArrayList<String>();
//		list.add("userId3");
//		list.add("userId1");
//		list.add("userId3");
//		list.add("userId2");
//		list.add("userId3");
//		list.add("userId3");
//		result = ApiHttpClient.joinGroupBatch(key, secret, list, "id1",
//				"name1", FormatType.json);
//		System.out.println("joinGroupBatch=" + result);
//
//		result = ApiHttpClient.publishGroupMessage(key, secret, "userId1",
//				chatIds, new TxtMessage("txtMessagehaha"), "pushContent",
//				"pushData", FormatType.json);
//		System.out.println("publishGroupMessage=" + result);
//		//退出群
//		result = ApiHttpClient.quitGroup(key, secret, "userId1", "id1",
//				FormatType.json);
//		System.out.println("quitGroup=" + result);
//		result = ApiHttpClient.quitGroupBatch(key, secret, list, "id1",
//				FormatType.json);
//		System.out.println("quitGroupBatch=" + result);
//		result = ApiHttpClient.dismissGroup(key, secret, "userIddismiss",
//				"id1", FormatType.json);
//		result = ApiHttpClient.getMessageHistoryUrl(key, secret, "2014112811",
//				FormatType.json);
//		System.out.println("getMessageHistoryUrl=" + result);
//
//		result = ApiHttpClient.blockUser(key, secret, "2", 10,FormatType.json);
//		System.out.println("blockUser=" + result);
//
//		result = ApiHttpClient.blockUser(key, secret, "id2", 10,FormatType.json);
//		System.out.println("blockUser=" + result);
//
//		result = ApiHttpClient.blockUser(key, secret, "id3", 10,FormatType.json);
//		System.out.println("blockUser=" + result);
//
//		result = ApiHttpClient.queryBlockUsers(key, secret, FormatType.json);
//		System.out.println("queryBlockUsers=" + result);
//
//		result = ApiHttpClient.unblockUser(key, secret, "id1", FormatType.json);
//		System.out.println("unblockUser=" + result);
//
//		result = ApiHttpClient.queryBlockUsers(key, secret, FormatType.json);
//		System.out.println("queryBlockUsers=" + result);
//
//		result = ApiHttpClient.unblockUser(key, secret, "id2", FormatType.json);
//		System.out.println("unblockUser=" + result);
//
//		result = ApiHttpClient.unblockUser(key, secret, "id3", FormatType.json);
//		System.out.println("unblockUser=" + result);
//
//		result = ApiHttpClient.queryBlockUsers(key, secret, FormatType.json);
//		System.out.println("queryBlockUsers=" + result);
//
//		result = ApiHttpClient.checkOnline(key, secret, "143", FormatType.json);
//		System.out.println("checkOnline=" + result);
//		
//		List<String> toBlackIds = new ArrayList<String>();
//		toBlackIds.add("22");
//		toBlackIds.add("12");
//
//		result = ApiHttpClient.blackUser(key, secret, "3706", toBlackIds,
//				FormatType.json);
//		System.out.println("blackUser=" + result);
//		
//		result = ApiHttpClient.QueryblackUser(key, secret, "3706",FormatType.json);
//		System.out.println("QueryblackUser=" + result);
//		
//		result = ApiHttpClient.unblackUser(key, secret, "3706", toBlackIds,
//				FormatType.json);
//		System.out.println("unblackUser=" + result);
//		
//		result = ApiHttpClient.QueryblackUser(key, secret, "3706",FormatType.json);
//		System.out.println("QueryblackUser=" + result);	
//
//		result = ApiHttpClient.deleteMessageHistory(key, secret, "2014122811",
//				FormatType.json);
//		System.out.println("deleteMessageHistory=" + result);
//		
//		result = ApiHttpClient.refreshGroupInfo(key, secret, "id1", "name4",
//				FormatType.json);
//		System.out.println("refreshGroupInfo=" + result);

	}
	
	
	
}

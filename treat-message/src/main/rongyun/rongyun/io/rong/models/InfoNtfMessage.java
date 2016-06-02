package rongyun.io.rong.models;

import rongyun.io.rong.util.GsonUtil;

//提示条（小灰条）通知消息
public class InfoNtfMessage extends Message {

	private String message;
	private String extra;

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	public InfoNtfMessage(String message) {
		this.type = "RC:InfoNtf";
		this.message = message;
	}

	public InfoNtfMessage(String message,String extra) {
		this(message);
		this.extra = extra;
	}

	public String Message() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return GsonUtil.toJson(this, InfoNtfMessage.class);
	}
}

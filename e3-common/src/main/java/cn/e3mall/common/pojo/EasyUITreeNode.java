package cn.e3mall.common.pojo;

import java.io.Serializable;
/**
 * 
 * @Description easyUI 树控件，数据模型
 * @author 席春光
 * @date 2018年3月7日
 *
 */
@SuppressWarnings("serial")
public class EasyUITreeNode implements Serializable {
	private long id;
	private String text;
	private String state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}

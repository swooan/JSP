package org.comstudy21;

public class LeftItem {
	public String itemName;
	public String link;
	
	public LeftItem(String itemName, String link) {
		this.itemName=itemName;
		this.link = link;
	}
	
	public String getTag() {
		return "<li><a href=\"" + link + "\">" + itemName + "</a></li>";
	}
}

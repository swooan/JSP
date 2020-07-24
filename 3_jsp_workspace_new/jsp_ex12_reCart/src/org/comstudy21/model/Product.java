package org.comstudy21.model;

public class Product {
	private int idx;
	private String title;
	private int price;
	
	public Product() {
		idx=0;
		title = "";
		price = 0;
	}

	public Product(int idx, String title, int price) {
		this.idx = idx;
		this.title = title;
		this.price = price;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [idx=" + idx + ", title=" + title + ", price=" + price + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + idx;
//		result = prime * result + price;
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		if (idx != other.idx)
//			return false;
//		if (price != other.price)
//			return false;
//		if (title == null) {
//			if (other.title != null)
//				return false;
//		} else if (!title.equals(other.title))
//			return false;
//		return true;
//	}
	
	public int hashcode() {
		return idx;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product p = (Product)obj;
			if(idx == p.getIdx()) {
				return true;
			}
		}
		return false;
	}
	
}

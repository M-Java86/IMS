package com.qa.ims.persistence.domain;

public class Items {

private Long id;
private String itemName;
private double cost;

public Items(String itemName, double cost) {
	this.setItemName(itemName);
	this.setCost(cost);
}

public Items(Long id, String itemName, double cost) {
	this.setId(id);
	this.setItemName(itemName);
	this.setCost(cost);
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

@Override
public String toString() {
	return "id:" + id + " item name:" + itemName + " cost:" + cost;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
	long temp;
	temp = Double.doubleToLongBits(cost);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

@Override
public boolean equals(Object object) {
	if (this == object)
		return true;
	if (object == null)
		return false;
	if (getClass() != object.getClass())
		return false;
	Items other = (Items) object;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (itemName == null) {
		if (other.itemName != null)
			return false;
	} else if (!itemName.equals(other.itemName))
		return false;
	if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
		return false;
	return true;
}

public Object readLatest() {
	// TODO Auto-generated method stub
	return null;
}

public Object update(Items updated) {
	// TODO Auto-generated method stub
	return null;
}

}
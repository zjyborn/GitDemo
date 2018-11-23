package bin;

import java.util.ArrayList;
import java.util.List;

public class Easybuy_category {
  private int epc_id;
  private String epc_name;
  private int epc_parent_id;//父亲id
  private List< Easybuy_category> categorys=new ArrayList< Easybuy_category>();
  
public List<Easybuy_category> getCategorys() {
	return categorys;
}

public void setCategorys(List<Easybuy_category> categorys) {
	this.categorys = categorys;
}

public Easybuy_category() {
	super();
}

public Easybuy_category(int epc_id, String epc_name, int epc_parent_id) {
	super();
	this.epc_id = epc_id;
	this.epc_name = epc_name;
	this.epc_parent_id = epc_parent_id;
}

public int getEpc_id() {
	return epc_id;
}

public void setEpc_id(int epc_id) {
	this.epc_id = epc_id;
}

public String getEpc_name() {
	return epc_name;
}

public void setEpc_name(String epc_name) {
	this.epc_name = epc_name;
}

public int getEpc_parent_id() {
	return epc_parent_id;
}

public void setEpc_parent_id(int epc_parent_id) {
	this.epc_parent_id = epc_parent_id;
}

@Override
public String toString() {
	return "Easybuy_category [epc_id=" + epc_id + ", epc_name=" + epc_name + ", epc_parent_id=" + epc_parent_id + "]";
}
  
}

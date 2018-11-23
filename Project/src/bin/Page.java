/**
 * 
 */
package bin;

/**页面
 * @author oracleOAEC
 *
 */
public class Page {
  private int pagesize; //每页数量
  private int totalpage;//总页数
  private int countpagesize;//总数量      总页数=总数量/每页数量
  private int currentpage;//当前页
  
public Page() {
	super();
}

public Page(int pagesize, int totalpage, int countpagesize, int currentpage) {
	super();
	this.pagesize = pagesize;
	this.totalpage = totalpage;
	this.countpagesize = countpagesize;
	this.currentpage = currentpage;
}

public int getPagesize() {
	return pagesize;
}

public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}

public int getTotalpage() {
	return totalpage;
}
  //总页数
public void setTotalpage(int totalpage) {
	this.totalpage =countpagesize%pagesize==0?(countpagesize/pagesize):(countpagesize/pagesize)+1;
}

public int getCountpagesize() {
	return countpagesize;
}

public void setCountpagesize(int countpagesize) {
	this.countpagesize = countpagesize;
}

public int getCurrentpage() {
	return currentpage;
}

public void setCurrentpage(int currentpage) {
	this.currentpage = currentpage;
}

@Override
public String toString() {
	return "Page [pagesize=" + pagesize + ", totalpage=" + totalpage + ", countpagesize=" + countpagesize
			+ ", currentpage=" + currentpage + "]";
}
  
}

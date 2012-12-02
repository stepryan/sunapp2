package sunapp;
import java.util.ArrayList;
import java.util.Iterator;


public class ImageList {
	@SuppressWarnings("rawtypes")
	ArrayList<String> ImageList =new ArrayList<String>();
	String Time;
	String Provider;
	String Source;
	String Instrument;
	String PhysObs;
	String Wave;
	String Extent;
	String Field;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ImageList(){
		this.ImageList = new ArrayList();
		this.ImageList.add(Time );
		this.ImageList.add(Provider);
		this.ImageList.add(Source );
		this.ImageList.add(Instrument );
		this.ImageList.add(PhysObs );
		this.ImageList.add(Wave );
		this.ImageList.add(Extent );
		this.ImageList.add(Field );
	}

}

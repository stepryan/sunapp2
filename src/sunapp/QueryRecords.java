package sunapp;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;

public class QueryRecords {
	
	public int Records(){
		int count;
		client=vso.VSOClient()
				qr=client.query_legacy(tstart='2001/01/01', tend='2001/01/02', instrument='EIT')
					 count =	qr.num_records()
						qr.show()
						return count;
	}
	
}

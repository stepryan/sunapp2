package sunapp;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;

import sunpy;
import matplotlib.pyplot as plt
from sunpy.net.helioviewer import HelioviewerClient
public class DisplayImage {

		public  void Image() throws PyException{
			hv = HelioviewerClient()
			datasources = hv.get_data_sources()
					hv.download_png('2009/01/01', 4.8, "[SDO,AIA,AIA,304,1,100]", x0=0, y0=0, width=512, height=512)
			
		}
}

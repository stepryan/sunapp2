package sunapp;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;

import sunpy;


public class DisplayImage {

		public static void Image() throws PyException{
			from matplotlib import cm
			from matplotlib import colors
			aia = sunpy.make_map(sunpy.AIA_171_IMAGE)
			aia.show(cmap=cm.hot, norm=colors.Normalize(1, 2048))
	
			
		}
}

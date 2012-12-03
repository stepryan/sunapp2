package sunapp;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;

import sunpy;
import matplotlib.pyplot as plt

public class DisplayImage {

		public  void Image() throws PyException{
			

			aia = sunpy.make_map(sunpy.AIA_171_IMAGE)

			fig = plt.figure()
			ax = plt.subplot(111)

			aia.plot()
			plt.colorbar()
			aia.draw_limb()

			plt.show()
		}
}

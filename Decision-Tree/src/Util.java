import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class Util {
	
	private Util() {}
	
	//READ CSV FILE STORE TUPLES INTO DATABASE
		public static DataSet readCSV(String filePath) {
			
			Scanner in;
			DataSet dataset = new DataSet();
			
			try {
				
				in = new Scanner(new File(filePath));
				
				/*TODO: IF FIRST ROW IS INFORMATION
				String str = in.next();*/
				double maxCount = Double.MIN_VALUE;
				while(in.hasNext()) {
					//dataset.add(new Attribute());
					String[] strAttrs = in.next().split(",");
					
					dataset.data.add(strAttrs);
					String c = strAttrs[strAttrs.length-1];
					if(dataset.classes.containsKey(c)) {
						dataset.classes.put(c, dataset.classes.get(c) + 1);
					} else {
						dataset.classes.put(c, 1.0);
					}
					if(dataset.classes.get(c) > maxCount) {
						maxCount = dataset.classes.get(c);
						dataset.majorityClass = c;
					}
					
					/*while(dataset.size() < strAttrs.length) {	
						dataset.add(new Attribute());
					}
					
					for (int i = 0; i < strAttrs.length; i++) {
						if (!strAttrs[i].isEmpty()){
							dataset.get(i).nodes.add(strAttrs[i]);
						}
					}*/
				}
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
			
			return dataset;
		}

		public static void printDataSet(DataSet dataset) {
			for (String[] attr : dataset.data) {
				for (String string : attr) {
					System.out.print(string + ",");
				}
				System.out.println();
			}
		}

}

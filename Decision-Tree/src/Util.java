import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

		public static void printTree(Node root) {
			Queue<Node> list = new LinkedList();
			list.add(root);
			int curc= root.branches.size();
			int ncurc = 0;
			System.out.println(" A:" + root.attr);
			while (!list.isEmpty()) {
				Node cur = list.remove();
				for (BranchDecision branch : cur.branches) {
					System.out.print(" B:" + branch.equalTo + "->");
					if(branch.resultant.attr != -1) {
						System.out.print(" A:" +branch.resultant.attr);
						list.add(branch.resultant);
						ncurc += branch.resultant.branches.size();
					} else
						System.out.print(" L:" + branch.resultant.label);
					System.out.print(",");
					curc--;
				}
				System.out.print("||");
				if(curc == 0) {
					curc = ncurc;
					ncurc = 0;
					System.out.println();
				}
			}
		}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TooManyListenersException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* The 1st question was Transaction logs.

A Company parses logs of online store user transactions/activity to flag fraudulent activity.

The log file is represented as an Array of arrays. The arrays consist of the following data:

[ <# of transactions>]

For example:

[345366 89921 45]

Note: the data is space delimited

So, the log data would look like:

[
[345366 89921 45],
[029323 38239 23]
...
]
Write a function to parse the log data to find distinct users that meet or cross a certain threshold.

The function will take in 2 inputs:
logData: Log data in form an array of arrays

threshold: threshold as an integer

Output:
It should be an array of userids that are sorted.

If same userid appears in the transaction as userid1 and userid2, it should count as one occurrence, not two.

Example:
Input:
logData:

[
[1 2 45],
[4 1 23],
[3 5 15],
[2 2 77],
[1 4 23],
[2 5 13]
...
]
threshold: 3 */
public class TransactionLogs_Amazon {

	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(in);
		String line=br.readLine();
		BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\SasmitaPradhan\\Desktop\\Logs.txt"));
		int logsCount= Integer.parseInt(line.trim());
		List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
			try {
				return br.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(Collectors.toList());
		
		int threshold = Integer.parseInt(br.readLine().trim());
		List<String> result = processLogs(logs,threshold);
		
		wr.write(result.stream().collect(Collectors.joining("\n")) + "\n");
		
		br.close();
		wr.close();
		
		
		
		
		
		/*
		 * List<String> input = new ArrayList<>();
		 * 
		 * 
		 * input.add("4 4 77"); input.add("1 4 23"); input.add("4 5 13");
		 * input.add("2 2 45"); input.add("2 1 23"); input.add("3 2 15");
		 * 
		 * processLogs(input, 3).forEach(System.out::println);
		 */

	}



	private static List<String> processLogs(List<String> logs, int threshold) {
		HashMap<String, Integer> logM = new HashMap<>();
		for(String logR : logs) {
			String[] log = logR.split(" ");
			
			logM.put(log[0], logM.getOrDefault(log[0], 0)+1);
			if(!(log[0].equals(log[1])))
			logM.put(log[1], logM.getOrDefault(log[1], 0)+1);	
		}
		
		List<String> userIds= new ArrayList<>();
		for(Map.Entry<String, Integer> mp: logM.entrySet()) {
			if(mp.getValue() >= threshold) {
				userIds.add(mp.getKey());
			}
		}
		System.out.println(userIds);
		
		//Collections.sort(userIds);
		/*
		 * Collections.sort(userIds, new Comparator<String>(){
		 * 
		 * @Override public int compare(String s1, String s2) {
		 * System.out.println(Integer.parseInt(s1)-Integer.parseInt(s2)); return
		 * Integer.parseInt(s1)-Integer.parseInt(s2); } });
		 */
		
	
		return userIds;
		
	}
	

}

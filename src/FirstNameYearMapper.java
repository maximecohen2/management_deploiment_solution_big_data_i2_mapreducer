import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class FirstNameYearMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable linenumber, Text line, Mapper<LongWritable, Text, Text, IntWritable>.Context context) 
			throws IOException, InterruptedException {
		String[] fields = line.toString().split(";");
		String[] names = fields[0].split(" ");
		try {
			int age = Integer.parseInt(fields[1]);
			context.write(new Text(names[0]), new IntWritable(age));
		} catch (NumberFormatException e) {
			context.getCounter("Error", "bad format").increment(1);
		}
		
	}
}


/*public class FirstNameYearMapper extends Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>{

}*/

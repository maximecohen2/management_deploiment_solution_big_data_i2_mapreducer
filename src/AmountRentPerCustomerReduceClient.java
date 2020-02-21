import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class AmountRentPerCustomerReduceClient extends Configured implements Tool {
	
	@Override
	public int run(String[] args) throws Exception {
		Job job = Job.getInstance(this.getConf(), "AmountRentPerCustomer");
		
		job.setJarByClass(this.getClass()); // Quel jar pour mapReduce
		job.setMapperClass(AmountRentPerCustomerMapper.class); // Quelle class pour mapper
		job.setReducerClass(AmountRentPerCustomerReducer.class); // Quelle class pour reducer
		job.setMapOutputKeyClass(Text.class); // Quelle type de sortie de mapper / Entrée du reducer pour clé
		job.setMapOutputValueClass(FloatWritable.class); // Quelle type de sortie de mapper / Entrée du reducer pour clé
		job.setInputFormatClass(TextInputFormat.class); // format d'entrée du mapper
		job.setOutputFormatClass(TextOutputFormat.class); // format de sortie du reducer
		FileInputFormat.addInputPath(job, new Path(args[0])); // Chemin des fichiers d'entrée
		FileOutputFormat.setOutputPath(job, new Path(args[1])); // Chemin des fichiers de sortie
		
		return job.waitForCompletion(true) ? -1 : 0;
	}

	public static void main(String[] args) throws Exception {
		System.exit(ToolRunner.run(new Configuration(), new AmountRentPerCustomerReduceClient(), args));

	}

}

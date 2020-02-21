import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FilmMostRentByRatingReducer extends Reducer<Text, Text, Text, Text>{
	@Override
	protected void reduce(Text rating, Iterable<Text> filmList, Reducer<Text, Text, Text, Text>.Context context) 
			throws IOException, InterruptedException {
		Map<String, Integer> filmRents = new HashMap<String, Integer>();
		for (Text film : filmList)
		{
			int count = filmRents.containsKey(film.toString()) ? filmRents.get(film.toString()) : 0;
			filmRents.put(film.toString(), count + 1);
		}
		
		Map.Entry<String, Integer> maxEntry = null;
		for (Map.Entry<String, Integer> entry : filmRents.entrySet())
		{
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			{
				maxEntry = entry;
			}
		}
		context.write(rating, new Text(maxEntry.getKey()));
	}
}
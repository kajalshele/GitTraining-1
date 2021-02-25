import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class KajalShele {
    public static void main(String[] args) throws IOException, CsvException {
        Reader reader= Files.newBufferedReader(Paths.get("Car_sales.csv"));

        CSVParser parser=new CSVParserBuilder()
                .withSeparator(',')
                .build();

        CSVReader obj=new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .build();

        List<String []> answer=obj.readAll().stream()
                .skip(1)
                .filter(x->x[13].equals("17.2"))
                .collect(Collectors.toList());

        answer.stream()
                .limit(6)
                .forEach(x->System.out.println(x[13]));

    }
}
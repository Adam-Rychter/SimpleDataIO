package SImpleDataIO;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;

public class SimpleDataCsv {


    public static <T> Collection<T> readCsv(String path, Class<T> type, Collection<T> collection) throws IOException {

        ObjectReader oReader = new CsvMapper().readerFor(type).with(CsvSchema.emptySchema().withHeader());
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        InputStreamReader inputStreamReader;

        File file = new File(path);
        if(file.canRead()) {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream, 1024);
            inputStreamReader = new InputStreamReader(bufferedInputStream, "UTF-8");
            MappingIterator<T> mi = oReader.readValues(inputStreamReader);
            while (mi.hasNext()) {
                collection.add(mi.next());
            }
        }

        return collection;
    }

    public static <T> Boolean writeCsv(String path, Collection<T> collection) {

        return true;
    }

//    public Boolean writeCsv(String path, Collection<?> data) {
//        return null;
//    }
//
//    public Collection<?> readCsv(String path, Class<?> dataClass) {
//        return null;
//    }


}

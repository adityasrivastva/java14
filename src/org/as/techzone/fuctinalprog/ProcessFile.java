/*
    Four-step process to apply the execute-around pattern
 */
package org.as.techzone.fuctinalprog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {
    public static String processFile () throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))){
            return br.readLine() ;
        }
    }

    public static String processFile( BufferedReaderProcessor p) throws
            IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
    public static void main(String[] args) throws IOException {
        String s = processFile();
        System.out.println(s);

        String oneLine = processFile ((BufferedReader br) ->
                br.readLine());
        String twoLines = processFile ((BufferedReader br) ->
                br.readLine() +" "+ br.readLine());
        System.out.println(oneLine);
        System.out.println(twoLines);
    }


}
@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}

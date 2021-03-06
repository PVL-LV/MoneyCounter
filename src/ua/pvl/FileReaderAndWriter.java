package ua.pvl;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaderAndWriter {

    private static  String inPath;
    private static String outPath;
    private static String currencyType;

    private static Map<String, Double> listOfAmountOfMoney = new HashMap<>();

    public List<String> listOnePersonsMoney = new ArrayList<>();

    public FileReaderAndWriter(List<UserParameters> userCommandList) {

        CommandGetter comGetter = new CommandGetter(userCommandList);

        inPath = comGetter.getInPath();
        outPath = comGetter.getOutPath();
        currencyType = comGetter.getCurrencyType();
    }

    FileParser fp = new FileParser();

    public void readFile() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inPath));
            String line;

            while ((line = br.readLine()) != null) {
                br.lines();

                if(!FileParser.isEndOfPersonMoneyLine(line)) {
                    listOnePersonsMoney.add(line);
                } else {
                    listOfAmountOfMoney.putAll(fp.parseAndCleanList(listOnePersonsMoney, currencyType));
                    listOnePersonsMoney.clear();
                }
            }
        } catch (Exception e) {
            System.out.println("Some mistake");
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile()  throws IOException  {

        String wfp;
        PrintWriter pw;

        if (outPath != null) {
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(outPath), true), StandardCharsets.UTF_8));
        } else {
            pw = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        }

        try {
            for (Map.Entry<String, Double> entry : listOfAmountOfMoney.entrySet()) {
                wfp = (entry.getKey() + " = " + currencyType + entry.getValue() + "\r\n");
                pw.write(wfp);
            }
        }finally {
            pw.flush();
            pw.close();
        }
    }
}

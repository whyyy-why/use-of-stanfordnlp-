package tty;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.InputStreamReader;   
import java.io.BufferedWriter;   
import java.io.FileWriter;  
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
public class yyy {
	 /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static void readTxtFile(String filePath){
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null; 
                    File file2 =new File("outputhair.txt");
                    if(!file2.exists()){
             	           file2.createNewFile();
             	          }
                    
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	 ArrayList<String> tweets = new ArrayList<String>();
             	        tweets.add(lineTxt);
             	        NLP.init();
             	       FileWriter fileWritter = new FileWriter(file2.getName(),true);
             	           BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
             	        for(String tweet : tweets) {
             	           // System.out.println(tweet + " : " + NLP.findSentiment(tweet)); 
             	            bufferWritter.write(NLP.findSentiment(tweet)+"\r\n");   	     
             	        }
                               bufferWritter.close();

                    }  
                    System.out.println("Done");
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }
    public static void main(String argv[]){
        String filePath = "F:\\try3.txt";
        readTxtFile(filePath);
    }
}

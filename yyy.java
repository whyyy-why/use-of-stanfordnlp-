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
     * ���ܣ�Java��ȡtxt�ļ�������
     * ���裺1���Ȼ���ļ����
     * 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
     * 3����ȡ������������Ҫ��ȡ�����ֽ���
     * 4��һ��һ�е������readline()��
     * ��ע����Ҫ���ǵ����쳣���
     * @param filePath
     */
    public static void readTxtFile(String filePath){
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//���ǵ������ʽ
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
            System.out.println("�Ҳ���ָ�����ļ�");
        }
        } catch (Exception e) {
            System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
     
    }
    public static void main(String argv[]){
        String filePath = "F:\\try3.txt";
        readTxtFile(filePath);
    }
}

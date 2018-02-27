package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
//문제들을 저장하는 저장공간 ArrayList
public class QuizDataList extends ArrayList<QuizData> {
       
    /**
     * 퀴즈문제를 출제할수있도록
     * 해당 퀴즈데이터 읽어와서 ArrayList에 저장!
     * Data shuffle!
     * @param key
      */
    public void loadQuiz(int key) {
 
        String Path = "Quiz"+key+".dat";
        
        try {
            Scanner scan = new Scanner(new FileInputStream(Path),"UTF-8");
            while (scan.hasNext()) {
                //짝수줄 문제, 홀수줄 정답.
                //문제와 정답을 읽어와서 Arraylist에 추가
            	String q = scan.nextLine();
            	String a = scan.nextLine();
            	QuizData qd = new QuizData(q, a);
               
                this.add(qd);
            }
            System.out.println();
            Collections.shuffle(this); // 문제 섞는다.
         
        } catch (FileNotFoundException e) {
            System.out.println("예외 : " + e);
        }
    }// loadQuiz()
}
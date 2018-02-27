package app;

//하나의 문제를 저장하는 클래스 정의.
public class QuizData {
  private String question;
  private String answer;


  public QuizData() {
 
  }
 
  public QuizData(String question, String answer) {
      this.question = question;
      this.answer = answer;
  }


  public String getQuestion() {
      return question;
  }
  public String getAnswer() {
      return answer;
  }
 
  @Override
  public String toString() {
      return "Question [question=" + question + ", answer=" + answer + "]";
  }
 
 
}
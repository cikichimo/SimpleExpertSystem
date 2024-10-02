import java.util.*;


/**
 * UI sistem pakar untuk memeriksa apakah g bernilai true dari fakta a, b, c, f  
 * Sistem ini memiliki 4 pertanyaan yang akan diberikan pada user
 * 4 pertanyaan merepresentasikan 4 fakta
 * fact: a, b, c, f
 * conclussion: g
 * @author AERO
 */
public class UI {
    
    private ArrayList<String> questions;
    private int answers[];
    
    public UI()
    {
        this.answers = new int[4];
        this.questions = new ArrayList<String>();
        this.setQuestions();
    }
    
    private void setQuestions()
    {
        //Q1
        questions.add("Apakah Anda mengalami a?");
        //Q2
        questions.add("Apakah Anda mengalami b?");
        //Q3
        questions.add("Apakah Anda mengalami c?");
        //Q4
        questions.add("Apakah Anda mengalami f?");
    }
    
    public void showQuestion()
    {
        Scanner sc = new Scanner(System.in);
        int i =0;
        for(String q: this.questions)
        {
            System.out.println(q);
            System.out.println("0. Tidak    1.Ya");
            int a = sc.nextInt();
            while(a != 0 && a!=1)
            {
                System.out.println("Jawaban tidak sesuai!");
                a = sc.nextInt();
            }
            answers[i] = a;
            i++;
        }
    }
    
    public Set<String> getFacts()
    {
        Set<String> facts = new HashSet<>();
        if(answers[0] == 1)
            facts.add("a");
        if(answers[1] == 1)
            facts.add("b");
        if(answers[2] == 1)
            facts.add("c");
        if(answers[3] == 1)
            facts.add("f");
        return facts;
    }
    
    public void showConclussion(boolean gIsTrue, Set<String> facts, Set<String> inferedFacts)
    {
        System.out.println("All facts: " + facts);
        System.out.println("Inferred facts: " + inferedFacts);
        if(gIsTrue == true)
        {
            System.out.println("G terbukti benar");
        }
        else
        {
            System.out.println("G tidak terbukti");
        }
    }
    
    
}

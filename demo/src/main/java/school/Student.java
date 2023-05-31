package school;

public class Student {
    public int id;
    public String name;
    public double scores;
    public String grade;
    public Student(int id, String name, double scores, String grade)
    {
        super();
        this.id=id;
        this.name = name;
        this.scores=scores;
        this.grade = grade  ;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public double getScores()
    {
        return scores;
    }
    public void setScores(double scores)
    {
        this.scores=scores;
    }
    public String getGrade()
    {
        return grade;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
}

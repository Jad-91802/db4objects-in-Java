//Done by: Jared Gratz 16054972
public class Undergraduate extends Student
{
    private String yearOfStudy, averageMark;
    public Undergraduate(DegreeProgram obj, String studentNo, String first, String last, String year, String avg)
    {
        super(obj, studentNo, first, last);
        yearOfStudy = year;
        averageMark = avg;
    }
    public void setYear(String year)
    {
        yearOfStudy = year;
    }
    public void setAvg(String avg)
    {
        averageMark = avg;
    }
    public String toString()
    {
        return super.toString()+"/"+yearOfStudy+"/"+averageMark;
    }
}
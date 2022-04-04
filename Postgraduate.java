//Done by: Jared Gratz 16054972
public class Postgraduate extends Student
{
    private String supervisorInitials, supervisorSurname, researchTopic;
    public Postgraduate(DegreeProgram obj, String studentNo, String first, String last, String ini, String sur, String topic)
    {
        super(obj, studentNo, first, last);
        supervisorInitials = ini;
        supervisorSurname = sur;
        researchTopic = topic;
    }
    public void setIni(String ini)
    {
        supervisorInitials = ini;
    }
    public void setsur(String sur)
    {
        supervisorSurname = sur;
    }
    public void setTop(String top)
    {
        researchTopic = top;
    }
    public String toString()
    {
        return super.toString()+"/"+supervisorInitials+"/"+supervisorSurname+"/"+researchTopic;
    }
}

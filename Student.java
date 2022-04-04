//Done by: Jared Gratz 16054972
public class Student 
{
    private DegreeProgram degreeProgram;
    private String studentNumber, name, surname;
    public Student(DegreeProgram obj, String studentNo, String first, String last)
    {
        degreeProgram = obj;
        studentNumber = studentNo;
        this.name = first;
        surname = last;
    }
    public String toString()
    {
        return studentNumber+"/"+name+"/"+surname+"/"+degreeProgram.toString();
    }
}
//Done by: Jared Gratz 16054972
public class DegreeProgram 
{
    private String degreeName, department, faculty; 
    public DegreeProgram(String name, String dept, String fact)
    {
        degreeName = name;
        department = dept;
        faculty = fact;
    }
    public String toString()
    {
        return degreeName+"/"+department+"/"+faculty;
    }
}

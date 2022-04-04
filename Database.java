//Done by: Jared Gratz 16054972
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class Database
{
    private ObjectContainer database;
    private final String fileName = "database.db4o";
    public void open()
    {
        database = Db4o.openFile(fileName);
    }
    public void close()
    {
        database.close();
    }
    public void addDegreeProgram(BufferedReader reader) throws IOException
    {
        //TODO
        System.out.println("Adding a Degree...");
        System.out.println("Enter degree name: ");
        String name = reader.readLine();
        System.out.println("Enter department name: ");
        String dept = reader.readLine();
        System.out.println("Enter faculty name: ");
        String fact = reader.readLine();
        DegreeProgram degree = new DegreeProgram(name, dept, fact);
        database.store(degree);
        System.out.println("Adding a Degree... Done.");
    }
    public void addUndergraduate(BufferedReader reader) throws IOException
    {
        //TODO
        System.out.println("Adding an Undergraduate...");
        System.out.println("Enter degree name: ");
        String degName = reader.readLine();
        System.out.println("Enter student number: ");
        String studentNum = reader.readLine();
        System.out.println("Enter first name: ");
        String firstName = reader.readLine();
        System.out.println("Enter last name: ");
        String lastName = reader.readLine();
        System.out.println("Enter year of study: ");
        String year = reader.readLine();
        System.out.println("Enter average mark: ");
        String mark = reader.readLine();

        DegreeProgram obj;
        DegreeProgram proto = new DegreeProgram(degName, null, null);
        ObjectSet result = database.queryByExample(proto);
        if(result.isEmpty())
        {
            System.out.println("Adding a Degree...");
            System.out.println("Enter degree name: ");
            String name = reader.readLine();
            System.out.println("Enter department name: ");
            String dept = reader.readLine();
            System.out.println("Enter faculty name: ");
            String fact = reader.readLine();
            DegreeProgram degree = new DegreeProgram(name, dept, fact);
            obj = degree;
            System.out.println("Adding a Degree... Done.");
        }
        else
        {
            obj = (DegreeProgram) result.get(0);
        }

        Undergraduate student = new Undergraduate(obj, studentNum, firstName, lastName, year, mark);
        database.store(student);
        System.out.println("Adding an Undergraduate... Done.");
    }
    public void addPostgraduate(BufferedReader reader) throws IOException
    { 
        //TODO
        System.out.println("Adding an Postgraduate...");
        System.out.println("Enter degree name: ");
        String degName = reader.readLine();
        System.out.println("Enter student number: ");
        String studentNum = reader.readLine();
        System.out.println("Enter first name: ");
        String firstName = reader.readLine();
        System.out.println("Enter last name: ");
        String lastName = reader.readLine();
        System.out.println("Enter supervisor initials: ");
        String ini = reader.readLine();
        System.out.println("Enter supervisor surname: ");
        String sur = reader.readLine();
        System.out.println("Enter research topic: ");
        String topic = reader.readLine();
        
        DegreeProgram obj;
        DegreeProgram proto = new DegreeProgram(degName, null, null);
        ObjectSet result = database.queryByExample(proto);
        if(result.isEmpty())
        {
            System.out.println("Adding a Degree...");
            System.out.println("Enter degree name: ");
            String name = reader.readLine();
            System.out.println("Enter department name: ");
            String dept = reader.readLine();
            System.out.println("Enter faculty name: ");
            String fact = reader.readLine();
            DegreeProgram degree = new DegreeProgram(name, dept, fact);
            obj = degree;
            System.out.println("Adding a Degree... Done.");
        }
        else
        {
            obj = (DegreeProgram) result.get(0);
        }        
        Postgraduate student = new Postgraduate(obj, studentNum, firstName, lastName, ini, sur, topic);
        database.store(student);
        System.out.println("Adding an Postgraduate... Done.");
    }
    public void listStudents()
    {
        //TODO
        ObjectSet results = database.queryByExample(Student.class);
        output(results);
    }
    public void output(List set)
    {
        //TODO
        for(Object o : set)
        {
            System.out.println(o);
        }
    }
    public void findPostgraduate(BufferedReader reader) throws IOException
    {
        //TODO
        System.out.println("Finding a postgraduate student...");
        System.out.println("Enter student name: ");
        String name = reader.readLine();
        Postgraduate proto = new Postgraduate(null, null, name, null, null, null, null);
        ObjectSet result = database.queryByExample(proto);
        if(result.isEmpty())
        {
            System.out.println("Postgrad not found");
        }
        else
        {
            output(result);
        }
    }
    public void findUndergraduate(BufferedReader reader) throws IOException
    {
        //TODO
        System.out.println("Finding an undergraduate student...");
        System.out.println("Enter student name: ");
        String name = reader.readLine();
        Undergraduate proto = new Undergraduate(null, null, name, null, null, null);
        ObjectSet<Undergraduate> result = database.queryByExample(proto);
        if(result.isEmpty())
        {
            System.out.println("Undergrad not found");
        }
        else
        {
            System.out.println("Found: ");
            output(result);
        }
    }
    public void updateStudent(BufferedReader reader) throws IOException
    {
        //TODO
        System.out.println("Finding a student...");
        System.out.println("Enter student number: ");
        String num = reader.readLine();
        ObjectSet result = database.queryByExample(new Undergraduate(null, num, null, null, null, null));        
        if(!result.isEmpty())
        {
            Undergraduate unFound = (Undergraduate) result.get(0);
            System.out.println("Enter new year of study: ");
            String year = reader.readLine();
            System.out.println("Enter new average mark: ");
            String mark = reader.readLine();
            unFound.setYear(year);
            unFound.setAvg(mark);
            database.store(unFound);
        }
        else
        {
            Postgraduate proto = new Postgraduate(null, num, null, null, null, null, null);
            result = database.queryByExample(proto);            
            if(!result.isEmpty())
            {
                Postgraduate poFound = (Postgraduate) result.get(0);
                System.out.println("Enter new supervisor initials: ");
                String ini = reader.readLine();
                System.out.println("Enter new supervisor surname: ");
                String sur = reader.readLine();
                System.out.println("Enter new research topic: ");
                String topic = reader.readLine();
                poFound.setIni(ini);
                poFound.setsur(sur);
                poFound.setTop(topic);
                database.store(poFound);
            }
            else
            {
                System.out.println("Student not found");
            }
        }
    }
}
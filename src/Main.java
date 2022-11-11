import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {

        Vector<Integer> id = new Vector<>();
        Vector<String> first_name = new Vector<>();
        Vector<String> last_name = new Vector<>();
        Vector<String> gender = new Vector<>();
        Vector<String> job = new Vector<>();


        OpenFile("C:/Users/filof/OneDrive/Pulpit/java/Database/database.txt", id, first_name, last_name, gender, job);


        Scanner input = new Scanner(System.in);

        while (true)
        {

        System.out.println("\n");
        System.out.println("Choose one of these options(1-5): ");
        System.out.println("1.Show database");
        System.out.println("2.Add record");
        System.out.println("3.Delete record");
        System.out.println("4.Update record");
        System.out.println("5.Save and exit");

        int choose = Integer.parseInt(input.nextLine());

            switch (choose) {

                case 1 -> {
                    ShowDatabase(id, first_name, last_name, gender, job);
                    break;
                }

                case 2 -> {
                    AddRecord("C:/Users/filof/OneDrive/Pulpit/java/Database/database.txt", id,
                            first_name, last_name, gender, job);
                    break;
                }

                case 3 -> {
                    DeleteRecord("C:/Users/filof/OneDrive/Pulpit/java/Database/database.txt",
                            id, first_name, last_name, gender, job);
                    break;
                }

                case 4 -> {
                    Update(id, first_name, last_name, gender, job);
                    break;
                }

                case 5 -> {
                    SaveChanges("C:/Users/filof/OneDrive/Pulpit/java/Database/database.txt", id, first_name, last_name,
                            gender, job);

                    System.exit(1);
                    break;
                }
            }
        }





    }


    public static void OpenFile(String name, Vector<Integer> id, Vector<String> first_name, Vector<String> last_name,
                                Vector<String> gender, Vector<String> job)
    {
        try
        {
            File file = new File(name);
            Scanner scanner = new Scanner(file);

            int iterator = 1;

            while(scanner.hasNext())
            {

                String data = scanner.next();

                if(iterator > 5)
                {
                    iterator = 1;
                }

                if(iterator%5 == 0)
            {
                job.add(data);
            }
            else if(iterator%4 == 0)
            {
                gender.add(data);
            }
            else if(iterator%3 == 0)
            {
                last_name.add(data);
            }
            else if(iterator%2 == 0)
            {
                first_name.add(data);
            }
            else
            {
                id.add(Integer.parseInt(data));
            }

                iterator = iterator + 1;
            }
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println("Can't open this file");
        }

    }

    public static void ShowDatabase(Vector<Integer> id, Vector<String> first_name, Vector<String> last_name,
                                    Vector<String> gender, Vector<String> job)
    {

        if(id.isEmpty())
        {
            System.out.println("The database is empty");
        }

        for(int i=0; i<id.size(); i++)
        {
            System.out.println(id.get(i) + " " + first_name.get(i) + " " + last_name.get(i) + " " +
                    gender.get(i) + " " + job.get(i));
        }
    }

    public static void AddRecord(String name, Vector<Integer> id, Vector<String> first_name, Vector<String> last_name,
                                 Vector<String> gender, Vector<String> job) throws IOException {
        if(id.isEmpty())
        {
            id.add(1);
        }
        else
        {
            id.add(id.get(id.size()-1) + 1);
        }


        Scanner input = new Scanner(System.in);

        System.out.println("First name: ");
        first_name.add(input.nextLine());

        System.out.println("Last name: ");
        last_name.add(input.nextLine());

        System.out.println("Gender: ");
        gender.add(input.nextLine());

        System.out.println("Job: ");
        job.add(input.nextLine());



    }

    public static void DeleteRecord(String name, Vector<Integer> id, Vector<String> first_name, Vector<String> last_name,
                                 Vector<String> gender, Vector<String> job) throws IOException {
        Scanner input = new Scanner(System.in);



        System.out.println("Print id to delete record: ");

        int choosen_id = Integer.parseInt(input.nextLine());

        int pos_of_id = id.indexOf(choosen_id);

        try
        {
            if(id.get(pos_of_id) == choosen_id)
            {
                id.remove(pos_of_id);
                first_name.remove(pos_of_id);
                last_name.remove(pos_of_id);
                gender.remove(pos_of_id);
                job.remove(pos_of_id);
            }
        }
        catch (Exception e)
        {
            System.out.println("This record doesn't exist");
        }



    }


    public static void Update(Vector<Integer> id, Vector<String> first_name, Vector<String> last_name,
                              Vector<String> gender, Vector<String> job)
    {

        Scanner input = new Scanner(System.in);

        System.out.println("Type id: ");

        int choosen_id = Integer.parseInt(input.nextLine());

        int pos_of_id = id.indexOf(choosen_id);

        try
        {
            if(id.get(pos_of_id) == choosen_id)
            {
                System.out.println("\n");

                System.out.println("What do you want to change(1-4): ");
                System.out.println("1.First name");
                System.out.println("2.Last name");
                System.out.println("3.Gender");
                System.out.println("4.Job");

                System.out.println("\n");

                int choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1 -> {
                        System.out.println("Type new first name: ");
                        String new_first_name = input.nextLine();
                        first_name.set(pos_of_id,new_first_name);
                        System.out.println("\n");
                        break;
                    }

                    case 2 -> {
                        System.out.println("Type new last name: ");
                        String new_last_name = input.nextLine();
                        last_name.set(pos_of_id,new_last_name);
                        System.out.println("\n");
                        break;
                    }

                    case 3 -> {
                        System.out.println("Type new gender: ");
                        String new_gender = input.nextLine();
                        gender.set(pos_of_id,new_gender);
                        System.out.println("\n");
                        break;
                    }

                    case 4 -> {
                        System.out.println("Type new job: ");
                        String new_job = input.nextLine();
                        job.set(pos_of_id,new_job);
                        System.out.println("\n");
                        break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("This record doesn't exist");
        }


    }

    public static void SaveChanges(String name, Vector<Integer> id, Vector<String> first_name, Vector<String> last_name,
                                   Vector<String> gender, Vector<String> job)
    {

        try
        {

            File file = new File(name);
            file.delete();
            file.createNewFile();
        FileWriter fr = new FileWriter(file, true);


        for(int i=0; i<id.size(); i++)
        {
            fr.write(id.get(i) + " " + first_name.get(i) + " " + last_name.get(i)
                    + " " + gender.get(i) + " " + job.get(i) + "\n");
        }


        fr.close();


        }
        catch (Exception e)
        {
            System.out.println("Can't open this file");
        }
    }

}
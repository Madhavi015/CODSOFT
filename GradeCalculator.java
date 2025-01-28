import java.util.Scanner;
public class GradeCalculator
{
    public static void main(String args[])
    {
        Scanner scanner =new Scanner(System.in);

        //Get the no. of subjects 
        System.out.println("Enter the no. of subjects: ");
        int numsubjects= scanner.nextInt();

        //Array to store marksfor each subject
        int[]marks =new int[numsubjects];

        //input marks for each subject
        int totalMarks= 0;
        for(int i= 0; i<numsubjects; i++)
        {
            System.out.print("Enter the marks of subject " +  (i + 1)  + " : ");
            marks[i]= scanner .nextInt();
            totalMarks+= marks[i];
        }
    
    //calculate avg percentage 
    double averagePercentage= (double)totalMarks / numsubjects;

    //determine grade
    char grade;
    if(averagePercentage>= 90)
    {
        grade= 'A';
    }
    else if (averagePercentage>=80)
    {
        grade ='B';
    }
    else if(averagePercentage>= 70)
    {
        grade ='C';
    }
    else if (averagePercentage >=60)
    {
        grade ='D';
    }
    else{
        grade ='F';
    }

    //Display results 
    System.out.println("Total Marks:" +totalMarks);
    System.out.println("Average Percentage:" +averagePercentage + "%");
    System.out.println("Grade:" + grade);

    scanner.close();
}
}



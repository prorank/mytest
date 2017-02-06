import java.util.Scanner;
public class BallotUI
{
   private Scanner keyboard;
   private BallotManager ballot;
    private String votingMessage;
    public BallotUI()
    {
       keyboard = new Scanner(System.in);
    }
    public void menu()   
    {
       int command = -1;
        while(command != 0)       
        {
          displayMainMenu();
           command = getCommand();
           execute(command);
        }
    }
    private void displayMainMenu()
   {
       System.out.println("Options are");
       System.out.println("    To vote for google         Enter 1");
       System.out.println("    To vote for microsoft      Enter 2");
        System.out.println("    To vote for amazon           Enter 3");
        System.out.println("    To vote for hp          Enter 4");
        System.out.println("To close    Enter 0");
    }
    private void execute(int command)
   {
      if(command == 1)
       {
          candidate1.incrementVoteCount();
       }
       else if(command == 2)
       {
          candidate2.incrementVoteCount();
       }
       else if(command == 3)
       {
      candidate3.incrementVoteCount();
       }
      else if(command == 4)
       {
       candidate4.incrementVoteCount();
       }           
      else if(command == 0)
      {
       System.out.println(" Program closing down");
       }
    else
       {
        System.out.println("Unknown command");
        candidate.castVote();
       }
   }
   private int getCommand()
  {
   System.out.print("Enter command: ");
   return keyboard.nextInt();
  }
  private void setupBallot()
   {
    return displayMainMenu();
  }
  private void setupVoteMessage(String vote)
  {
    }

}
public class Candidate
{
public static void main(String args[])
{
    private String name;   
    private int votes;
    public Candidate(String name)
    {       
    this.name = name;
    votes = 0;
   }
   public void setName(String name)
   {
    this.name = name;
   }
    public void incrementVoteCount()
   {
    votes++;
   }
    public String getName()
    {
       return name;
    }
    public int getNumberOfVotes()
   {
    return votes;
   }
private String Space(int)
    {
    }

 
   private String Star(int)
    {

    }


}
}
public class BallotManager
{
    private Candidate candidate1;
    private Candidate candidate2;
    private Candidate candidate3;
    private Candidate candidate4;
    private Candidate winner;
   public BallotManager(String cand1, String cand2, String cand3, String cand4)
   {
   this.candidate1 = new Candidate(cand1);
  this.candidate2 = new Candidate(cand2);
 this.candidate3 = new Candidate(cand3);
        this.candidate4 = new Candidate(cand4);
       this.winner = new Candidate("");
    }
    public void castVote(int vote)
    {
        if (vote == 1)
           candidate1.incrementVoteCount();
        else if (vote == 2)
            candidate2.incrementVoteCount();
        else if (vote == 3)
            candidate3.incrementVoteCount();
        else if (vote == 4)
            candidate4.incrementVoteCount();
    }

  public String reportResults()
    {
      findWinner();
    return drawGraph();
   }
    private void compareWinner(Candidate candidate)
    {
        int winningVote = 0;

       if(candidate1.getNumberOfVotes() > winningVote)
           winningVote = candidate1.getNumberOfVotes();
        if(candidate2.getNumberOfVotes() >= winningVote)
          winningVote = candidate2.getNumberOfVotes();
       if(candidate3.getNumberOfVotes() >= winningVote)
         winningVote = candidate3.getNumberOfVotes();
       if(candidate4.getNumberOfVotes() >= winningVote)
          winningVote = candidate4.getNumberOfVotes();
 
    if(winner.getNumberOfVotes() != winningVote)
          winner = candidate;
    }

   private void findWinner()
    {

        compareWinner(candidate1);

        compareWinner(candidate2);

        compareWinner(candidate3);
        compareWinner(candidate4);
 

    }




    private String drawGraph()

   { 
        return leader(winner.getName(), winner.getNumberOfVotes());
    }

    private String leader(String winner, int votes)
    {   drawGraph();

       return ("The winner of the ballot is" + winner.getName() + "with"

            + winner.getNumberOfVotes() + "\n" + "Results graph");

    }

 

    private String line(Candidate firstLine)

    {

   }

      }

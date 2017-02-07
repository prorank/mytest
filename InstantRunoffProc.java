import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.TreeSet;
import java.util.TreeMap;
import java.io.*;
public class InstantRunoffProc {
  private static boolean debugOn = true;     
  private static Random generator = new Random(); 
public static Set<String> getInitialCandidates(List<List<String>> ballots) {
    Set<String> candidateSet = new TreeSet<String>();
    
 for (List<String> ballot : ballots)
      if (ballot.size() > 0)
        candidateSet.add(ballot.get(0));  
    
    return candidateSet;
  }
  
  public static Map<String, Integer> countVotes(Set<String> candidates, 
      List<List<String>> ballots) {
    Map<String, Integer> voteTally = new TreeMap<String, Integer>();
    
   
    for (String candidate : candidates)
      voteTally.put(candidate, 0);
    
      for (List<String> ballot : ballots) {
   
      String topChoice = getTopChoice(ballot, candidates);
      if (topChoice != null) {
        int currentTally = voteTally.get(topChoice);
        voteTally.put(topChoice,  currentTally + 1);
      }
    }
    return voteTally; 
 }  
  
  public static String getTopChoice(List<String> ballot, Set<String> candidates) {
    Iterator<String> iter = ballot.iterator();
    while (iter.hasNext()) {
      String candidate = iter.next();
      if (candidates.contains(candidate))
        return candidate;
    }
    return null;
  }
  
  
  public static ArrayList<String> getLosers(Set<String> candidates, 
      Map<String, Integer> voteTally) {
    ArrayList<String> loserList = new ArrayList<String>();
    int minTally = Integer.MAX_VALUE;  
    
    for (String candidate : voteTally.keySet()) {
      int candidateTally = voteTally.get(candidate);
      if (candidateTally < minTally) {  
        loserList.clear();    
        loserList.add(candidate);      
        minTally = candidateTally;     
      }
      else if (candidateTally == minTally)
        loserList.add(candidate);       
    }
    return loserList;
  }
  
  
  public static String pickRandomItem(ArrayList<String> list) {
    return list.get(generator.nextInt(list.size()));
  }
  
  
  public static String runInstantRunoffElection(List<List<String>> ballots) {
    Set<String> candidates = getInitialCandidates(ballots);

    
      while (candidates.size() > 1) {
      Map<String, Integer> voteTally = countVotes(candidates, ballots);
      String loser = pickRandomItem(getLosers(candidates, voteTally));
      candidates.remove(loser);
      
      if (debugOn) {
        System.out.println("Vote tally:\n" + voteTally);
        System.out.println("Loser: " + loser);
      }
    }
    
    if (candidates.size() > 0)
      return candidates.iterator().next(); 
    else
      return null;
  }

  
  public static void main(String[] args) {
    List<List<String>> ballots = new ArrayList<List<String>>();
    List<String> ballot; 
    System.getProperty("File.seperator");
    
    String ballotFileName ="D:\\b.txt";
    Scanner ballotFile = null;
    try {
  
    
      ballotFile = new Scanner(new File(ballotFileName));
    }
    catch (FileNotFoundException e) {
      System.err.println("No such file: " + ballotFileName);
      System.exit(1);
    }
    
    while (ballotFile.hasNext()) {
      String line = ballotFile.nextLine();
      ballot = new ArrayList<String>();
      Scanner inLine = new Scanner(line);
      
      while (inLine.hasNext()) {
        String candidate = inLine.next();
        ballot.add(candidate);
      }
      ballots.add(ballot);
    }
    
    String winner = runInstantRunoffElection(ballots);
    if (winner != null)
      System.out.println("The winner is: " + 
        winner);
    else
      System.out.println("No valid votes cast");
  }
}
package P2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Enterprise implements Spaceship{

    private int poundsOfFood;
    private List<String> visitedPlanets;
    private List<String> crewNames;
    private HashMap<String,Integer> requiredFoodForCrewMembers;

    public Enterprise(int initialPoundsOfFood){
        this.poundsOfFood = initialPoundsOfFood;
        this.visitedPlanets = new ArrayList<>();
        this.crewNames = new ArrayList<>();
        requiredFoodForCrewMembers = new HashMap<>();
    }

    public void board(String crewMemberName, int foodPerDay) {
        crewNames.add(crewMemberName);
        requiredFoodForCrewMembers.put(crewMemberName, foodPerDay);
    }

    public void unboard(String crewMemberName) {
        removeCrewMemberFromListOfCrewNames(crewMemberName);
        requiredFoodForCrewMembers.remove(crewMemberName);
    }

    private void removeCrewMemberFromListOfCrewNames(String crewMemberName){
        for(int i=0; i<crewNames.size(); i++){
            if(crewNames.get(i).equals(crewMemberName)){
                crewNames.remove(i);
                break;
            }
        }
    }

    public String getPlanetsVisited() {
        return visitedPlanets.stream().collect(Collectors.joining(",","[","]"));
    }

    public boolean flyTo(String planetName, int daysRequired) {
        int foodPoundsNeeded = foodNeeded(daysRequired);
        if(foodPoundsNeeded <= this.poundsOfFood){
            this.poundsOfFood -= foodPoundsNeeded;
            this.visitedPlanets.add(planetName);
            return true;
        }
        return false;
    }

    private int foodNeeded(int numberOfDays){
        if(numberOfDays == 0) return 0;

        int foodForADay = 0;
        for(String crewMember : requiredFoodForCrewMembers.keySet()){
            foodForADay += requiredFoodForCrewMembers.get(crewMember);
        }
        return foodForADay * numberOfDays;
    }

    public List<String> getCrewNames(){
        return this.crewNames;
    }
}

package P2;

public interface Spaceship{

    /**
     * Boards a crew member with the given food intake. This crew member will now consume food during trips.
     */
    public void board(String crewMemberName, int foodPerDay);

    /**
     * Unboards a crew member with the given name from the ship. This crew member is no longer on the ship and no longer consumes food.
     */
    public void unboard(String crewMemberName);

    /**
     * Returns a String of visited planets, in order of visit. The string should be formatted like “[Earth, Mars, Venus]”
     */
    public String getPlanetsVisited();

    /**
     * Attempts to fly to a planet, which takes the given number of days.
     */
    public boolean flyTo(String planetName, int daysRequired);
}

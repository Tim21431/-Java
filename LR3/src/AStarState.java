import java.util.HashMap;
 /** This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    /** два (нестатических) поля в класс AStarState с таким типом, одно
     * для "открытых вершин" и другой для "закрытых вершин"**/
    private Map2D map;
    private HashMap<Location, Waypoint>openWaypoints;
    private HashMap<Location, Waypoint>closedWaypoints;
    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");
        this.map = map;
        this.openWaypoints = new HashMap<Location, Waypoint>();
        this.closedWaypoints = new HashMap<Location, Waypoint>();
    }

    /** Возвращает карту, по которой перемещается навигатор A*. **/
    public Map2D getMap() {
        return map;
    }
    /** Эта функция должна проверить все вершины в наборе открытых вершин,
     * и после этого она должна вернуть ссылку на вершину с наименьшей общей
     * стоимостью. Если в "открытом" наборе нет вершин, функция возвращает NULL.*/
    public Waypoint getMinOpenWaypoint() {
        if(openWaypoints.isEmpty())
            return null;
        else{
            Waypoint minCostWaypoint = null;
            float minCost = Float.MAX_VALUE;
            for(Waypoint wp:openWaypoints.values()){
                float totalCost = wp.getTotalCost();
                if(totalCost<minCost){
                    minCostWaypoint = wp;
                    minCost = totalCost;
                }
            }
            return minCostWaypoint;
        }
    }

    /**
     * Если в наборе «открытых вершин» в настоящее время нет вершины
     * для данного местоположения, то необходимо просто добавить новую вершину.
     * Если в наборе «открытых вершин» уже есть вершина для этой * локации
     * добавьте новую вершину только в том случае, если стоимость пути до
     * новой вершины меньше стоимости пути до текущей.
     **/
    public boolean addOpenWaypoint(Waypoint newWP) {
        Location loc = newWP.getLocation();
        if(!openWaypoints.containsKey(loc)){
            openWaypoints.put(loc, newWP);
                    return true;
        }
        else{
            Waypoint oldWP = openWaypoints.get(loc);
            if(newWP.getPreviousCost()<oldWP.getPreviousCost()) {
                openWaypoints.put(loc, oldWP);
                return true;
            }
            return false;
        }
    }


    /** Этот метод возвращает количество точек в наборе открытых вершин. **/
    public int numOpenWaypoints() {
        return openWaypoints.size();
    }


    /**
     * Эта функция перемещает вершину из набора «открытых вершин» в набор
     * «закрытых вершин». Так как вершины обозначены местоположением, метод
     * принимает местоположение вершины.
     **/
    public void closeWaypoint(Location loc) {
        Waypoint wp = openWaypoints.remove(loc);
        closedWaypoints.put(loc, wp);
    }

    /**
     * Эта функция должна возвращать значение true, если указанное
     * местоположение встречается в наборе закрытых вершин, и false в противном
     * случае.
     **/
    public boolean isLocationClosed(Location loc) {
        return (closedWaypoints.keySet().contains(loc));
    }
}


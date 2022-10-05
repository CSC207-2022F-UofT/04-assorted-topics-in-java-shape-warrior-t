/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /**
     * Add the given Drivable object to this map under the given ID,
     * as long as the given ID is not already a key in this map.
     * If the given ID is already a key in this map, make no changes.
     *
     * @param id The key to add the object under
     * @param drivable The object to be added
     * @return Whether the object was successfully added (in other words, true if the given ID
     * was not already a key in this map and false otherwise)
     */
    public boolean addDrivable(String id, Drivable drivable){
        if(drivable_map.containsKey(id)){
            return false;
        }else{
            drivable_map.put(id, drivable);
            return true;
        }
    }

    /**
     * Return whether this map contains an item with a max speed >= the given speed.
     *
     * @param speed The speed to compare max speeds to
     * @return True iff there exists at least one item in this map for which
     * the max speed of the item is greater than or equal to the given speed
     */
    public boolean hasFasterThan(int speed){
        for(Drivable item : drivable_map.values()){
            if(item.getMaxSpeed() >= speed) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a list of all Tradable items in this map.
     *
     * @return a list of all Tradable items in this map
     */
    public List<Tradable> getTradable(){
        ArrayList<Tradable> tradables = new ArrayList<>();
        for(Drivable item : drivable_map.values()){
            if(item instanceof Tradable){
                tradables.add((Tradable) item);
            }
        }
        return tradables;
    }

}

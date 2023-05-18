package game.grounds.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DiscoverAction;
import game.actions.RestAction;
import game.enums.GroundType;
import game.enums.Status;

/**
 * A class that represents a unique ground that allows the player to rest on it. Reset the game when it happens.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class SiteOfLostGrace extends Ground {
    /**
     * Name of the Site of Lost Grace
     */
    private String name;

    /**
     * Location of the Site of Lost Grace
     */
    private Location location;

    /**
     * Discovered status of the Site of Lost Grace
     */
    private boolean discovered;

    /**
     * Constructor
     * @param name name of the Site of Lost Grace
     * @param location location of the Site of Lost Grace
     */
    public SiteOfLostGrace(String name, Location location) {
        super('U');
        this.name = name;
        this.location = location;
        this.discovered = false;
        this.addCapability(GroundType.SLG);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (!this.discovered) {
            actions.add(new DiscoverAction(this));
        }
        else if (actor.hasCapability(Status.RESTING)) {
            actions.add(new RestAction());
        }
        return actions;
    }

    /**
     * Getter for the name of the Site of lost Grace
     * @return Name of the Site of Lost Grace
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the location of the Site of lost Grace
     * @return Location of the Site of Lost Grace
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * This method changes the discovered status of the Site of Lost Grace to true
     */
    public void discover() {
        this.discovered = true;
    }
}

package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.purchase.PurchaseClub;
import game.actions.purchase.PurchaseGreatKnife;
import game.actions.purchase.PurchaseScimitar;
import game.actions.purchase.PurchaseUchigatana;
import game.enums.Status;

/**
 * A class that represents the Trader.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Trader extends Actor {

    /**
     * Constructor.
     *
     * @param name the name to call the trader in the UI
     * @param displayChar the character to represent the trader in the UI
     */
    public Trader(String name, char displayChar) {
        super(name, displayChar, 100);
        this.addCapability(Status.WILLING_TO_TRADE);
    }

    /**
     * The trader cannot move around and does nothing.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the do nothing action
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * The trader can trade weapons with any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return the list of actions the actor can do to the trader
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new PurchaseUchigatana(5000));
            actions.add(new PurchaseGreatKnife(3500));
            actions.add(new PurchaseClub(600));
            actions.add(new PurchaseScimitar(600));
        }
        return actions;
    }
}

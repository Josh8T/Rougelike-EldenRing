package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AreaAttackAction;

/**
 * A class that represents the Giant Crab enemy.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * 
 */
public class GiantCrab extends Enemy{
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    public Action getSkill() {
        return new AreaAttackAction();
    }
}
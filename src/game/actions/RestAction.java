package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class RestAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        result += new ResetAction(true).execute(actor, map);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at" + " Lost Site of Grace";
    }
}

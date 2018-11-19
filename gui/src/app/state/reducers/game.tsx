import { GameState, GameAction, NewGameAction } from "app/models";
import { initialGameState } from "../store";
import { NewGameActionTypes } from "app/models/constants";



//Generates a reducer, which the redux store uses to generate an immutable store from the previous store after an action
export const reducer = (state: GameState = initialGameState, action: GameAction): GameState => {
    switch (action.type) {
        case NewGameActionTypes.LOADING:
        case NewGameActionTypes.SUCCESS:
        case NewGameActionTypes.ERROR:
            return create(state, action);
        
        default:
            return state;
    }
};

//Actually the function to reduce the action into the new redux store
export const create = (state: GameState = initialGameState, action: NewGameAction): GameState => {
    switch (action.type) {
        case NewGameActionTypes.LOADING: {
            const { loading } = action;
            return { ...initialGameState, loading: loading };
        }

        case NewGameActionTypes.SUCCESS: {
            const { payload } = action;
            return { ...initialGameState, game: payload}
        }

        case NewGameActionTypes.ERROR: {
            const { error } = action
            return { ...initialGameState, error: error };
        }

        default: {
            return state;
        }
    }
};

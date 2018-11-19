import { NewGameActionTypes } from "../constants";

/**
 * Declearing different types used throughout the application
 * related to a Game.
 * Usually each component has one file of types related to it.
 */
export interface Game {

}

// Declearing State (redux-store)
export interface GameState {
    loading: boolean,
    game: Game,
    error?: Error
}

export interface History {
    moveNumber: number,
    whiteMove: Move,
    blackMove: Move
}

export interface Move {
    //TODO: Create move (i.e.  e4, Qd2, Rad1, Rd1, Nf6...)
}

//Declearing actions
export interface NewGameLoadingAction {
    type: NewGameActionTypes.LOADING,
    loading: boolean
}

export interface NewGameSuccessAction {
    type: NewGameActionTypes.SUCCESS,
    payload: Game
}

export interface NewGameErrorAction {
    type: NewGameActionTypes.ERROR,
    error: any
}

//Create a Type <T> which is either of the actions
export type NewGameAction = NewGameLoadingAction | NewGameSuccessAction | NewGameErrorAction;

//Create a Type <K> which is either of the Type <T>
export type GameAction = NewGameAction
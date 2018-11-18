import { NewGameActionTypes } from "../constants";

export interface Game {

}

export interface GameState {
    history?: History[];
}

export interface History {
    moveNumber: number,
    whiteMove: Move,
    blackMove: Move
}

export interface Move {
    //TODO: Create move (i.e.  e4, Qd2, Rad1, Rd1, Nf6...)
}


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

export type NewGameAction = NewGameLoadingAction | NewGameSuccessAction | NewGameErrorAction;

export type GameAction = NewGameAction